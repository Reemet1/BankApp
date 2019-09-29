package com.prometheus.learning.io;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Input and output streams are a flow of data. A stream has a source, from where the
 * information is put into the stream, and destination, to where the information
 * is being passed through the stream.
 */

public class InputOutputStreams {

    /** There are 2 types of streams: byte streams and character streams. Character streams are
     * used to write textual data (human readable) and is appropriate for xml, json, txt files, etc.
     */

    public void inputOutputStreams() {

        /** Standard console input output streams */
        InputStream is = System.in;
        PrintStream os = System.out;
        PrintStream es = System.err;

        Console console = System.console();
        if(console != null) {
            console.printf("Tere %s", "maailm");
            console.format("tere %s", "jah");
            String line = console.readLine("Enter line");
            char[] password = console.readPassword();
        }

        /**Standard streams are byte-based, while console is character-based */

    }

    public void files() {

        /** Files represent a file or directory path */
        File file = new File("file.txt");

        try{
            if(!file.exists()) {
                file.createNewFile();
                file.delete();
            }


            File dir = new File("dirFolder");
            dir.mkdir(); //creates a single folder dirFolder
            dir.mkdirs(); //creates the specified folders + all nonexistent parent folders

        } catch (IOException e) {

        }

    }

    /** There are 2 types of files: serial a.k.a sequential and random access files. Data flows in
     * sequential file in an ordered, sequential manner, while in random access file the
     * data can be accessed and modified at any location of the file. */

    public void fileReaderWriter() {

        /** FileWriter is used to write data into the data.txt file (file with characters) */
        FileWriter fileWriter = null;
        try {
            /** Default path is /Learning/ */
            fileWriter = new FileWriter("src/main/java/learning/io/data.txt", false);
            fileWriter.write("HelloFile");
            fileWriter.append("Hi");
            fileWriter.flush();
        } catch(IOException e) {
            /** IO classes throw IOEXception, which are checked exceptions
             * and have to be handled */
            e.printStackTrace();
        } finally {
            try {
                /** Close all the resources that are not being used anymore, otherwise
                 * it might cause data leaks and corruptions and locked files */
                if(fileWriter != null) {
                    fileWriter.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }


        /** AutoCloseable resources can also be defined with try (try with resources), and they will be closed
         * automatically when exiting try or finally block. Multiple resources can be opened in a
         * try with resources, separating them with semicolon.
         */
        try(FileReader fileReader = new FileReader("src/main/java/learning/io/data.txt");
            Scanner scanner = new Scanner(fileReader)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            /** Reading data into 10 char buffer */
            char[] buffer = new char[10];
            fileReader.read(buffer);

            /** scanner.close() also closes the resources (if they implement Closeable)
             * given in the constructor (filereader) */
            //scanner.close();
        } catch(IOException e) {
        }
    }

    public void bufferedReaderWriter() {

        /** Instead of writing data character by character, a buffered writer enables
         *  to write data by chunks of characters, which is more effective.
         */
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/learning/io/data.txt"))) {
            bufferedWriter.write("HelloFile");
        } catch(IOException e) {
            e.printStackTrace();
        }

        /** Instead of reading data character by character, a buffered reader enables
         *  to read data by chunks of characters, which is more effective.
         */
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/learning/io/data.txt"))) {
            String input;

            while((input = bufferedReader.readLine()) != null) {
                System.out.println(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Reading file without scanner */
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("src/main/java/learning/io/data.txt")));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }

    }

    public void fileInputOutpuStreams() {

        try {
            FileOutputStream fos = new FileOutputStream("data.bat");
            byte[] buffer = "Text into file".getBytes();
            fos.write(buffer);
            fos.flush();
            fos.close();
        } catch (IOException e) {

        }

        try {
            FileInputStream fis = new FileInputStream("data.bat");
            byte[] buffer = new byte[100];
            fis.read(buffer);
            System.out.println(new String(buffer));
            fis.close();
        } catch (IOException e) {

        }

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("Printing text");
        printWriter.flush();
        printWriter.close();



    }

    public void byteStreams() {
        /** Byte streams read and write binary data. As with reader and writer, byte streams
         * and also be buffered to read chunks of bytes instead of single bytes. To read
         * files with byte streams, the format and order of data in the file has to be known*/

        /**Writing binary data to .bin file */
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src/main/java/learning/io/binarydata.dat")))) {
            dataOutputStream.writeInt(1);
            dataOutputStream.writeUTF("HelloByteStream");

        } catch(IOException e) {
            e.printStackTrace();
        }

