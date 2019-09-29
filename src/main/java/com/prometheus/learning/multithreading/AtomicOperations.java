package com.prometheus.learning.multithreading;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicOperations {

    public void atomicOperations() {
        /**
         * JVM can suspend a thread at any time, even on a single line, if that line represents
         * a method or multiple operations. There are a few operations which are atomic,
         * that means that these operations are performed with a single cycle, in
         * which the thread can not be suspended. These atomic operations are:
         * 1) reading and writing reference variables, e.t myObj1 = myObj2
         * 2) reading and writing primitive variables except long and double, e.g myInt = 10
         * 3) reading and writing variables defined with 'volatile' keyword
         */

        /** There are special classes to manipulate primitives atomically. When no-parameter
         *  constructor is used, the default values are used */

        AtomicInteger atomicInteger = new AtomicInteger(1);
        AtomicLong atomicLong = new AtomicLong(1);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AtomicReference<String> atomicReference = new AtomicReference<>("String");

        /** All methods in AtomicXXX class are atomic*/

        /** Extracting values from Atomic objects */
        int extractedInt = atomicInteger.get();
        long extractedLong = atomicLong.get();
        boolean extractedBoolean = atomicBoolean.get();
        String extractedStr = atomicReference.get();

        /** Compares current atomic value to first parameter and changes it to parameter 2 when matched */
        atomicReference.compareAndSet("String", "NewString");

        /** set() and getAndSet() are used to set new value to Atomic object */
        atomicBoolean.set(false); //does not return anything
        boolean previousBool = atomicBoolean.getAndSet(true);

        /** Also available for atomicLong */
        atomicInteger.addAndGet(10);
        atomicInteger.addAndGet(10);
        atomicInteger.incrementAndGet();
        atomicInteger.getAndIncrement();
        atomicInteger.decrementAndGet();
        atomicInteger.getAndDecrement();

        /** These methods are used on all Atomics except booleans */

        /** Takes binary operator, which operates on given parameter and current value, where
         *  s1 == currentValue and s2 == parameter */
        String resultStr1 = atomicReference.accumulateAndGet("Welcome to", (s1,s2) -> s1+s2);
        String resultStr2 = atomicReference.getAndAccumulate("Welcome to", (s1,s2) -> s1+s2);

        /** Takes unary operator, updates the Atomic object with the result of the given lambda operation */
        String newStr1 = atomicReference.getAndUpdate(str -> str.toUpperCase());
        int newInt = atomicInteger.updateAndGet(i -> 5*i);
    }


}
