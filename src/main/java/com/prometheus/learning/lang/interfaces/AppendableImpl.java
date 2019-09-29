package com.prometheus.learning.lang.interfaces;

import java.io.*;
import java.util.Arrays;

/**
 * Implementations of Appendable interface can append sequence of characters to streams, arrays or sequences.
 */


public class AppendableImpl implements Appendable {

    char[] array;
    PrintStream os;
    String str;

    public void testAppending() throws IOException {
        AppendableImpl appendable = new AppendableImpl();
        System.out.println(appendable.append("String"));
        System.out.println(appendable.append('1'));
    }

    @Override
    public Appendable append(CharSequence csq) throws IOException {
        append(csq, 0, csq.length());
        return this;
    }

    @Override
    public Appendable append(char c) throws IOException {
        append(Character.toString(c), 0, 1);
        return this;
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        appendToArray(csq, start, end);
        appendToString(csq, start, end);
        appendToStream(csq, start, end);

        return this;
    }

    private void appendToStream(CharSequence csq, int start, int end) throws IOException {
        if(os == null) os = System.out;
        os.append(csq, start, end);
    }

    private void appendToString(CharSequence csq, int start, int end) {
        if(str == null) str = csq.toString().substring(start,end);
        else str += csq.toString().substring(start,end);
    }

    private void appendToArray(CharSequence csq, int start, int end) {
        CharSequence subCsq = csq.subSequence(start,end);

        if(array == null) {
            array = new char[subCsq.length()];
            for(int i = 0; i < array.length; i++) {
                array[i] = subCsq.charAt(i);
            }
        } else {
            int oldLength = array.length;
            array = Arrays.copyOf(array, array.length + subCsq.length());
            for(int i = oldLength; i < array.length; i++) {
                array[i] = subCsq.charAt(i-oldLength);
            }
        }
    }

    @Override
    public String toString() {
        return (array == null) ? "null" : Arrays.toString(array);
    }

    public String getString() {
        return str;
    }
}