        /**Reading binary data from .bin file */
        try(DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("src/main/java/learning/io/binarydata.dat")))) {

            boolean endOfFile = false;

            /** The loop will be exited when encountering an exception or when endOfFile == true */
            while(!endOfFile) {
                try {
                    int nr = dataInputStream.readInt();
                    String str = dataInputStream.readUTF(); //read string
                    System.out.println(nr + " " + str);
                } catch(EOFException e) {
                    endOfFile = true;
                }
            }
        } catch(IOException e) {
            System.out.println("IO Exception");
        }
    }

    public void randomAccessFile() {

        /** RandomAccessFile is used to create a file that enables to read bytes at any given location in that file.
         * The parameter 'rwd' means read and write synchronously */
        try(RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/java/learning/io/random_access_file.dat", "rwd")) {

            /**This will be written first, so that reader knows how many entries there are in a file */
            int nrOfEntries = 10;
            Map<Integer, int[]> indexes = new LinkedHashMap<>();

            randomAccessFile.writeInt(nrOfEntries);
            /** Reserve a space of bytes needed to save the description of the locations
             * of all the entries. For each entry save the indexNr, startIndex and entryLength as integers
             */
            int indexSize = 3 * nrOfEntries * Integer.BYTES;

            /**From locationStart the entries are written */
            int locationStart = (int)(indexSize + randomAccessFile.getFilePointer() + Integer.BYTES);
            randomAccessFile.writeInt(locationStart);

            long indexStart = randomAccessFile.getFilePointer();

            int startPointer = locationStart;
            /** Moves the pointer to given index */
            randomAccessFile.seek(startPointer);

            for(int i = 1; i <= 10; i++) {
                /**Writing entries */
                randomAccessFile.writeInt(i);
                /** writeUTF first writes an int describing the length of this string, so
                 * when later using readUTF(), it first reads the int to know how many
                 * bytes of string to read
                 */
                randomAccessFile.writeUTF("Entry " + i);

                int entryStartIndex = (int)startPointer;
                int entryLength = (int)(randomAccessFile.getFilePointer() - startPointer);
                indexes.put(i, new int[]{entryStartIndex, entryLength});

                startPointer = (int)randomAccessFile.getFilePointer();
            }

            /**After the indexes of entries are known, they are filled into the indexes secion of the file */
            randomAccessFile.seek(indexStart);
            for(Integer key : indexes.keySet()) {
                randomAccessFile.writeInt(key);
                randomAccessFile.writeInt(indexes.get(key)[0]);
                randomAccessFile.writeInt(indexes.get(key)[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Reading from random access file */
        try(RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/java/learning/io/random_access_file.dat", "rwd")) {
            /**Get the number of entries in a file */
            int nrOfEntries = randomAccessFile.readInt();
            Map<Integer, int[]> indexes = new LinkedHashMap<>();

            long entryStartPoint = randomAccessFile.readInt();
            /** Read the index section of the file to get all the locations and lengths
             * of the entries. */
            /*while(randomAccessFile.getFilePointer() < entryStartPoint) {
                int index = randomAccessFile.readInt();
                int entryStartIndex = randomAccessFile.readInt();
                int entryLength = randomAccessFile.readInt();
                indexes.put(index, new int[]{entryStartIndex, entryLength});
            } */

            for(int i = 0; i < nrOfEntries; i++) {
                int index = randomAccessFile.readInt();
                int entryStartIndex = randomAccessFile.readInt();
                int entryLength = randomAccessFile.readInt();
                indexes.put(index, new int[]{entryStartIndex, entryLength});
            }

            /**Loop through the indexes and search for a specific location on that file according
             * to the given index (start byte + entry length)
             */
            for(Integer index : indexes.keySet()) {
                randomAccessFile.seek(indexes.get(index)[0]);
                int nr = randomAccessFile.readInt();
                String entry = randomAccessFile.readUTF();
                System.out.println("Nr " + nr + " and entry = " + entry);
            }

            /*for(Integer index : indexes.keySet()) {
                int a = randomAccessFile.read(new byte[]{}, indexes.get(index)[0], indexes.get(index)[1]);
                System.out.println(a);
            } */

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
