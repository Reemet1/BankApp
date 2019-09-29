package com.prometheus.learning.lang.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * A class implementing Readable transports data into CharBuffer via read().
 */
public class ReadableImpl implements Readable {

    char[] data;
    int pointer = 0;

    public ReadableImpl(String str) {
        data = str.toCharArray();
    }

    @Override
    public int read(CharBuffer cb) throws IOException {

        while (pointer < data.length && cb.hasRemaining()) {
            cb.put(data[pointer]);
            pointer++;
        }
        return cb.length();
    }

    public void testReadable() throws IOException {

        Readable readable = new ReadableImpl("DataString");
        CharBuffer buffer = CharBuffer.allocate(5);
        readable.read(buffer);
        for(int i = 0; i < buffer.position(); i++) {
           System.out.print(buffer.get(i));
        }
    }
}
