package com.prometheus.learning.lang.interfaces;

import java.util.Arrays;

/**
 * A CharSequence is a readable sequence of char values.
 * This interface provides uniform, read-only access to many different kinds of char sequences.
 * CharSequence interface does not refine the general contracts of the equals and hashCode methods.
 * It is therefore inappropriate to use arbitrary CharSequence instances as elements in a set or as keys in a map.
 */
public class CharSequenceImpl implements CharSequence {

    char[] charSeq;

    public void testCharSeq() {

        CharSequence csq = new CharSequenceImpl("123");
        System.out.println(csq.length());
        System.out.println(csq.charAt(0));
        System.out.println(csq.subSequence(0,3));

    }

    public CharSequenceImpl() {
        charSeq = new char[1];
    }

    public CharSequenceImpl(char[] charArray) {
        charSeq = charArray;
    }

    public CharSequenceImpl(String str) {
        charSeq = str.toCharArray();
    }

    @Override
    public int length() {
        return charSeq.length;
    }

    @Override
    public char charAt(int index) {
        return charSeq[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        charSeq = Arrays.copyOfRange(charSeq, start, end);
        return this;
    }

    @Override
    public String toString() {
        return Arrays.toString(charSeq);
    }
}
