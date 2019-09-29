package com.prometheus.learning.lang;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Every Java application has a single instance of class Runtime that allows the
 * application to interface with the environment in which the application is running.
 * Note that this class is not synchronized. If multiple threads access a ProcessBuilder instance concurrently,
 * and at least one of the threads modifies one of the attributes structurally, it must be synchronized externally.
 */
public class RuntimeClass {

    public void runtimeMethod() throws InterruptedException {

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Available processors: " + runtime.availableProcessors());
        System.out.println("Free memory: " + runtime.freeMemory());
        System.out.println("Max memory: " + runtime.maxMemory());
        System.out.println("Total memory: " + runtime.totalMemory());

        //runtime.exit(1); //exits the process

        /**
         * Writing into process (currently command prompt) and reading from it.
         * Caution: deadlock may occur when dealing with process input and output streams.
         */
        try {
            Process process = Runtime.getRuntime().exec ("cmd.exe");

            //process.destroy();
            //process.destroyForcibly();
            //process.waitFor(); //current thread waits for the process to terminate

            OutputStream out = process.getOutputStream ();
            InputStream err = process.getErrorStream ();
            InputStream in = process.getInputStream ();

            BufferedReader reader = new BufferedReader (new InputStreamReader(in));
            BufferedReader errReader = new BufferedReader (new InputStreamReader(err));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            Scanner scan = new Scanner(System.in);
            String input;
            int ch;

            while(true) {
                Thread.sleep(100);

                while(reader.ready()) {
                    ch = reader.read();
                    System.out.print(Character.toString((char)ch));
                }
                while(errReader.ready()) {
                    ch = errReader.read();
                    System.out.print(Character.toString((char)ch));
                }

                System.out.println();

                input = scan.nextLine();
                input += "\n";
                writer.write(input);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Launches external Java application with parameters and reads incoming data.
     */
    public void processBuilder(String argument) throws IOException, InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder("java","-cp","C:\\Users\\Reemet\\Desktop","TestClass","Tere " + argument);
        List<String> arguments = processBuilder.command(); //returns arguments given to processBuilder
        //Instead of constructor the arguments can also be given with command() method.
        //processBuilder.command("java","-cp","C:\\Users\\Reemet\\Desktop","TestClass","Tere " + argument);
        processBuilder.environment(); //returns a map of OS environment variable keys and values

        Process process = processBuilder.start();

        InputStream err = process.getErrorStream ();
        InputStream in = process.getInputStream ();

        BufferedReader reader = new BufferedReader (new InputStreamReader(in));
        BufferedReader errReader = new BufferedReader (new InputStreamReader(err));

        Thread.sleep(1000);
        int ch;

        while(reader.ready()) {
            ch = reader.read();
            System.out.print(Character.toString((char)ch));
        }
        while(errReader.ready()) {
            ch = errReader.read();
            System.out.print(Character.toString((char)ch));
        }

        /**
         * Output of the process can be redirected to different output format, e.g to a log file.
         */
        File log = new File("C:\\Users\\Reemet\\Desktop\\log.txt");
        processBuilder.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        processBuilder.start();
    }

}


