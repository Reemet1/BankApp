package com.prometheus.learning.io;

import java.io.*;

public class IOStructure {

    public void ioStructure() throws IOException {

        /** Reading and writing byte streams */
        InputStream fileInputStream = new FileInputStream("");
        OutputStream fileOutputStream = new FileOutputStream("");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        InputStream dataInputStream = new DataInputStream(fileInputStream);
        OutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        dataInputStream = new DataInputStream(bufferedInputStream);
        dataOutputStream = new DataOutputStream(bufferedOutputStream);

        InputStream objectInputStream = new ObjectInputStream(fileInputStream);
        OutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectInputStream = new ObjectInputStream(bufferedInputStream);
        objectOutputStream = new ObjectOutputStream(bufferedOutputStream);




        /** Reading and writing characters into files */
        Reader fileReader = new FileReader("");
        Writer fileWriter = new FileWriter("");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Writer printWriter = new PrintWriter("");



        /** characters <--->< bytes */
        Reader inputStreamReader = new InputStreamReader(fileInputStream);
        Writer outputStreamWriter = new OutputStreamWriter(fileOutputStream);

        inputStreamReader = new InputStreamReader(bufferedInputStream);
        outputStreamWriter = new OutputStreamWriter(bufferedOutputStream);
    }

}
