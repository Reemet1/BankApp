package com.prometheus.learning.database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
/* The package needed for most main.java.learning.database operations */

/*
 * JDBC stands for Java Database Connectivity, which is a standard Java API for
 * main.java.learning.database-independent connectivity between the Java programming language and a wide range of databases.
 *
 * JDBC is used for:
 * - Making connections to a main.java.learning.database;
 * - Creating SQL statements;
 * - Executing SQL queries in the main.java.learning.database;
 * - Viewing and Modifying the resulting records;
 *
 * BlockChain JDBC components:
 * DriverManager - Matches connection requests from Java application with correct main.java.learning.database drivers.
 * Driver - Handles communications with main.java.learning.database servers. Rarely used directly.
 * Connection - Used for all the communication context with the main.java.learning.database.
 * Statement - Used for submitting queries to the main.java.learning.database.
 * ResultSet - An iterator that holds data retrieved from the main.java.learning.database.
 * SQLException - Handles any errors that occur in a main.java.learning.database application
 */

public class DatabaseConnection {

    /* Popular JDBC Drivers and main.java.learning.database URLs
     *  MySQL  - com.mysql.cj.jdbc.Driver        - jdbc:mysql://hostname:port/dbName
     *  Oracle - oracle.jdbc.driver.OracleDriver - jdbc:oracle:thin:@hostname:port:dbName
     *  DB2    - COM.ibm.db2.jdbc.net.DB2Driver  - jdbc:db2:hostname:port/dbName
     *  Sybase - com.sybase.jdbc.SybDriver       - jdbc:sybase:Tds:hostname:port/dbName
     */

    /* Database Driver and URL */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Northwind";

    /* Database credentials */
    private static final String USER = "root";
    private static final String PASS = "Samurai1989";

    /* These parameters are used in createStatement() and prepareStatement() methods
     * and determine the possible directions on ResultSet cursor navigation
     * and whether the ResultSet is updateable or read-only. */
    private int rsParam1 = ResultSet.TYPE_SCROLL_INSENSITIVE;
    private int rsParam2 = ResultSet.CONCUR_READ_ONLY;

    Map<String, Savepoint> savePoints = new HashMap<>();

    private Connection conn;

    /* Used for transactions. Transations allow composing multiple queries
     *   before executing all the queries in the main.java.learning.database. The benefits are
     * - increase performance;
     * - maintain the integrity of business processes;
     * - use distributed transactions. */
    private boolean autoCommit;

    /* Batch Processing allows you to group related SQL statements into a batch
     * and submit them with one call to the main.java.learning.database. When you send several SQL statements
     * to the main.java.learning.database at once, you reduce the amount of communication overhead,
     * thereby improving performance. Batching can only be used with INSERT,UPDATE,DELETE*/
    private boolean useBatching = false;
    private Statement batchedStatement;

    public DatabaseConnection() {
        this(true);
    }

