package com.prometheus.learning.lang;

public class Maths {


    public void maths() {

        /** The class Math contains static methods for performing basics numeric operations such as
         *  the elementary exponential, logarithm, square root, and trigonometric functions.
         */
        Math.abs(1);
        Math.signum(1);

        Math.min(2,3);
        Math.max(1,2);


        Math.toDegrees(1); Math.toRadians(1);

        Math.exp(2); //e to the power 2
        Math.pow(2,3);
        Math.sqrt(2);
        Math.log10(1); //log base 10
        Math.log(1); //log base e

        Math.round(1.3);
        Math.ceil(2.5);
        Math.floor(2.4);

        Math.sin(1); Math.asin(1); Math.sinh(1);
        Math.cos(2); Math.acos(2); Math.cosh(2);
        Math.tan(3); Math.atan(3); Math.tanh(3);

        Math.random();
        double e = Math.E;
        double pi = Math.PI;

        Math.ulp(2.3898930);

        /** Unlike some of the numeric methods of class StrictMath, all implementations of the equivalent
         *  functions of class Math are not defined to return the bit-for-bit same results.
         *  This relaxation permits better-performing implementations where strict reproducibility is not required. */

        StrictMath.abs(1);
        StrictMath.signum(2);
        StrictMath.toDegrees(1); //etc...
    }

    public void numbers() {

        /** All numeric wrapper classes Byte, Short, Int, Long, Float and Double are
         *  subclasses of abstract class Number.
         */
        Number nr = new Integer(1);

        /** Numbers can be presented in decimal, binary, octal and hexadecimal form. */
        int decimal = 254;
        int binary = 0b1111; //Binary presentation starts with 0b and describes bits with 0 and 1
        int octal = 0473; //Octal presentation starts with 0 and can contain only numbers from 0 to 7
        int hexaDecimal = 0xEF2; /*HexaDecimal presentation starts with 0x and can contain
        numbers from 0 to 9 and letters from A to F */
    }

    public void overflow() {

        /** Overflow happens if a result of an arithmetic operation returns a result
         *  that is over the max or below the min value that the corresponding primitive type can hold.
         *  In that case the result will reset to the other side of the value spectrum. */

        int sum = Integer.MAX_VALUE + 1; // = -2147483648

        /** To limit such possibilities the arithmetic on the numbers can be done with exact methods,
            which throw ArithmeticException when overflow occurs. */

        Math.addExact(Integer.MAX_VALUE,1); //ArithmeticException
        Math.subtractExact(Integer.MIN_VALUE,-1); //ArithmeticException
        Math.multiplyExact(Integer.MAX_VALUE, 2); //ArithmeticException
        Math.incrementExact(Integer.MAX_VALUE); //ArithmeticException
        Math.decrementExact(Integer.MIN_VALUE); //ArithmeticException

    }

}
