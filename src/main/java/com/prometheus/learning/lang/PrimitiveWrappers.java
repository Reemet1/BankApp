package com.prometheus.learning.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper classes turn corresponding primitives into wrapped objects.
 * Wrapping provides more functionality to primitives.
 */
public class PrimitiveWrappers {

    public void wrappers() {

        /** Primitive datatypes boolean, byte, short, int, long, float, double are wrapped by
         * Boolean, Byte, Short, Integer, Long, Float, Double
         */

        Boolean wrappedBoolean = true;
        Byte wrappedByte = Byte.valueOf((byte)1);
        Short wrappedShort = Short.valueOf((short)1);
        Integer wrappedInteger = Integer.valueOf(1);
        Long wrappedLong =  Long.valueOf(1L);
        Float wrappedFloat = Float.valueOf(1f);
        Double wrappedDouble = Double.valueOf(1d);
        Character wrappedChar = Character.valueOf('a');

        /** Each numeric wrapper class has static fields for min and max values and nr of bytes */
        Integer maxInt = Integer.MAX_VALUE;
        Integer minInt = Integer.MIN_VALUE;
        Integer nrOfBytes = Integer.SIZE;
        Integer bytes = Integer.BYTES;

        /** Each numerical wrapped value can be converted to other primitive types */
        byte converted1 = wrappedInteger.byteValue();
        short converted2 = wrappedInteger.shortValue();
        int converted3 = wrappedInteger.intValue();
        long converted4 = wrappedInteger.longValue();
        float converted5 = wrappedInteger.floatValue();
        double converted6 = wrappedInteger.doubleValue();

        char charValue = wrappedChar.charValue();
        String charString = wrappedChar.toString();

        /** Each wrapped value can be constructed from String and can be converted to String */
        Integer integerFromString = new Integer("10");
        Integer parsedInteger1 = Integer.parseInt("10");
        Integer parsedInteger2 = Integer.valueOf("10");
        String integerString = wrappedInteger.toString();

        /** For Float and Double it is possible to check is the value is infinite or NaN */
        boolean isInfinite = wrappedDouble.isInfinite();
        boolean isNaN = wrappedDouble.isNaN();

    }

    public void autoBoxing() {

        /** Autoboxing is an automatic conversion by the compiler where primitive values
         *  are converted into wrapped object (boxing) or wrapped object is converted
         *  into primitive value (unboxing).
         */

        /** Autoboxing by assignment*/
        Integer boxedInt = 10;

        /** int cannot be boxed to Double */
        //Double d = 10;
        Double d = 10.0;

        /** Unboxing by assigment*/
        int unboxedInt = boxedInt;
        int unboxedInt2 = Integer.valueOf(10);

        /** Wrappers and primitives can be compared, in which wrapped object will be unboxed */
        boolean comparing = boxedInt == unboxedInt;

        /** When doing calculations, the wrapped values are unboxed also */
        int sum = boxedInt + 1;

        /** Unboxing also happens when wrapped object is given as a parameter where primitive value is expected */
        method1(boxedInt);

        /** Boxing also happens when primitive value is given as a parameter where wrapper object is expected */
        method2(1);

        /** At compile time primitiveValue <--> WrapperType.valueOf(primitiveValue)
         *          and WrapperType object <--> object.xxxValue()*/


        List<Integer> intList = new ArrayList<>();

        /** Unboxing also happens in foreach loop */
        for(int i : intList) {

        }

        /** NullPointerException occurs */
        Integer nullInteger = null;
        int testInt = nullInteger;

    }

    public void method1(int primitiveParameter) {
        System.out.println(primitiveParameter + 1);
    }
    public void method2(Integer wrappedParameter) {
        System.out.println(wrappedParameter + 1);
    }


