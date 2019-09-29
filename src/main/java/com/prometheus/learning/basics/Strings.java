package com.prometheus.learning.basics;

/**
 * Strings are sequence of characters. In Java Strings are not primitves but objects.
 */
public class Strings {

    public void stringUtilities() {

        String str = "String1 String2";
        int len = str.length();
        char ch = str.charAt(0);
        byte[] bytes = str.getBytes();
        String[] parts = str.split("0");
        String trimmed = str.trim();
        //String intStr = 1; //incompatible types
        String intStr = ""+1;

        /** The following methods do not change the str object, but return a new one,
         *  and if the returned result is not referred to any variable, the
         *  modification will be lost. */
        str.toLowerCase();
        str.toUpperCase();
        str.toUpperCase().toLowerCase().trim().isEmpty(); //String methods can be chained
        str.contains("Str");
        str.concat(" String3");
        String replaed = str.replace("S","s");
        str.isEmpty();
        str.startsWith("S");
        str.endsWith("3");
        String subString = str.substring(0,6);
        str.substring(1,1); //returns "";
        boolean equals = str.equals("String123");
        boolean match = str.matches("regex");
        str.trim(); //Removes excessive spaces, spaces at start and at end of string

        String str1 = "TestString";
        String str2 = "TestString";
        String str3 = "Test" + "String"; //computed compile time, taken as literal (= TestString)
        String str4 = new String("TestString");
        String str5 = "Test";
        String str6 = str5 + "String"; //new reference, not taken from string pool
        System.out.println(str1 ==str2); //true, since str2 is from StringPool
        System.out.println(str1 == str3); //true, since str3 is from StringPool
        System.out.println(str1 == str4); //false new String created
        System.out.println(str1 == str6); //false

        System.out.println(str1.equals(str2)); //true
        System.out.println(str1.equals(str3)); //true
        System.out.println(str1.equals(str4)); //true

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
        System.out.println(System.identityHashCode(str3));
        System.out.println(System.identityHashCode(str4));


    }


    public void creatingStrings() {

            /** Strings can be created in different ways */
            String str1 = "String1";
            String str2 = new String("String2");
            String str3 = new String(new char[]{'S','t','r','i','n','g','3'});
    }

    public void concatStrings() {

        /** There are different ways of composing strings */
        String str = "String1 ";
        String concat1 = str + "String2";
        String concat2 = str.concat("String2");

        /** The previous 2 ways do not modify the same String object, but return a new one,
         *  this is uneffective way to concat Strings in a loop since many objects are created.
         *  The term for this is 'string immutability' */
        System.out.println(str == concat1); //false
        System.out.println(str == concat2); //false

        /** If String is concatenated with a number using +, the result will be String.
         *  Concatenation with + is done from left to right */
        System.out.println(1 + 2 + " str"); //3 str
        System.out.println("result= " + 1 + 2); //result= 12
        System.out.println("result " + (1 + 2)); //result= 3

        /** If there are many modifications that has to be done to the string, the more optimal way is to use
         *  StringBuilder and StringBuffer classes, which are like Strings, but can be modified
         *  without changing the object. */

        /** For String concatenation in a loop, a more effective way is to use a StringBuilder,
         *  which allows to change the string without creating an object each time.
         * The difference between StringBuilder and StringBuffer is that StringBuffer
         *  has Thread-Safe (synchronized) operations, while StringBuilder doesn't. */

        StringBuilder stringBuilder = new StringBuilder("String1");
        StringBuffer stringBuffer = new StringBuffer("String1");
        //StringBuilder invalidBuilder  = "abc"; //invalid, must use constructor

        /** StringBuilder and StringBuffer classes have similar methods to String class, but not all.
         *  The main characteristic methods for these classes are append() and insert() */
        stringBuilder.append(" String2");
        stringBuilder.insert(0, "String0 ");

        stringBuffer.append(" String2");
        stringBuffer.insert(0, "String0 ");

        String str1 = stringBuilder.toString();
        String str2 = stringBuffer.toString();
    }

    public void characters() {

        /** Character object can only consist of one character */
        Character ch = 'a';
        Character ch1 = new Character('b');
        Character.isDigit(ch);
        Character.isLetter(ch);

        /** Returns a subset or family of characters where the given char belongs */
        Character.UnicodeBlock.of(ch);

        /** Character values can be represented in Unicode ranging from U+0000 to U+FFFF */
        char unicodeChar = '\u0001';
        System.out.println(unicodeChar);

    }


}
