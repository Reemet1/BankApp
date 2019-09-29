package com.prometheus.learning.basics;

public class Arrays {


    public void arrays() {


        /** =========================== CREATING ARRAYS ============================ */

        //Arrays are fixed size sequences of data of the same type. Arrays are reference types
        int[] arr1 = new int[10]; //Default values are 0-s
        int[] arr2 = new int[]{1,2,3};
        int[] arr3 = {1,2,3}; //anonymous array
        //arr3 = {1,2,3}; anonymous initialization cannot be used without declaration
        int[] arr4;
        arr4 = new int[]{1,2,3};
        //arr4 = new int[3]{1,2,3}; //Not applicable
        //arr4 = {1,2,3}; //Not applicable, can only be used with declaration
        int arr5   [] = new  int [1] ;
        arr5[0] = 5; //Assigning value, counting in Arrays start at 0
        System.out.println(arr5[0]);

        //int[] arr6 = new int[]; //invalid
        int[] arr6 = new int[]{}; //valid, length = 0
        int[] arr7 = {}; //length = 0
        int arr8[] = {1,2,3}; //array brackets can be after variable name

        int arr9[], arr10; //arr9 is array and arr10 is int, bad practice



        /** ======================= ACCESSING, LOOPING AND COPYING ARRAYS ====================== */

        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = i; //Trasversing through array
        }

        //int length1 = arr1.length(); //invalid, no methods for arrays
        int length2 = arr1.length;
        //arr1.length = 10; //length cannot be changed

        for(int elem : arr1) {
            System.out.println(elem);
        }

        //Makes a copy of arr2
        int[] copiedArr = java.util.Arrays.copyOf(arr2, arr2.length);

        //int b = arr1[-1]; //ArrayIndexOutOfBoundsException
        //b = arr1[arr1.length+1]; //ArrayIndexOutOfBoundsException




        /** ======================== MODIFYING ARRAYS ===================================== */

        //Arrays are reference types. Multiple arrays can have same reference
        //and making change in 1 array also changes the other arrays that references to the same
        //memory location
        int[] array1 = new int[]{1,2,3};
        int[] array2 = array1;
        System.out.println(array1 == array2); //true, same references
        System.out.println(array1.equals(array2)); //true, references are compared again
        System.out.println(java.util.Arrays.equals(array1, array2)); //true, contents are compared

        System.out.println(array1); //prints reference value
        System.out.println(java.util.Arrays.toString(array1)); //prints contents

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

    public void binarySearch() {

        /** To use binary search, the array has to be sorted. Binary search algorithm
         *  splits the array into 2 subarrays and chooses the subarray that the
         *  item to be searched is in, and then repeats the process until one element is left.
         */

        int[] numbers = {1,3,5,7,9};

        /** result is 0, since element 1 is found on index 0 */
        System.out.println(java.util.Arrays.binarySearch(numbers, 1));

        /** Result is -2, since element 2 is not found, but if it is to be
         *  found, it should be on the position with index 2 (1 based count) in numbers array
         */
        System.out.println(java.util.Arrays.binarySearch(numbers, 2));

        /** Returns -6 (1 based count, would be -5 in 0 based count) */
        System.out.println(java.util.Arrays.binarySearch(numbers, 10));

        int[] unsorted = {5,3,8,6,4};
        /** Unpredictable result, because the array is unsorted */
        System.out.println(java.util.Arrays.binarySearch(unsorted, 8));
        System.out.println(java.util.Arrays.binarySearch(unsorted, 5));
        System.out.println(java.util.Arrays.binarySearch(unsorted, 4));

        /** Before binary searching items, the array should be sorted */
        java.util.Arrays.sort(unsorted);

    }

    /** Arguments can be passed as an array (varargs - variable arguments). BlockChain method
     *  can contain varargs instead of array argument*/
    public void varArgsMetthod(int a, int b, String... args) {
        String[] arg = args;

        if(a == 0) {
            varArgsMetthod(1, 2, "String1", "String2", "String3");
        }
    }


    public void varArgsMetthod2(String[] args) {
        String[] arg = args;

        //varArgsMetthod2("String1", "String2", "String3"); //not valid
    }

    public void multidimensionalArrays() {

        /** 1D array */
        int[] array1 = new int[]{1,2,3};

        /** 2D array - asymmetrical, row can be null */
        int[][] array2 = new int[][]{{1,2},{3,4},{5,6,7}, null};

        /** 2D array - 2 rows, 3 columns - symmetrical */
        int[][] array3 = new int[3][2];
        array3[0][0] = 1;
        array3[0][1] = 2;
        array3[1][0] = 3;
        array3[1][1] = 4;
        array3[2][0] = 5;
        array3[2][1] = 6;

        int array4[][];
        int[] array5[];

        int[][][] array6 = {
                {{1,2},{3,4}},
                {{5,6},{7,8}},
                {{9,10},{11,12}}
        };

        int[] array7[][];

        int[][] array8 = new int[2][];
        //array8[0] == null;

        //int[][] array9 = new int[][]; //invalid, size has to be specified

        /** Although an int can be assigned to char type, an int array cannot be assigned to char array */
        int[] intArray = new int[1];
        char[] charArray = new char[1];
        //charArray = intArray; //compilation error





    }
}
