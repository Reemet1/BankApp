package com.prometheus.platform.math;

public class Matrices {


    public static Matrix multiply(Matrix m1, Matrix m2) {
        double[][] product = new double[m1.rows()][m2.cols()];
        for(int i = 0; i < m1.rows(); i++) {
            for(int j = 0; j < m2.cols(); j++) {
                for(int k = 0; k < m2.rows(); k++) {
                    product[i][j] += m1.get(i,k)*m2.get(k,j);
                }
            }
        }
        return new Matrix(product);
    }

    public static Matrix getRotMatrix(double angle) {
        double[][] rotMatrix = {
                {Math.cos(angle), -Math.sin(angle)},
                {Math.sin(angle),  Math.cos(angle)}
        };
        return new Matrix(rotMatrix);
    }

    /**
     * Return the sum of matrices m1 and m2, that is the matrix with the same dimension as m1,m2
     * and whose entries (m1+m2)_{ij} = m1_{ij} + m2_{ij}.
     */
    public static Matrix add(Matrix m1, Matrix m2) {
        double[][] mat = new double[m1.rows()][m2.cols()];

        for(int i = 0; i < m1.rows(); i++) {
            for(int j = 0; j < m1.cols(); j++) {
                mat[i][j] = m1.get(i,j) + m2.get(i,j);
            }
        }
        return new Matrix(mat);
    }

    /**
     * Return the difference of matrices m1 and m2, that is the matrix with the same dimension as m1,m2
     * and whose entries (m1+m2)_{ij} = m1_{ij} - m2_{ij}.
     */
    public static Matrix substr(Matrix m1, Matrix m2) {
        double[][] mat = new double[m1.rows()][m2.cols()];

        for(int i = 0; i < m1.rows(); i++) {
            for(int j = 0; j < m1.cols(); j++) {
                mat[i][j] = m1.get(i,j) - m2.get(i,j);
            }
        }
        return new Matrix(mat);
    }

}
