package com.prometheus.learning.basics;

public class DataTypes {

    boolean myBoolean;
    byte myByte;
    short myShort;
    int myInt;
    long myLong;
    float myFloat;
    double myDouble;
    char myChar;
    String myString;
    Object myObject;


    public void defaultValues() {

        int a;
        boolean bool;
        char ch;
        String str = null;
        Object obj;

        //ch = null; //primitives cannot be null

        //Not certain initialization
        if(str.equals("abc")) {
            a = 10;
        }
        //System.out.println(a); //Local variables have to be defined before use
        System.out.println(str);

        Object obj1, obj2, obj3; //multiple variables can be defined with one type
        obj1 = obj2 = obj3 = new Object(); //declared variables can be initialized with consecutive =
        int myInt1 = 10, myInt2 = 20, myInt3 = 30; //Initialization can also be done on one line
        char ch1 = '2', ch2;

        //double d1, double d2; //invalid
        //int i1; i2; //invalid


        /** Identifiers can only start with letter, dollar symbol or underscore */
        String identifier,_identifier, $itentifier;
        /** Identifiers can contain numbers after the first letter, but not symbols except
         * dollar sign and underscore */

        /** Java naming is case sensitive */
        char chaR;
        int ChaR;

        System.out.println("Default initial values of object fields and static fields: ");
        System.out.println("boolean " + this.myBoolean);
        System.out.println("byte " + this.myByte);
        System.out.println("short " + this.myShort);
        System.out.println("int " + this.myInt);
        System.out.println("long " + this.myLong);
        System.out.println("float " + this.myFloat);
        System.out.println("double " + this.myDouble);
        System.out.println("char " + this.myChar);
        System.out.println("String " + this.myString);
        System.out.println("Object " + this.myObject);
    }