    public DatabaseConnection(boolean autoCommit) {
        this.autoCommit = autoCommit;
        try {
            /* Register JDBC Driver */
            Class.forName(JDBC_DRIVER);

            /* Open a main.java.learning.database connection*/
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(autoCommit);
            batchedStatement = conn.createStatement(rsParam1, rsParam2);
        } catch (SQLException e) {
            System.err.println("ErrorCode: " + e.getErrorCode() + " ErrorMessage: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* Send a select query to the main.java.learning.database, convert the result into a multidimensional array and return it */
    private String[][] select(String sql, String ... params) {
        Statement stmt = null;
        ResultSet rs = null;
        String[][] result = null;
        try {
            if(params == null) {
                /* Querying main.java.learning.database by first creating a statement and then executing an sql with it */
                stmt = conn.createStatement(rsParam1,rsParam2);
                rs = stmt.executeQuery(sql);
            } else {
                /* A Prepared Statement is a query in which parameters can be defined and specified,
                 *  and can be used multiple times with different parameters */
                stmt = conn.prepareStatement(sql,rsParam1,rsParam2);
                for(int i = 0; i < params.length; i++) {
                    ((PreparedStatement)stmt).setString(i+1, params[i]);
                }
                rs = ((PreparedStatement)stmt).executeQuery();
            }

            result = parseResult(rs);

        } catch (SQLException e) {
            System.err.println("ErrorCode: " + e.getErrorCode() + " ErrorMessage: " + e.getMessage());
        } finally {
            try {
                /* Properly close all the test used for making a main.java.learning.database query */
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                //if(conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("ErrorCode: " + e.getErrorCode() + " ErrorMessage: " + e.getMessage());
            }
        }
        return result;
    }

    /* Send an update query to the main.java.learning.database and return the nr of updated rows */
    private int update(String sql, String ... params) {
        Statement stmt = null;
        ResultSet rs = null;
        int result = 0;
        try {
            if(params == null) {


                if(useBatching) {
                    /* Batching the sql statement for later execution */
                    batchedStatement.addBatch(sql);
                    result = 0;
                } else {
                    /* Querying main.java.learning.database by first creating a statement and then executing an sql with it */
                    stmt = conn.createStatement(rsParam1,rsParam2);
                    result = stmt.executeUpdate(sql);
                }
            } else {
                /* A Prepared Statement is a query in which parameters can be defined and specified,
                 *  and can be used multiple times with different parameters */
                if(useBatching) {
                    /* Batching the sql statement for later execution */
                    for(int i = 0; i < params.length; i++) {
                        ((PreparedStatement)batchedStatement).setString(i+1, params[i]);
                    }
                    batchedStatement.addBatch(sql);
                } else {
                    stmt = conn.prepareStatement(sql,rsParam1,rsParam2);
                    for(int i = 0; i < params.length; i++) {
                        ((PreparedStatement)stmt).setString(i+1, params[i]);
                    }
                    result = ((PreparedStatement)stmt).executeUpdate();
                }
            }

        } catch (SQLException e) {
            System.err.println("ErrorCode: " + e.getErrorCode() + " ErrorMessage: " + e.getMessage());
        } finally {
            try {
                /* Properly close all the test used for making a main.java.learning.database query */
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("ErrorCode: " + e.getErrorCode() + " ErrorMessage: " + e.getMessage());
                if(autoCommit) rollback();
            }
        }
        return result;
    }

    public String[][] callProcedure(String call, String ... params) {
        CallableStatement stmt = null;
        String[][] result = null;
        try {
            stmt = conn.prepareCall(call);
            for(int i = 0; i < params.length; i++) {
                stmt.setString(i+1, params[i]);
            }
            //stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
            ResultSet rs = stmt.executeQuery();
            result = parseResult(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String[][] parseResult(ResultSet rs) throws SQLException {
        String[][] result;

        /* If the result contains no data, return an empty multidimensional array */
        if(rs.first() == false) {
            return new String[0][0];
        }

        /*
         * Cursor navigation methods include:
         * first(), last(), beforeFirst(), afterLast()
         * absolute(int) - moves cursor to the specified index
         * relative(int) - moves the cursor relative to the current index
         * previous(), next(), getRow()
         */

        /* Move the iterator pointer to the last position to get the number or resulting rows */
        rs.last();
        result = new String[rs.getRow()][rs.getMetaData().getColumnCount()];
        rs.first();

        /* Iterate over all the result rows */
        int row = 0;
        rs.beforeFirst();
        while (rs.next()) {
            for(int col = 0; col < result[0].length; col++) {
                result[row][col] = rs.getString(col+1);
            }
            row++;
        }
        /*
         * Other ResultSet viewing methods include:
         * getXXX(index) and getXXX(columnName) where XXX represent any of the primitive data type,
         * also getDate(), getObject(), getArray(), getClob()
         * and getMetaData(), which contains information about the table's columns.
         */

        /*
         * It is possible to update the ResultSet with
         * updateXXX(index) and updateXXX(columnName) with all the same
         * data types as getXXX() methods. These methods only change the
         * ResultSet object and not the underlying rows in the main.java.learning.database.
         * To change the corresponding rows in the main.java.learning.database, use methods
         * updateRow(), deleteRow(), refreshRow().
         */


        return result;
    }



    /* Used for transactions */
    public void setAutoCommit(boolean autoCommit) {
        try {
            this.autoCommit = autoCommit;
            if(conn != null) conn.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Executes all the queries submitted in the queue */
    public void commit() {
        try {
            if(useBatching) {
                batchedStatement.executeBatch();
                batchedStatement.clearBatch();
            }
            if(conn != null) conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Removes all the queries in the queue */
    public void rollback() {
        try {
            if(conn != null) conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Removes all the queries in the queue up to the first query before the savepoint */
    public void rollback(String savepointName) {
        try {
            if(conn != null) {
                Savepoint rollbackSavepoint = savePoints.get(savepointName);
                conn.rollback(rollbackSavepoint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Creates a savepoint in the query queue which can later be returned back to with rollback */
    public void save(String savepointName) {
        try {
            if(conn != null) {
                Savepoint savepoint = conn.setSavepoint(savepointName);
                savePoints.put(savepointName, savepoint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearSavepoints() {
        savePoints.clear();
    }

    public void clearSavepoint(String savpointName) {
        Savepoint savepoint = savePoints.get(savpointName);
        try {
            conn.releaseSavepoint(savepoint);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBatching(boolean useBatching) {
        try {
            if(conn.getMetaData().supportsBatchUpdates()) {
                this.useBatching = useBatching;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[][] selectQuery(String sql) {
        return select(sql, null);
    }

    public String[][] selectQuery(String sql, String ... params) {
        return select(sql,params);
    }

    public int updateQuery(String sql) {
        return update(sql, null);
    }

    public int updateQuery(String sql, String ... params) {
        return update(sql, params);
    }

}

/*Data Type conversions between SQL and JDBC */

/*SQL          JDBC/Java           xxx = get,set,update
 * VARCHAR	    String	            xxxString
 * CHAR	        String	            xxxString
 * LONGVARCHAR	String	            xxxString
 * BIT	        boolean	            xxxBoolean
 * NUMERIC	    BigDecimal	        xxxBigDecimal
 * TINYINT	    byte	            xxxByte
 * SMALLINT	    short	            xxxShort
 * INTEGER	    int	                xxxInt
 * BIGINT	    long	            xxxLong
 * REAL	        float	            xxxFloat
 * FLOAT	    float	            xxxFloat
 * DOUBLE	    double	            xxxDouble
 * VARBINARY	byte[]	            xxxBytes
 * BINARY	    byte[]	            xxxBytes
 * DATE	        java.sql.Date	    xxxDate
 * TIME	        java.sql.Time	    xxxTime
 * TIMESTAMP	java.sql.Timestamp	xxxTimestamp
 * CLOB	        java.sql.Clob	    xxxClob
 * BLOB	        java.sql.Blob	    xxxBlob
 * ARRAY	    java.sql.Array	    xxxARRAY
 * REF	        java.sql.Ref	    xxxRef
 * STRUCT	    java.sql.Struct	    xxxStruct
 */


