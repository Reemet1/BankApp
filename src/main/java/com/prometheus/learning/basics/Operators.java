package com.prometheus.learning.basics;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Operators {

    public void operators() {

        //ARITHMETIC OPERATORS

        double operand1 = 10;
        double operand2 = 15;

        double sum = operand1 + operand2; //addition
        double difference = operand1 - operand2; //substraction
        double product = operand1 * operand2; //multiplication
        double quotient = operand1 / operand2; //division

        double remainder = operand2 % operand1; //remainder is 5

        System.out.println(2*-3+4*--sum+(product=2));

        sum++; //post-increment: evaluate and increment by 1
        ++sum; //pre-increment: increment by 1 and evaluate
        sum--; //post-decrement: evaluate and decrement by 1
        --sum; //pre-decrement: decrement by 1 and evaluate

        int nr1 = +3;
        int nr2 = -3;
        int nr3 = -+2;
        int nr4 = +-2;
        int nr5 = -+-+-+2;

        double NaN = 0.0/0.0; //NaN
        double infty = 1/0.0; //Infinity
        Double.isNaN(NaN); //true
        Double.valueOf(NaN).isNaN(); //true
        Double.isInfinite(infty); //true
        Double.valueOf(infty).isInfinite(); //true
        boolean isGreater = 1/0.0 > Integer.MAX_VALUE; //true
        boolean compareInfinities = 0.0/0.0 < 0.0/0.0; //false
        boolean compare1 = 0.0/0.0 < 0.0/0.0; //false
        boolean compare2 = 0.0/0.0 < 0/0.0; //false

        Double infDouble = 1.0/0.0;

        //double invalidDouble = 1/0; //ArithmeticException

        //int nr6 = ++-2; //invalid
        int a = 5;
        double abc = -+-+3_43.39___3E002*(a=!!('@'<3)?2|3^2:1);

        /** NB! i = i++ does not increase i, it will still be 0*/
        int i = 0;
        i = i++;
        System.out.println("i = " + i);

        //ASSIGNMENT OPERATORS

        sum += 2; //add and assign
        sum -= 2; //substract and assign
        sum *= 2; //multiply and assign
        sum /= 2; //divide and assign
        sum %= 2; //find remainder and assign

        short sh = 2;
        int myInt1 = 5;

        //sh = sh+myInt1; //invalid, cannot refer int to short
        sh += myInt1; //works because of implicit casting: sh = (short)(sh+myInt1)

        /** Assignment returns a value that was assigned */
        int nr11;
        int nr22 = nr11 = 10; //nr2 = 10 and nr2 = 10;


        //COMPARE OPERATORS

        boolean equalRef = (sum == sum); //compare variable references - equals, true
        boolean unequalRef = (sum != sum); //compare variable references - not equal, false

        int intVal = 10;
        boolean boolVal = false;
        /*if(intVal = 2) {
            System.out.println("Not valid");
        } */
        if(boolVal = true) { //this is valid
            System.out.println(boolVal);
        }
        System.out.println("Assignment returns the assigned value: " + (boolVal = true));
        System.out.println("Assignment returns the assigned value: " + (intVal = 20));

        boolean greater = 2 > 1;
        boolean less = 1 < 2;
        boolean greatereq = 2 >= 1;
        boolean lesseq = 1 <= 2;
        boolean equal = 1 == 1;
        //equal = new String() == new StringBuilder(); //Different type objects cannot be compared
        equal = new HashMap<>() == new LinkedHashMap<>(); //Superclass object can be compared with subclass

        /** chars can be compared with numbers */
        boolean charNr = 'A' == 2;

        /** == vs .equals(), == on primitives compare their values, but on objects
         * == compare their references (locations in memory).
         * .equals() comparation is defined in each class separately,
         *  but use .equals of Object class if it is not present in current class.
         *  In Object class .equals compares object hash codes (reference)
         */

        Integer myInteger1 = new Integer(10);
        Integer myInteger2 = new Integer(10);
        System.out.println(myInteger1 == myInteger2); //false
        System.out.println(myInteger1.equals(myInteger2)); //true
        int my1Int = 10;
        System.out.println(my1Int == myInteger1); //true, since myInteger1 is unboxed to int


        //LOGICAL OPERATORS
        boolean conjunction = greater && greatereq;
        boolean disjuction = greater || greatereq;
        boolean exclusiveOr = greater ^ less;

        /** Logical operators are short cirquit, that means that if in conjunction
         *  the first operand is false, then the second operand will not be evaluated
         */
        int val1 = 1;
        boolean val2 = false;
        boolean val3 = true;
        boolean valRes1 = val2 && (++val1 > 1); //val1 will not be incremented
        boolean valRes2 = val3 || (++val1 > 1); //val1 will not be incremented


        //TERNARY OPERATOR
        int boolRes = boolVal ? 1 : 0;
        int compositeTernary = (boolVal ? true : false) ?  1 : 0;

        /** Values to be assigned have to be type compatible */
        //int ternaryInt = (boolVal == true) ? 1 : "str";

        //BITWISE OPERATIONS

        byte byte1 = 10; //00001010
        byte byte2 = 6;  //00000110
        byte result1 = (byte)(byte1 & byte2); //00000010 - bitwise AND
        byte result2 = (byte)(byte1 | byte2); //00001110 - bitwise OR
        byte result3 = (byte)(byte1 ^ byte2); //00001100 - bitwise EXCLUSIVE OR
        byte result4 = (byte)(~byte1); //11110101 - complementary

        //BITSHIFT OPERATORS

        byte leftShifted = (byte)(byte2 << 2);     //00011000 - shift bits to left by 2 places
        byte rightShifted = (byte)(byte2 >> 2);    //00000001 - shift bits to the right 2 places, no overflow
        byte rightZeroShift = (byte)(byte2 >>> 2); //00000001 - shift bits to the right 2 places
        //Generally value << n multiplies value by 2^n times
        //and value >> n divides value by 2^n times
        //>> and << use the leftmost bit value as a trailing bit after shifts
        //while >>> trails shifts with 0-s

        //OPERATOR PRECEDENCE

        /*
            Postfix	       -->    () [] . (dot operator)
            Unary          <--	  ~ ! - -- ++ (typecast)
            Multiplicative -->	  * / %
            Additive       -->	  + -
            Shift          -->    >>> >>> <<
            Relational     -->	  >> >= < <= (instanceof)
            Equality       -->	  == !=
            Bitwise        -->    & ^ |
            Logical        -->    && ||
            Ternary        <--    : ?
            Assignment     <--    |= ^= &= <<= >>= %= /= *= -= += =
         */


    }

    public void promotions() {
        /** When 2 primitive variables in an operation have different data, then
         *  the smaller variable will be promoted to larger variable type.
         *  When one primitive is integral and other is floating point,
         *  then the integral number will be promoted to floating point.
         *  Small data types (byte,short,char) are all promoted to int in a
         *  binary operation, even if none of the operands is int. The
         *  result of operation is the type of the promoted value.
         */

        short a = 10;
        byte b = 5;
        int ab = a*b;
        //short ab1 = a*b; //invalid, int cannot be referred to short
        double myDouble = 2;
        int myInt = 4;
        double result = myDouble + myInt;
        //float result1 = myDouble + myInt; //invalid, double cannot be referred to float
        //int result2 = myInt * myDouble; //invalid, double cannot be referred to int

        byte myByte1 = 1;
        byte myByte2 = 2;
        //byte myByteResult = myByte1+myByte2; //invalid, int cannot refer to byte

        /**Casting is converting bigger type to smaller type */
        short ab1 = (short)(a*b);
        float result1 = (float)(myDouble + myInt);
        int result2 = (int)(myInt * myDouble);
        byte myByteResult = (byte)(myByte1+myByte2);

        /**Casting from double to int will lose precision. When the casted value
         * is bigger than the maximum value that the cast type can hold,
         * the value will overflow into the negative side (with -), or if smaller than the
         * smallest value a type can hold, an underflow occurs*/

        /** Promotion rules also apply for relational operators */

    }

}
