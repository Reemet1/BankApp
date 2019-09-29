package com.prometheus.learning.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class NonBlockingIO {

    /**
     * In java.io package, the thread will block while it reads from or writes to stream or bugger.
     * Threads using java.nio package will not block.
     *
     */

    public void ioStreamsWithNIO() {


        /** Path class in java.nio is replacement for File class in java.io */
        /**
         *  Disadvantages of java.io.File class:
         *      * File.delete() only returns boolean and not information about the error
         *      * File.rename() is platform dependent
         *      * No support for symbolic links (folder redirections)
         *      * File class doesn't provide metadata about a file
         */
        Path filePath = FileSystems.getDefault().getPath("src/main/java/learning/io/nio/niodata.txt");

        try {
            /** BufferedReader and BufferedWriter classes of the java.io package can be
             * created with java.nio class Files and then writing and reading
             * can be done as done with java.io */
            BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath);
            BufferedReader bufferedReader = Files.newBufferedReader(filePath);

            /** Also ObjectOutputStream and ObjectInputStream objects of the java.io package can be
             *  used with output and input streams created with java.nio class Files */
            Path filePath1 = FileSystems.getDefault().getPath("src/main/java/learning/io/nio/nioSerializedObjects.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(filePath1)));
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(filePath1)));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void fileReadWriteNIO() {
        try {
            /** No recommended to use */
            //FileInputStream file = new FileInputStream("src/main/java/learning/io/nio/niodata.txt");
            //FileChannel channel = file.getChannel();

            /** Recommended way of reading all lines from a textfile */
            Path dataPath = FileSystems.getDefault().getPath("src/main/java/learning/io/nio/niodata.txt");

            /** Before writing into a file, the file has to be created. Trying to create a file that
             * already exists results in FileAlreadyExistsException, so the existence of a file
             * has to be checked beforehand */
            if(!Files.exists(dataPath)) {
                Files.createFile(dataPath);
            }

            /** Every time Files.write is called, the file is opened and closed, so it is advised
             *  to first build the string with StringBuilder and then write the whole String with Files.write.
             *  Files.write writes bytes, not text, so the string to be written needs to be converted into
             *  bytes with getBytes() method, or use Files.writeString, which takes a string argument.
             */
            String textToWrite = "Writing with NIO";
            Files.write(dataPath, textToWrite.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            //StandardOpenOption.CREATE; //creates a new file before writing into it
            //Files.writeString(dataPath, textToWrite, StandardOpenOption.APPEND);


            /** Reading all lines in a textfile. It is difficult to read just part of the file,
             * and for partial readings java.io classes have to be used. */
            List<String> lines = Files.readAllLines(dataPath);
            for(String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void byteReadWriteNIO() {
        FileOutputStream fileOutputStream = null;
        FileChannel fileChannel = null;
        try {
            fileOutputStream = new FileOutputStream("src/main/java/learning/io/nio/niobinarydata.dat");
            fileChannel = fileOutputStream.getChannel();
            byte[] outputBytes = "Hello world NIO".getBytes();

            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            int nrOfBytes = fileChannel.write(buffer);
            System.out.println("Number of bytes writter was " + nrOfBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            //throws BufferOverFlowException when the number is too large
            intBuffer.putInt(120);
            intBuffer.flip();


            /** There will be 0 bytes written without intBuffer.flip(), because the buffer index is not reset
             * with allocate() method as it is with wrap() method. */
            nrOfBytes = fileChannel.write(intBuffer);
            System.out.println("Number of bytes writter was " + nrOfBytes);


            /** Reading from random access file */
            RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/java/learning/io/nio/niobinarydata.dat", "rwd");
            FileChannel channel = randomAccessFile.getChannel();
            buffer.flip();
            long nrOfBytesRead = channel.read(buffer);
            System.out.println("bytes " + new String(outputBytes));
            if(buffer.hasArray()) {
                System.out.println("byte buffer " + new String(buffer.array()) );
            }

            nrOfBytesRead = channel.read(buffer);
            intBuffer.flip();

            /** Absolute read - buffer position remains where it was before the call getInt(0) */
            System.out.println("Absolute read " + intBuffer.getInt(0));

            /** Relative read - buffer position is changed*/
            System.out.println("Since buffer remained at 0, getInt() will get the same number: " + intBuffer.getInt());
            System.out.println("If buffer position would change, then BufferOverFlowException would occur on second read");

            buffer = ByteBuffer.allocate(outputBytes.length);
            buffer.put(outputBytes);
            //System.out.println(buffer.getInt()); //BufferOverFlowException
            /** Need to flip when allocating since allocation moves the pointer at the end of buffer */
            buffer.flip();
            System.out.println(buffer.getInt());
            buffer.flip();

            /** Another way to read bytes */
            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            readBuffer.flip();
            channel.read(buffer);
            //readBuffer.flip();
            byte[] readString = new byte[outputBytes.length];
            readBuffer.flip();
            readBuffer.get(readString);
            System.out.println("Read int " + new String(readString));

            channel.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileOutputStream != null) fileOutputStream.close();
                if(fileChannel != null) fileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void copyingFiles() {

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/java/learning/io/nio/niobinarydata.dat");
            FileChannel channel = fileInputStream.getChannel(); //Source channel
            channel.position(0);
            RandomAccessFile copyFile = new RandomAccessFile("src/main/java/learning/io/nio/niodatacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel(); //Destination channel
            //long nrTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            long nrTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Transferred: " + nrTransferred);

            fileInputStream.close();
            channel.close();
            copyFile.close();
            copyChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pipes() {
        /** Pipes are used to transfer data between threads */
        try {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i = 0; i < 10; i++) {
                            String currentTime = "The time is " + System.currentTimeMillis();
                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while(buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader thread " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
