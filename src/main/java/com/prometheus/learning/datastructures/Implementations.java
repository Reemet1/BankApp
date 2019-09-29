package com.prometheus.learning.datastructures;

import java.util.*;

public class Implementations {

    public void listImplementations() {

        ArrayList arrayList1 = new ArrayList();
        arrayList1.trimToSize(); //Changes the capacity to current size
        arrayList1.ensureCapacity(10);

    }

    public void setImplementations() {

        /** TreeSet sorts elements based on their natural ordering or
         *  the ordering defined by the Comparator provided to the constructor */
        TreeSet treeSet = new TreeSet();
        treeSet.ceiling(1);
        treeSet.higher(1);
        treeSet.floor(1);
        treeSet.lower(1);
        treeSet.headSet(1);
        treeSet.tailSet(1);
        treeSet.descendingIterator();
        treeSet.comparator();

    }

    public void queueImplementations() {

    }

    public void dequeImplementatsions() {

        /** ArrayDeque is a resizable array implementations of Deque supporting insertion,
         *  removal and retrieval of elements from both ends of the collection */
        Deque deque = new ArrayDeque();
        deque.getFirst();
        deque.getLast();
        deque.peek();
        deque.peekFirst();
        deque.peekLast();
        deque.remove(1);
        deque.offer(1);
        deque.pollFirst();


    }

    public void mapImplementations() {

        /**Map is a generic type, where 1st type is keyType and 1nd type is valueType */

        Map<String, Integer> hashMap = new HashMap<>();

        /** Keys of TreeMap are ordered by natural ordering or by Comparator given to constructor */
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("key", 1);
        treeMap.get("key"); //returns null if not found
        treeMap.containsKey("key");
        treeMap.containsValue(1);
        treeMap.keySet();
        treeMap.entrySet();
        treeMap.values();

        for(Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue());
        }


        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();


    }

}
