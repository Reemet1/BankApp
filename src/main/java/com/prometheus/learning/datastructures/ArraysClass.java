package com.prometheus.learning.datastructures;

import java.util.Arrays;

public class ArraysClass {

    public void arraysClass() {

        /** Utility methods in Arrays class are
         *  binarySearch, copyOf, copyOfRange, equals, fill, sort, toString, deepEquals, deepHashCode, deepToString */

        int[] array = {1,2,3,4,5};

        /** static int	binarySearch(type[] a, type key)
         *  where type = byte,short,char,int,long,float,double,Object */
        // Searches the specified array for the specified value using the binary search algorithm.
        int index1 = Arrays.binarySearch(array, 2);

        /** static int binarySearch(type[] a, int fromIndex, int toIndex, type key)
         *  where type = boolean,byte,short,char,int,long,float,double,Object
         *
         *  static <T> int	binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c)
         *  static <T> int	binarySearch(T[] a, T key, Comparator<? super T> c) */
        // Searches a range of the specified array for the specified object using the binary search algorithm.
        int index2 = Arrays.binarySearch(array, 2, 0,array.length-1);


        /** static type[]	copyOf(type[] original, int newLength)
         *  where type = boolean,byte,short,char,int,long,float,double
         *
         *  static <T> T[]	copyOf(T[] original, int newLength)
         *  static <T,U> T[]	copyOf(U[] original, int newLength, Class<? extends T[]> newType) */
        /* Copies the specified array, truncating or padding with default values (if necessary)
           so the copy has the specified length. */
        int[] copy1 = Arrays.copyOf(array, array.length);


        /** static type[]	copyOfRange(type[] original, int from, int to)
         *  where type = boolean,byte,short,char,int,long,float,double
         *
         *  static <T> T[]	copyOfRange(T[] original, int from, int to)
         *  static <T,U> T[]	copyOfRange(U[] original, int from, int to, Class<? extends T[]> newType)*/
        //Copies the specified range of the specified array into a new array.
        int[] copy2 = Arrays.copyOfRange(array, 0,1);


        /** static boolean	equals(type[] a, type[] a2)
         *  where type = boolean,byte,short,char,int,long,float,double,Object */
        // Returns true if the two specified arrays are equal to one another.
        boolean arrEquals = Arrays.equals(copy1, copy2);



        /** static void	fill(type[] a, type val)
         *  where type = boolean,byte,short,char,int,long,float,double,Object */
        // Assigns the specified short value to each element of the specified array of shorts.
        Arrays.fill(array, 1);


        /** static void	fill(type[] a, int fromIndex, int toIndex, type val)
         *  where type = boolean,byte,short,char,int,long,float,double,Object */
        // Assigns the specified short value to each element of the specified range of the specified array of shorts.
        Arrays.fill(array, 0, array.length, 1);


        /** static int hashCode(type[] a)
         *  where type = boolean,byte,short,char,int,long,float,double,Object */
        // Returns a hash code based on the contents of the specified array.
        int hashCode = Arrays.hashCode(array);


        /** static void	sort(type[] a)
         *  where type = byte,short,char,int,long,float,double,Object */
        // Sorts the specified array into ascending numerical order (natural ordering for Object)
        Arrays.sort(array);

        /** static void	sort(type[] a, int fromIndex, int toIndex)
         *  where type = byte,short,char,int,long,float,double,Object */
        // Sorts the specified range of the array into ascending order (natural ordering for Object)
        Arrays.sort(array, 0, array.length);

        /** static <T> void	sort(T[] a, Comparator<? super T> c) */
        // Sorts the specified array of objects according to the order induced by the specified comparator.

        /** static <T> void	sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c) */
        /* Sorts the specified range of the specified array of objects according to the order induced
           by the specified comparator. */



        /** static String	toString(boolean[] a)
         *  where type = boolean,byte,short,char,int,long,float,double,Object
         */
        // Returns a string representation of the contents of the specified array.
        String arrayStr = Arrays.toString(array);



        /** static boolean	deepEquals(Object[] a1, Object[] a2) */
        // Returns true if the two specified arrays are deeply equal to one another.

        /** static int	deepHashCode(Object[] a) */
        // Returns a hash code based on the "deep contents" of the specified array.

        /** static String	deepToString(Object[] a) */
        // Returns a string representation of the "deep contents" of the specified array.


    }


}