    public void staticWrapperMethods() {

        /** static int	bitCount(int i) */
        /* Returns the number of one-bits in the two's complement binary representation of
           the specified int value. */

        /** static int	compare(int x, int y) */
        // Compares two int values numerically.

        /** int	compareTo(Integer anotherInteger) */
        // Compares two Integer objects numerically.

        /** static int	compareUnsigned(int x, int y) */
        // Compares two int values numerically treating the values as unsigned.

        /** static Integer	decode(String nm) */
        // Decodes a String into an Integer.

        /** static int	divideUnsigned(int dividend, int divisor) */
        /* Returns the unsigned quotient of dividing the first argument by the second
           where each argument and the result is interpreted as an unsigned value. */

        /** static Integer	getInteger(String nm) */
        // Determines the integer value of the system property with the specified name.

        /** static Integer	getInteger(String nm, int val) */
        // Determines the integer value of the system property with the specified name.

        /** static Integer	getInteger(String nm, Integer val) */
        // Returns the integer value of the system property with the specified name.

        /** static int	hashCode(int value) */
        // Returns a hash code for a int value; compatible with Integer.hashCode().

        /** static int	highestOneBit(int i) */
        /* Returns an int value with at most a single one-bit, in the position of
           the highest-order ("leftmost") one-bit in the specified int value. */

        /** static int	lowestOneBit(int i) */
        /* Returns an int value with at most a single one-bit, in the position of
           the lowest-order ("rightmost") one-bit in the specified int value. */

        /** static int	max(int a, int b) */
        // Returns the greater of two int values as if by calling Math.max.

        /** static int	min(int a, int b) */
        // Returns the smaller of two int values as if by calling Math.min.

        /** static int	numberOfLeadingZeros(int i) */
        /* Returns the number of zero bits preceding the highest-order ("leftmost")
           one-bit in the two's complement binary representation of the specified int value. */

        /** static int	numberOfTrailingZeros(int i) */
        /* Returns the number of zero bits following the lowest-order ("rightmost")
           one-bit in the two's complement binary representation of the specified int value. */

        /** static int	parseInt(String s) */
        // Parses the string argument as a signed decimal integer.

        /** static int	parseInt(String s, int radix) */
        // Parses the string argument as a signed integer in the radix specified by the second argument.

        /** static int	parseUnsignedInt(String s) */
        // Parses the string argument as an unsigned decimal integer.

        /** static int	parseUnsignedInt(String s, int radix) */
        // Parses the string argument as an unsigned integer in the radix specified by the second argument.

        /** static int	remainderUnsigned(int dividend, int divisor) */
        /* Returns the unsigned remainder from dividing the first argument by the second
           where each argument and the result is interpreted as an unsigned value. */

        /** static int	reverse(int i) */
        /* Returns the value obtained by reversing the order of the bits
           in the two's complement binary representation of the specified int value. */

        /** static int	reverseBytes(int i) */
        /* Returns the value obtained by reversing the order of the bytes in the two's
           complement representation of the specified int value. */

        /** static int	rotateLeft(int i, int distance) */
        /* Returns the value obtained by rotating the two's complement binary representation of the
           specified int value left by the specified number of bits. */

        /** static int	rotateRight(int i, int distance) */
        /* Returns the value obtained by rotating the two's complement binary representation of the
           specified int value right by the specified number of bits. */

        /** static int	signum(int i) */
        // Returns the signum function of the specified int value.

        /** static int	sum(int a, int b) */
        // Adds two integers together as per the + operator.

        /** static String	toBinaryString(int i) */
        // Returns a string representation of the integer argument as an unsigned integer in base 2.

        /** static String	toHexString(int i) */
        // Returns a string representation of the integer argument as an unsigned integer in base 16.

        /** static String	toOctalString(int i) */
        // Returns a string representation of the integer argument as an unsigned integer in base 8.

        /** static String toString(int i) */
        // Returns a String object representing the specified integer.

        /** static String	toString(int i, int radix) */
        // Returns a string representation of the first argument in the radix specified by the second argument.

        /** static long	toUnsignedLong(int x) */
        // Converts the argument to a long by an unsigned conversion.

        /** static String	toUnsignedString(int i) */
        // Returns a string representation of the argument as an unsigned decimal value.

        /** static String	toUnsignedString(int i, int radix) */
        /* Returns a string representation of the first argument as an unsigned integer value in the
           radix specified by the second argument. */

        /** static Integer	valueOf(int i) */
        // Returns an Integer instance representing the specified int value.

        /** static Integer	valueOf(String s) */
        // Returns an Integer object holding the value of the specified String.

        /** static Integer	valueOf(String s, int radix) */
        /* Returns an Integer object holding the value extracted from the specified String
           when parsed with the radix given by the second argument. */


    }



}