    public void dataTypes() {

        //Variables are reserved memory locations.
        //Primitive data types can reserve 1,4,8,16,32,64-bit memory, and they are called value data types

        byte myByteValue = 1; //byte has 8 bits (2^8)
        short myShortValue = 2; //short has 16 bits (2^16)
        int myIntValue = 3; //int has 32 bits (2^32)
        long myLongValue = 4L; //long has 64 bits (2^64) //4l is ok too
        float myFloatValue = 5; //stored as 5.0 //float has 32 bits
        double myDoubleValue = 5d; //stored as 5.0 //double has 64 bits

        double scientificNotation = 2.56E3; //2.56*10^3 = 2560
        scientificNotation = 1E03; //valid
        scientificNotation = 2E000_0003; //valid

        /** Numbers in octal, hexadecimal and binary base */
        //int oct = 08; //invalid, since octal numbers can contain only digits from 0 to 7
        int oct = 010; //value in decimal: 8
        System.out.println(oct); //oct is converted to decimal format
        System.out.println(Integer.toOctalString(oct)); //String in octal format

        /** hexadecimal numbers start with 0x and can contain digits (0-9) and letters A-F */
        int hexaDecimal1 = 0xF; //15 in decimal
        int hexaDecimal2 = 0x23F73AD; //valid
        System.out.println(Integer.toHexString(hexaDecimal2)); //23F73AD

        /** binary numbers contain digits 0 and 1 */
        int myBinary = 0b10101011010111;
        System.out.println(Integer.toBinaryString(myBinary));

        //int invalidBin = 0b2;

        /** hexadecimal floating point numbers */
        double hexdec = 0x1.9abcdef1_3_8p1; //p indicates hexademical floating point number

        //type letter is case insensitive, all are valid: d,D,l,L,f,F
        //but it is not good practice to use lower case letters

        double floatToDouble = 10.1f;
        //float doubleToFloar = 10.0d; //invalid, since double is broader type
        //float float1 = 10.0; //invalid, default type of floating point numbers is double, which
        //in this case cannot be referenced to float, since double is broader type

        //long tooBig = 2435345435345; //whole numbers are treated as type 'int' by default
        long smallInt = 23213; //integer converted to long

        int myIntValue2 = 1_234_567; //numbers in a literal can be separated by underscore

        double valid = 2_728.87_83;
        /** Cant use underscore on the following places in a decimal */
        //double int1 = _2.322;
        //double int2 = 2_.322;
        //double int3 = 2._322;
        //double int4 = 2.322_;

        //byte f = c/2; //java casts c/2 to integer by default, which wont fit into byte

        System.out.println(myIntValue/2); //leaves out remainder
        System.out.println(5f/3f); //float has 7 digits of precision after decimal point (32 bits)
        System.out.println(5d/3d); //double has 16 digits of precision after decimal point (64 bits)
        System.out.println(5.2/3.3); //when no letter is used, java takes it as double value by default
        //double is faster and more precise for calculations

        double pi = 3.141_59_2d;

        char myChar = 'a'; //16 bits
        //char myChar1 = 'abc'; //can only contain 1 character

        char unicodeChar = '\u00A9';//https://www.compart.com/en/unicode/category
        System.out.println(unicodeChar);

        //16bit -> 2^16 = 16^4, that's why char unicode has 4 letters,
        //possible 16 values are 0 1 2 3 4 5 6 7 8 9 A B C D E F

        boolean myTrueBoolean = true;
        boolean byFalseBoolean = false;

        /** NB! Primitive variables cannot be set to NULL */
        //myIntValue = null; //error

        //Object data types (reference types) are represented with classes

        String myString = "This is my first string"; //String is a sequence of characters
        System.out.println(myString + " \u00A9"); //Strings can contain unicode characters

        String myString2 = "10";
        int myInt = 50;
        System.out.println(myString2 + myInt); //Result is 1050, since myInt is converted to string

        /** Char values can be assigned to int type and vice versa.
         * char and int are also type compatible in switch cases */
        int charInt = 'A';
        char intChar = 20;
        char charArith = 'B' + '*';
        //char invalidChar = intChar + 1; //invalid, intChar is converted to int, cannot refer to char
        char fixedChar = (char)(intChar + 1);
        //Integer wrapperInt = 'a'; //compilation error
    }

    public void primitiveAndReferenceTypes() {
        //For primitive data types, a single memory location is stored for each variable,
        //that means each primitive variable has their own copy, which do not interfere with each other
        int firstVariable = 10;
        int secondVariable = firstVariable;
        firstVariable = 20;
        System.out.println("firstVariable = " + firstVariable + ", secondVariable = " + secondVariable);
        secondVariable = 15;
        System.out.println("firstVariable = " + firstVariable + ", secondVariable = " + secondVariable);

        //Reference types are created with 'new' keyword. Multiple variables can have same reference
        //and making change in 1 variable also changes the other variables that references to the same
        //memory location
        int[] array1 = new int[]{1,2,3};
        int[] array2 = array1;
        array1[0] = 5;
        System.out.println("array1 = " + java.util.Arrays.toString(array1) + ", array2 = " + java.util.Arrays.toString(array2));
        array2[0] = 7;
        System.out.println("array1 = " + java.util.Arrays.toString(array1) + ", array2 = " + java.util.Arrays.toString(array2));

        //Arrays having the same reference are both modified also when the modification is done inside a method
        modifyArray(array2);
        System.out.println("array1 = " + java.util.Arrays.toString(array1) + ", array2 = " + java.util.Arrays.toString(array2));

        //Defererencing only affects the referencing variable, array1 variable now points to new array object
        array1 = new int[]{1,2,3,4,5,6,7};
        System.out.println("array1 = " + java.util.Arrays.toString(array1) + ", array2 = " + java.util.Arrays.toString(array2));
    }

    public void modifyArray(int[] array) {
        //array is another reference to the same object
        array[1] = 50;
        //Defererencing will not affect other arrays with same reference
        array = new int[]{1,2,3,4,5};
    }


}
