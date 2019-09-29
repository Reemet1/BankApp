package com.prometheus.learning.datastructures;



import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class CollectionInterfaces {


    public void collection() {

        /** Collection<E> is the root interface in the collection hierarchy */
        Collection<Object> collection = null;

        Object object = new Object();

        /** boolean	add(E e) */
        // Ensures that this collection contains the specified element (optional operation).
        boolean wasAdded = collection.add(new Object());

        /** boolean	addAll(Collection<? extends E> c) */
        // Adds all of the elements in the specified collection to this collection (optional operation).
        boolean allWereAdded = collection.addAll(Arrays.asList(object, new Object()));

        /** void clear() */
        // Removes all of the elements from this collection (optional operation).
        collection.clear();

        /** boolean	contains(Object o) */
        //Returns true if this collection contains the specified element.
        boolean containsObj = collection.contains(object);

        /** boolean	containsAll(Collection<?> c) */
        // Returns true if this collection contains all of the elements in the specified collection.
        boolean containsAll = collection.containsAll(Arrays.asList(object, new Object()));

        /** boolean	equals(Object o) */
        // Compares the specified object with this collection for equality.
        boolean equals = collection.equals(new ArrayList<>());

        /** int	hashCode() */
        // Returns the hash code value for this collection.
        int hashCode = collection.hashCode();

        /** boolean	isEmpty() */
        //Returns true if this collection contains no elements.
        boolean isEmpty = collection.isEmpty();

        /** Iterator<E>	iterator() */
        // Returns an iterator over the elements in this collection.
        Iterator<Object> iterator = collection.iterator();

        /** default Stream<E>	parallelStream() */
        // Returns a possibly parallel Stream with this collection as its source.
        Stream<Object> parallelStream = collection.parallelStream();

        /** boolean	remove(Object o) */
        //Removes a single instance of the specified element from this collection, if it is present (optional operation).
        boolean wasObjRemoved = collection.remove(new Object());

        /** boolean	removeAll(Collection<?> c) */
        // Removes all of this collection's elements that are also contained in the specified collection (optional operation).
        boolean wasCollectRemoved = collection.removeAll(Arrays.asList(new Object(), new Object()));

        /** default boolean	removeIf(Predicate<? super E> filter) */
        //Removes all of the elements of this collection that satisfy the given predicate.
        boolean removed = collection.removeIf(a -> a.toString().startsWith("S"));

        /** boolean	retainAll(Collection<?> c) */
        // Retains only the elements in this collection that are contained in the specified collection (optional operation).
        boolean allRetained = collection.retainAll(Arrays.asList("Str1","Str2","Str3"));

        /** int	size() */
        // Returns the number of elements in this collection.
        int collectionSize = collection.size();

        /** default Spliterator<E>	spliterator() */
        // Creates a Spliterator over the elements in this collection.
        Spliterator<Object> spliterator = collection.spliterator();

        /** default Stream<E>	stream() */
        // Returns a sequential Stream with this collection as its source.
        Stream<Object> objStream = collection.stream();

        /** Object[]	toArray() */
        // Returns an array containing all of the elements in this collection.
        Object[] array1 = collection.toArray();

        /**<T> T[]	toArray(T[] a) */
        /* Returns an array containing all of the elements in this collection; the runtime type of the
        returned array is that of the specified array. */
        Object[] array2 = collection.toArray(new String[]{});

    }

    public void list() {

        /** An ordered collection (also known as a sequence) */
        List<String> list = null;

        /** Methods inherited from java.util.Collection:
         *  parallelStream, removeIf, stream
         *  Methods inherited from java.lang.Iterable: forEach
         */


        /** New methods in addition to Collection interface */

        /** boolean	add(E e) */
        // Appends the specified element to the end of this list (optional operation).
        boolean added = list.add("String");

        /** void add(int index, E element) */
        // Inserts the specified element at the specified position in this list (optional operation).
        list.add(0, "String0");

        /** boolean	addAll(Collection<? extends E> c) */
        /* Appends all of the elements in the specified collection to the end of this list,
           in the order that they are returned by the specified collection's iterator (optional operation). */
        boolean allAdded = list.addAll(Arrays.asList("String1", "String2", "String3"));

        /** boolean	addAll(int index, Collection<? extends E> c) */
        // Inserts all of the elements in the specified collection into this list at the specified position (optional operation).
        boolean allAddedIndex = list.addAll(0, Arrays.asList("String00", "String01", "String02"));

        /** E	get(int index) */
        // Returns the element at the specified position in this list.
        String elementAt1 = list.get(1);

        /** int	indexOf(Object o) */
        // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
        int indexOf = list.indexOf("String");

        /** int	lastIndexOf(Object o) */
        /* Returns the index of the last occurrence of the specified element in this list, or -1 if this
        list does not contain the element. */
        int lastIndexOf = list.lastIndexOf("String3");

        /** ListIterator<E>	listIterator() */
        // Returns a list iterator over the elements in this list (in proper sequence).
        ListIterator<String> listIterator1 = list.listIterator();

        /** ListIterator<E>	listIterator(int index) */
        /* Returns a list iterator over the elements in this list (in proper sequence),
           starting at the specified position in the list. */
        ListIterator<String> listIterator2 = list.listIterator(3);

        /** E	remove(int index) */
        // Removes the element at the specified position in this list (optional operation).
        String removedFromIndex = list.remove(1);

        /** boolean	remove(Object o) */
        // Removes the first occurrence of the specified element from this list, if it is present (optional operation).
        boolean objRemoved = list.remove("String");

        /** boolean	removeAll(Collection<?> c) */
        // Removes from this list all of its elements that are contained in the specified collection (optional operation).
        boolean allRemoved = list.removeAll(Arrays.asList("Str1", "Str2", "Str3"));

        /** default void	replaceAll(UnaryOperator<E> operator) */
        // Replaces each element of this list with the result of applying the operator to that element.
        list.replaceAll(str -> str.toUpperCase());

        /** E	set(int index, E element) */
        // Replaces the element at the specified position in this list with the specified element (optional operation).
        String replacedStr = list.set(0, "NewString");

        /** default void	sort(Comparator<? super E> c) */
        // Sorts this list according to the order induced by the specified Comparator.
        list.sort((a,b) -> a.compareTo(b));

        /** List<E>	subList(int fromIndex, int toIndex) */
        // Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
        List<String> subList = list.subList(0, 2);

    }

    public void set() {

        /** A collection that contains no duplicate elements */
        Set<String> set = null;

        /** Methods inherited from java.util.Collection:
         *  parallelStream, removeIf, stream
         *  Methods inherited from java.lang.Iterable: forEach
         */


        /** New methods in addition to Collection interface */

        /** boolean	add(E e) */
        // Adds the specified element to this set if it is not already present (optional operation).
        boolean added = set.add("String");

        /** boolean	addAll(Collection<? extends E> c) */
        // Adds all of the elements in the specified collection to this set if they're not already present (optional operation).
        boolean addedAll = set.addAll(Arrays.asList("Str1", "Str2", "Str3"));

        /** boolean	remove(Object o) */
        // Removes the specified element from this set if it is present (optional operation).
        boolean removed = set.remove("String");

        /** boolean	removeAll(Collection<?> c) */
        // Removes from this set all of its elements that are contained in the specified collection (optional operation).
        boolean removedAll = set.removeAll(Arrays.asList("Str1", "Str2", "Str3"));

        /** boolean	retainAll(Collection<?> c) */
        // Retains only the elements in this set that are contained in the specified collection (optional operation).
        boolean allRetained = set.retainAll(Arrays.asList("String1", "String2"));

    }

    public void sortedSet() {

        /** A Set that further provides a total ordering on its elements. */
        SortedSet<Integer> sortedSet = null;

        /** Comparator<? super E>	comparator() */
        /* Returns the comparator used to order the elements in this set, or null if this set uses the
           natural ordering of its elements. */

        /** E	first() */
        // Returns the first (lowest) element currently in this set.

        /** SortedSet<E>	headSet(E toElement) */
        // Returns a view of the portion of this set whose elements are strictly less than toElement.

        /** E	last() */
        // Returns the last (highest) element currently in this set.

        /** default Spliterator<E>	spliterator() */
        // Creates a Spliterator over the elements in this sorted set.

        /** SortedSet<E>	subSet(E fromElement, E toElement) */
        /* Returns a view of the portion of this set whose elements range from fromElement, inclusive,
           to toElement, exclusive. */

        /** SortedSet<E>	tailSet(E fromElement) */
        // Returns a view of the portion of this set whose elements are greater than or equal to fromElement.

    }

    public void navigableSet() {

        /** A SortedSet extended with navigation methods reporting closest matches for given search targets. */
        NavigableSet<Integer> navigableSet = null;

        /** E	ceiling(E e) */
        /* Returns the least element in this set greater than or equal to the given element, or null if
           there is no such element. */

        /** Iterator<E>	descendingIterator() */
        // Returns an iterator over the elements in this set, in descending order.

        /** NavigableSet<E>	descendingSet() */
        // Returns a reverse order view of the elements contained in this set.

        /** E	floor(E e) */
        /* Returns the greatest element in this set less than or equal to the given element,
           or null if there is no such element. */

        /** SortedSet<E>	headSet(E toElement) */
        // Returns a view of the portion of this set whose elements are strictly less than toElement.

        /** NavigableSet<E>	headSet(E toElement, boolean inclusive) */
        /* Returns a view of the portion of this set whose elements are less than (or equal to, if inclusive is true)
           toElement. */

        /** E	higher(E e) */
        // Returns the least element in this set strictly greater than the given element, or null if there is no such element.

        /** Iterator<E>	iterator() */
        // Returns an iterator over the elements in this set, in ascending order.

        /** E	lower(E e) */
        // Returns the greatest element in this set strictly less than the given element, or null if there is no such element.

        /** E	pollFirst() */
        // Retrieves and removes the first (lowest) element, or returns null if this set is empty.

        /** E	pollLast() */
        // Retrieves and removes the last (highest) element, or returns null if this set is empty.

        /** NavigableSet<E>	subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) */
        //Returns a view of the portion of this set whose elements range from fromElement to toElement.

        /** SortedSet<E>	subSet(E fromElement, E toElement) */
        // Returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive.

        /** SortedSet<E>	tailSet(E fromElement) */
        // Returns a view of the portion of this set whose elements are greater than or equal to fromElement.

        /** NavigableSet<E>	tailSet(E fromElement, boolean inclusive) */
        // Returns a view of the portion of this set whose elements are greater than (or equal to, if inclusive is true) fromElement.

    }

    public void map() {

        /** An object that maps keys to values. Does not inherit from Collection interface */
        Map<String, Integer> map = null;

        /** void	clear() */
        // Removes all of the mappings from this map (optional operation).
        map.clear();



        /** default V	compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction) */
        /* Attempts to compute a mapping for the specified key and its current mapped value
           (or null if there is no current mapping). */

        /** default V	computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction) */
        /* If the specified key is not already associated with a value (or is mapped to null),
           attempts to compute its value using the given mapping function and enters it into this map unless null. */

        /** default V	computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction) */
        /* If the value for the specified key is present and non-null, attempts to compute a new mapping given
           the key and its current mapped value. */



        /** boolean	containsKey(Object key) */
        // Returns true if this map contains a mapping for the specified key.
        boolean containsKey = map.containsKey("Key");

        /** boolean	containsValue(Object value) */
        // Returns true if this map maps one or more keys to the specified value.
        boolean containsValue = map.containsValue(1);

        /** Set<Map.Entry<K,V>>	entrySet() */
        // Returns a Set view of the mappings contained in this map.
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        /** boolean	equals(Object o) */
        // Compares the specified object with this map for equality.
        boolean equals = map.equals(new HashMap<>());

        /** default void	forEach(BiConsumer<? super K,? super V> action) */
        /* Performs the given action for each entry in this map until all entries have been processed
           or the action throws an exception. */
        BiConsumer<String, Integer> biConsumer = (key, value) -> System.out.println("Key: " + key + "; Value: " + value);
        map.forEach(biConsumer);

        /** V	get(Object key) */
        // Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
        Integer value = map.get("Key");

        /** default V	getOrDefault(Object key, V defaultValue) */
        /* Returns the value to which the specified key is mapped, or defaultValue if this map
           contains no mapping for the key. */
        Integer defaultValue = map.getOrDefault("Key", 1);

        /** int	hashCode() */
        // Returns the hash code value for this map.
        int hashCode = map.hashCode();

        /** boolean	isEmpty() */
        // Returns true if this map contains no key-value mappings.
        boolean isEmpty = map.isEmpty();

        /** Set<K>	keySet() */
        // Returns a Set view of the keys contained in this map.
        Set<String> keySet = map.keySet();



        /** default V	merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction) */
        /* If the specified key is not already associated with a value or is associated with null,
           associates it with the given non-null value. */



        /** V	put(K key, V value) */
        // Associates the specified value with the specified key in this map (optional operation).
        Integer valuePut = map.put("Key", 1);

        /** void	putAll(Map<? extends K,? extends V> m) */
        // Copies all of the mappings from the specified map to this map (optional operation).
        map.putAll(new HashMap<>());

        /** default V	putIfAbsent(K key, V value) */
        /* If the specified key is not already associated with a value (or is mapped to null) associates
           it with the given value and returns null, else returns the current value. */
        valuePut = map.putIfAbsent("Key", 1);

        /** V	remove(Object key) */
        // Removes the mapping for a key from this map if it is present (optional operation).
        Integer removedValue = map.remove("Key");

        /** default boolean	remove(Object key, Object value) */
        // Removes the entry for the specified key only if it is currently mapped to the specified value.
        boolean wasRemoved = map.remove("Key", 2);

        /** default V	replace(K key, V value) */
        // Replaces the entry for the specified key only if it is currently mapped to some value.
        Integer replacedValue = map.replace("Key", 10);

        /** default boolean	replace(K key, V oldValue, V newValue) */
        // Replaces the entry for the specified key only if currently mapped to the specified value.
        boolean wasReplaced = map.replace("Key", 10, 20);

        /** default void	replaceAll(BiFunction<? super K,? super V,? extends V> function) */
        /* Replaces each entry's value with the result of invoking the given function on that entry until
           all entries have been processed or the function throws an exception. */
        BiFunction<String, Integer, Integer> biFunction = (k, v) -> 1;
        map.replaceAll(biFunction);

        /** int	size() */
        // Returns the number of key-value mappings in this map.
        int mapSize = map.size();

        /** Collection<V>	values() */
        //Returns a Collection view of the values contained in this map.
        Collection<Integer> values = map.values();

    }

    public void sortedMap() {

        /** A Map that further provides a total ordering on its keys. */
        SortedMap<String, Integer> sortedMap = null;

        /** Comparator<? super K>	comparator() */
        /* Returns the comparator used to order the keys in this map, or null if this map uses the
           natural ordering of its keys. */

        /** Set<Map.Entry<K,V>>	entrySet() */
        // Returns a Set view of the mappings contained in this map.

        /** K	firstKey() */
        // Returns the first (lowest) key currently in this map.

        /** SortedMap<K,V>	headMap(K toKey) */
        // Returns a view of the portion of this map whose keys are strictly less than toKey.

        /** Set<K>	keySet() */
        // Returns a Set view of the keys contained in this map.

        /** K	lastKey() */
        // Returns the last (highest) key currently in this map.

        /** SortedMap<K,V>	subMap(K fromKey, K toKey) */
        // Returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive.

        /** SortedMap<K,V>	tailMap(K fromKey) */
        // Returns a view of the portion of this map whose keys are greater than or equal to fromKey.

        /** Collection<V>	values() */
        // Returns a Collection view of the values contained in this map.

    }

    public void navigableMap() {

        /** A SortedMap extended with navigation methods returning the closest matches for given search targets. */
        NavigableMap<String, Integer> navigableMap = null;

        /** Map.Entry<K,V>	ceilingEntry(K key) */
        /* Returns a key-value mapping associated with the least key greater than or equal to the given key, or null if
           there is no such key. */

        /** K	ceilingKey(K key) */
        // Returns the least key greater than or equal to the given key, or null if there is no such key.

        /** NavigableSet<K>	descendingKeySet() */
        // Returns a reverse order NavigableSet view of the keys contained in this map.

        /** NavigableMap<K,V>	descendingMap() */
        // Returns a reverse order view of the mappings contained in this map.

        /** Map.Entry<K,V>	firstEntry() */
        // Returns a key-value mapping associated with the least key in this map, or null if the map is empty.

        /** Map.Entry<K,V>	floorEntry(K key) */
        /* Returns a key-value mapping associated with the greatest key less than or equal to the given key,
           or null if there is no such key. */

        /** K	floorKey(K key) */
        // Returns the greatest key less than or equal to the given key, or null if there is no such key.

        /** SortedMap<K,V>	headMap(K toKey) */
        // Returns a view of the portion of this map whose keys are strictly less than toKey.

        /** NavigableMap<K,V>	headMap(K toKey, boolean inclusive) */
        // Returns a view of the portion of this map whose keys are less than (or equal to, if inclusive is true) toKey.

        /** Map.Entry<K,V>	higherEntry(K key) */
        /* Returns a key-value mapping associated with the least key strictly greater than the given key,
           or null if there is no such key. */

        /** K	higherKey(K key) */
        // Returns the least key strictly greater than the given key, or null if there is no such key.

        /** Map.Entry<K,V>	lastEntry() */
        // Returns a key-value mapping associated with the greatest key in this map, or null if the map is empty.

        /** Map.Entry<K,V>	lowerEntry(K key) */
        /* Returns a key-value mapping associated with the greatest key strictly less than the given key,
           or null if there is no such key. */

        /** K	lowerKey(K key) */
        // Returns the greatest key strictly less than the given key, or null if there is no such key.

        /** NavigableSet<K>	navigableKeySet() */
        // Returns a NavigableSet view of the keys contained in this map.

        /** Map.Entry<K,V>	pollFirstEntry() */
        // Removes and returns a key-value mapping associated with the least key in this map, or null if the map is empty.

        /** Map.Entry<K,V>	pollLastEntry() */
        // Removes and returns a key-value mapping associated with the greatest key in this map, or null if the map is empty.

        /** NavigableMap<K,V>	subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) */
        // Returns a view of the portion of this map whose keys range from fromKey to toKey.

        /** SortedMap<K,V>	subMap(K fromKey, K toKey) */
        // Returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive.

        /** SortedMap<K,V>	tailMap(K fromKey) */
        // Returns a view of the portion of this map whose keys are greater than or equal to fromKey.

        /** NavigableMap<K,V>	tailMap(K fromKey, boolean inclusive) */
        // Returns a view of the portion of this map whose keys are greater than (or equal to, if inclusive is true) fromKey.

    }

    public void queue() {

        /** A collection designed for holding elements prior to processing. */
        Queue<String> queue = null;

        /** boolean	add(E e) */
        /* Inserts the specified element into this queue if it is possible to do so immediately without
           violating capacity restrictions, returning true upon success and throwing an IllegalStateException
           if no space is currently available. */
        boolean added = queue.add("String");

        /** E	element() */
        // Retrieves, but does not remove, the head of this queue.
        String elem = queue.element();

        /** boolean	offer(E e) */
        /* Inserts the specified element into this queue if it is possible to do so immediately
           without violating capacity restrictions. */
        boolean wasOffered = queue.offer("String2");

        /** E	peek() */
        // Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        String peekedStr = queue.peek();

        /** E	poll() */
        // Retrieves and removes the head of this queue, or returns null if this queue is empty.
        String polledStr = queue.poll();

        /** E	remove() */
        // Retrieves and removes the head of this queue.
        String removedStr = queue.remove();

    }

    public void deque() {

        /** A linear collection that supports element insertion and removal at both ends.
         *  Implements Queue interface */

        Deque<String> deque = null;


        /** boolean	add(E e) */
        /* Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque)
           if it is possible to do so immediately without violating capacity restrictions, returning true upon success
           and throwing an IllegalStateException if no space is currently available. */
        boolean added = deque.add("String");

        /** void addFirst(E e) */
        /* Inserts the specified element at the front of this deque if it is possible to do so immediately
           without violating capacity restrictions, throwing an IllegalStateException if no space is currently available. */
        deque.addFirst("FirstString");

        /** void addLast(E e) */
        /* Inserts the specified element at the end of this deque if it is possible to do so immediately without
           violating capacity restrictions, throwing an IllegalStateException if no space is currently available. */
        deque.addLast("LastString");

        /** boolean	contains(Object o) */
        // Returns true if this deque contains the specified element.
        boolean contains = deque.contains("String"); //true

        /** Iterator<E>	descendingIterator() */
        // Returns an iterator over the elements in this deque in reverse sequential order.
        Iterator<String> descendingIterator = deque.descendingIterator();

        /** E	element() */
        /* Retrieves, but does not remove, the head of the queue represented by this deque
           (in other words, the first element of this deque). */
        String firstElement = deque.element();

        /** E	getFirst() */
        // Retrieves, but does not remove, the first element of this deque.
        firstElement = deque.getFirst();

        /** E	getLast() */
        // Retrieves, but does not remove, the last element of this deque.
        String lastElement = deque.getLast();

        /** Iterator<E>	iterator() */
        // Returns an iterator over the elements in this deque in proper sequence.
        Iterator<String> iterator = deque.iterator();

        /** boolean	offer(E e) */
        /* Inserts the specified element into the queue represented by this deque
           (in other words, at the tail of this deque) if it is possible to do so immediately without
           violating capacity restrictions, returning true upon success and false if no space is currently available. */
        boolean offered = deque.offer("OfferedString");

        /** boolean	offerFirst(E e) */
        // Inserts the specified element at the front of this deque unless it would violate capacity restrictions.
        boolean offeredFirst = deque.offerFirst("OfferedFirstString");

        /** boolean	offerLast(E e) */
        // Inserts the specified element at the end of this deque unless it would violate capacity restrictions.
        boolean offeredLast = deque.offerLast("OfferedLastString");

        /** E	peek() */
        /* Retrieves, but does not remove, the head of the queue represented by this deque
           (in other words, the first element of this deque), or returns null if this deque is empty. */
        String peeked = deque.peek();

        /** E	peekFirst() */
        // Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
        String peekedFirst = deque.peekFirst();

        /** E	peekLast() */
        // Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
        String peekedLast = deque.peekLast();

        /** E	poll() */
        /* Retrieves and removes the head of the queue represented by this deque
           (in other words, the first element of this deque), or returns null if this deque is empty. */
        String polled = deque.poll();

        /** E	pollFirst() */
        // Retrieves and removes the first element of this deque, or returns null if this deque is empty.
        String polledFirst = deque.pollFirst();

        /** E	pollLast() */
        // Retrieves and removes the last element of this deque, or returns null if this deque is empty.
        String polledLast = deque.pollLast();

        /** E	pop() */
        // Pops an element from the stack represented by this deque.
        String popped = deque.pop();

        /** void	push(E e) */
        /* Pushes an element onto the stack represented by this deque
           (in other words, at the head of this deque) if it is possible to do so immediately
           without violating capacity restrictions, throwing an IllegalStateException if no space is currently available. */
        deque.push("PushedString");

        /** E	remove() */
        /* Retrieves and removes the head of the queue represented by this deque
           (in other words, the first element of this deque). */
        String removed = deque.remove();

        /** boolean	remove(Object o) */
        // Removes the first occurrence of the specified element from this deque.
        boolean wasRemoved = deque.remove("String");

        /** E	removeFirst() */
        // Retrieves and removes the first element of this deque.
        String removedFirst = deque.removeFirst();

        /** E	removeLast() */
        // Retrieves and removes the last element of this deque.
        String removedLast = deque.removeLast();

        /** boolean	removeFirstOccurrence(Object o) */
        // Removes the first occurrence of the specified element from this deque.
        boolean removedFirstOccur = deque.removeFirstOccurrence("String");

        /** boolean	removeLastOccurrence(Object o) */
        // Removes the last occurrence of the specified element from this deque.
        boolean removedLastOccur = deque.removeLastOccurrence("String");

        /** int	size() */
        // Returns the number of elements in this deque.
        int dequeSize = deque.size();

    }




}

