package com.prometheus.learning.io;

import java.io.*;

/**
 * A serializable object can be written into a file with ObjectOutputStream and
 * read from a file with ObjectInputStream. A serializable class has to implement
 * a Serializable interface. All non-transient fields in a serializable class
 * have to be serializable (implement Serializable) also.
 */
public class Serialization {

    public void objectInputOutputStreams() {


        /**Writing a serializable object to file */
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/main/java/learning/io/serializedObjects.dat")))) {
            SerializableClass serializableObject = new SerializableClass("Serializable object");
            objectOutputStream.writeObject(serializableObject);

            /**If the same object is written into the file twice, the object will be
             * in the file only once.
             */
        } catch(IOException e) {
            e.printStackTrace();
        }

        /**Reading a serializable object from file */
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/main/java/learning/io/serializedObjects.dat")))) {
            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    SerializableClass serializableObject = (SerializableClass)objectInputStream.readObject();
                    System.out.println(serializableObject.getName());
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }

}

class SerializableClass implements Serializable {

    /**
     * If a serializable class has non-serializable non-transient field, then
     * NotSerializableException is thrown. All primitive types and strings
     * are serializable.
     */

    /**transient keyword is used to not serialize that field */
    transient int a;

    private String name;

    /** serialVersionUID is used to check whether a class structure has changed
     *  relating to the serialized objects, and throws an exception if it has.
     *  Though jvm provides an implicit serialVersionUID for the serializable class, it is
     *  recomennded to define an explicit serializableID to prevent threads when
     *  compiling the program with different compilers. Inner classes can't be serialized .*/
    private long serialVersionUID = 35345345L;

    public SerializableClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
