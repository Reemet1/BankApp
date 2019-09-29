package com.prometheus.learning.datastructures;

import java.util.*;
import java.util.Arrays;

public class DataStructures {


    /**
     * ArrayLists use arrays internally, but arraylists can be resized (dynamic array)
     */
    public void arrayLists() {

        /** myList1 and myList2 are equivalent */
        ArrayList myList1 = new ArrayList();
        ArrayList<Object> myList2 = new ArrayList<Object>();
        /** Right hand side type parameter is redundant */
        ArrayList<Object> myList3 = new ArrayList<>();

        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>(10);

        //ArrayList<int> intList; //Type parameter cant be primitive, though wrappers are allowed

        int a = 'a';

        list.add("String1");
        list.add(0, "String2");
        list.set(1, "String2");
        list.remove(0);
        list.remove("String1"); //removes 1st matching value

        list.size();
        list.clear();
        list.isEmpty();
        list.contains("String");

        List<String> list3 = new ArrayList<>();
        list3.add("TestString");
        List<String> list4 = new ArrayList<>();
        list4.add("TestString");

        list3.equals(list4); //true
        /** equals() will return false, if 2 arraylists have the same elemenents but in different order */

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(10.1); //autoboxing
        double unboxed = doubleList.get(0);

        /** null values can be added and removed */
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list);
        list.remove(null);
        System.out.println(list);

        doubleList.add(null);
        //unboxed = doubleList.get(0); //NullPointerException

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        doubleList.remove(0); //removes element at index 0, and not Double object 0
        doubleList.remove(0.0); //removes Double object

        integerList.remove(1);
        integerList.remove(new Integer(2));

        /** Converting array <--> ArrayList */
        List<String> stringList = new ArrayList<>();
        stringList.add("Str1");
        stringList.add("Str2");
        stringList.add("Str3");

        /** arraylist -> array */
        Object[] stringArray = stringList.toArray();
        stringArray = stringList.toArray(new String[stringList.size()]); //any size can be specified

        /** array -> arraylist */
        String[] stringArray1 = {"str1","str2","str3"};
        List<String> stringList1 = Arrays.asList("str1", "str2", "str3");

        /** stringList1 and stringArray1 will be linked, and both contain the same underlying array */
        stringList1 = Arrays.asList(stringArray1);
        stringList1.set(0, "str11");
        stringArray1[1] = "str22";
        System.out.println(stringArray1[0].equals(stringList1.get(0)));
        System.out.println(stringArray1[1].equals(stringList1.get(1)));

        /** UnsupportedOperationException, because when a list is created with
         * Arrays.asList(), it will have fixed size (asList() returns fixed size list)
         */
        //stringList1.add("str3");
        //stringList1.remove(0);

        stringArray1 = new String[]{"str1","str2","str3"};

        /** Dynamic size list from array */
        stringList1 = new ArrayList<>(Arrays.asList(stringArray1));
        stringList1.set(0, "str11");
        /** arraylist and list are not linked anymore */
        System.out.println(stringArray1[0].equals(stringList1.get(0)));

        /** Sorting an array vs sorting arraylist */
        Arrays.sort(stringArray1);
        Collections.sort(stringList1);

        /** In searching for ArrayList, it has to be sorted like array, the
         *  rules similar to searching arrays apply to ArrayList */
        List<Integer> integerList1 = new ArrayList<>();
        integerList1.addAll(Arrays.asList(8,4,5,2,9,5));
        int index1 = Collections.binarySearch(integerList1, 8); //-5

        Collections.sort(integerList1);
        index1 = Collections.binarySearch(integerList1, 8);
        System.out.println(index1); // 4
        index1 = Collections.binarySearch(integerList1, 3);
        System.out.println(index1); // -2

        List<String> nameList = new ArrayList<>();
        nameList.add("Reemet");
        nameList.add("Joonas");
        nameList.add("Kalmer");

        /** Different ways of iterating over an arraylist */

        /** regular for loop */
        for(int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
            /** Difficult to modify list during for loop */
        }

        System.out.println("-----------------");

        /** enhanced for loop */
        for(String name : nameList) {
            System.out.println(name);
            /** ConcurrentModificationException */
            //nameList.remove(0);
        }

        System.out.println("-----------------");

        /** Iterator enables to modify a list during iteration*/

        for(Iterator<String> iterator = nameList.iterator(); iterator.hasNext(); ) {
            String name = iterator.next(); //gets the next item
            System.out.println(name);
            iterator.remove(); //removes the current item
        }

        /** Iterator with while loop */
        Iterator iterator = nameList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        nameList.addAll(Arrays.asList("Reemet","Kaarel","Andres"));

        /** ListIterator is similar to Iterator, but has more methods */
        ListIterator<String> listIterator = nameList.listIterator(1); //can define starting index
        while(listIterator.hasNext()) {

            listIterator.nextIndex();
            if(listIterator.hasPrevious()) {
                listIterator.previousIndex();
                listIterator.previous();
            }

        }





    }

    public static void linkedLists() {

        //In linked lists, each element maintains a link address to the next element,
        //in which during the addition or deletion of an element only correspinding
        //addresses have to be relinked, aka has fast deletion and addition operations,
        //but are slow in retrieval operation since its sequential search nature.

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Entry 1");
        linkedList.add("Entry 2");
        linkedList.add("Entry 3");

        //Iterator enables to only move to the next element
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterating " + iterator.next());
        }

        //List iterator also enables to move to previous elements
        ListIterator<String> listIterator = linkedList.listIterator();


    }

}
