package com.prometheus.learning.datastructures;

import java.util.*;

public class CollectionImpl {

    public void setImpl() {

        /** HashSet is backed by a hash table (actually a HashMap instance) with unpredictable iteration order */
        Set<String> hashSet = new HashSet<>();

        /** Hash table and linked list implementation of the Set interface, with predictable iteration order. */
        Set<String> linkedHashSet = new LinkedHashSet<>();

        /** A NavigableSet implementation based on a TreeMap. */
        Set<String> treeSet = new TreeSet<>();

    }

    public void listImpl() {

        /** Resizable-array implementation of the List interface. */
        List<String> arrayList = new ArrayList<>();

        /** Doubly-linked list implementation of the List and Deque interfaces. */
        List<String> linkedList = new LinkedList<>();

        /** The Vector class implements a growable array of objects. */
        List<String> vector = new Vector<>();

        /** The Stack class represents a last-in-first-out (LIFO) stack of objects, extends Vector. */
        List<String> stack = new Stack<>();


    }

    public void mapImpl() {

        /** Hash table based implementation of the Map interface. */
        Map<String, Integer> hashMap = new HashMap<>();

        /** Hash table and linked list implementation of the Map interface, with predictable iteration order. */
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        /** A Red-Black tree based NavigableMap implementation. */
        Map<String, Integer> treeMap = new TreeMap<>();

    }

    public void dequeImpl() {

        Deque<String> arrayDeque = new ArrayDeque<>();

    }

    public void arrayList() {

        /** Resizable-array implementation of the List interface. */
        List<String> arrayList = new ArrayList<>(); //Default capacity: 10
        arrayList = new ArrayList<>(20);
        arrayList = new ArrayList<>(Arrays.asList("String1", "String2"));

        /** Object	clone() */
        // Returns a shallow copy of this ArrayList instance.

        /** void	ensureCapacity(int minCapacity) */
        /* Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number
           of elements specified by the minimum capacity argument. */

        /** protected void	removeRange(int fromIndex, int toIndex) */
        // Removes from this list all of the elements whose index is between fromIndex, inclusive, and toIndex, exclusive.

        /** void	trimToSize() */
        // Trims the capacity of this ArrayList instance to be the list's current size.
    }

    public void vector() {

        /** The Vector class implements a growable array of objects. */

        /** Constructs an empty vector so that its internal data array has size 10 and its standard capacity increment is zero. */
        List<String> vector = new Vector<>();

        /** Constructs a vector containing the elements of the specified collection,
         in the order they are returned by the collection's iterator. */
        vector = new Vector<>(Arrays.asList("Str1", "Str2"));

        /** Constructs an empty vector with the specified initial capacity and with its capacity increment equal to zero. */
        vector = new Vector<>(10);

        /** Constructs an empty vector with the specified initial capacity and capacity increment. */
        vector = new Vector<>(10, 1);


        /** void	addElement(E obj) */
        // Adds the specified component to the end of this vector, increasing its size by one.

        /** int	capacity() */
        // Returns the current capacity of this vector.

        /** Object	clone() */
        // Returns a clone of this vector.

        /** void	copyInto(Object[] anArray) */
        // Copies the components of this vector into the specified array.

        /** E	elementAt(int index) */
        // Returns the component at the specified index.

        /** Enumeration<E>	elements() */
        // Returns an enumeration of the components of this vector.

        /** void	ensureCapacity(int minCapacity) */
        /* Increases the capacity of this vector, if necessary, to ensure that it can hold at least the number of
           components specified by the minimum capacity argument. */

        /** E	firstElement() */
        //Returns the first component (the item at index 0) of this vector.

    }

    public void stack() {

        /** The Stack class represents a last-in-first-out (LIFO) stack of objects, extends Vector */

        /** Creates an empty stack */
        Stack<String> stack = new Stack<>();

        /** boolean	empty() */
        // Tests if this stack is empty.
        boolean isEmpty = stack.empty();

        /** E	peek() */
        // Looks at the object at the top of this stack without removing it from the stack.
        String peekedValue = stack.peek();

        /** E	pop() */
        // Removes the object at the top of this stack and returns that object as the value of this function.
        String poppedValue = stack.pop();

        /** E	push(E item) */
        // Pushes an item onto the top of this stack.
        String pushedValue = stack.push("Pushed");

        /** int	search(Object o) */
        // Returns the 1-based position where an object is on this stack.
        int index = stack.search("Pushed");

    }

}
