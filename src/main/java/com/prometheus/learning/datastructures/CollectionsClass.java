package com.prometheus.learning.datastructures;

import java.util.*;

public class CollectionsClass {

    public void collections() {

        /** Using an ArrayList in a constructor of new ArrayList only makes
         * a shallow copy of the ArrayList. That means modifying any object
         * in any of the arraylists also affects that same object in other arraylist.
         * The references of these 2 arraylists are different, but the objects
         * that they both contain will still have the same references */

        List<Person> people = new ArrayList<>();
        people.add(new Person("Reemet"));

        List<Person> shallowCopy = new ArrayList<>(people);
        shallowCopy.get(0).name = "Reemet1";

        System.out.println(people.get(0).name);


        List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList("Reemet", "Kalmer","Silver"));

        /** Sorts elements of an arraylist by their natural ordering */
        Collections.sort(names);

        /** Reverses the order of elements */
        Collections.reverse(names);

        /** Shuffles elements of an arraylist to random order */
        Collections.shuffle(names);


    }

    class Person {

        String name;

        public Person(String name) {
            this.name = name;
        }

    }

    public void collections1() {

        /** static <T> Queue<T>	asLifoQueue(Deque<T> deque) */
        // Returns a view of a Deque as a Last-in-first-out (Lifo) Queue.

        /** static <E> Set<E>	newSetFromMap(Map<E,Boolean> map) */
        // Returns a set backed by the specified map.


        /** Static methods of Collections class are divided into the following categories:
         *  modifying, information, (comparing, ordering, shuffling), (iterators & enumerations),
         *  singleton creation, empty creation, unmodifiable, synchronized, checked.
         */


        /** ----------------- MODIFYING DATA STRUCTURE ------------------- */

        /** static <T> boolean	addAll(Collection<? super T> c, T... elements) */
        // Adds all of the specified elements to the specified collection.

        /** static <T> void	copy(List<? super T> dest, List<? extends T> src) */
        // Copies all of the elements from one list into another.

        /** static <T> void	fill(List<? super T> list, T obj) */
        // Replaces all of the elements of the specified list with the specified element.

        /** static <T> List<T>	nCopies(int n, T o) */
        // Returns an immutable list consisting of n copies of the specified object.

        /** static <T> boolean	replaceAll(List<T> list, T oldVal, T newVal) */
        // Replaces all occurrences of one specified value in a list with another.

        /** static void	swap(List<?> list, int i, int j) */
        // Swaps the elements at the specified positions in the specified list.

        /** static void	rotate(List<?> list, int distance) */
        // Rotates the elements in the specified list by the specified distance.





        /** ------------------ DATA STRUCTURE INFORMATION ------------------ */

        /** static <T extends Object & Comparable<? super T>> T	max(Collection<? extends T> coll) */
        /* Returns the maximum element of the given collection, according to the natural ordering
        of its elements. */

        /** static <T> T	max(Collection<? extends T> coll, Comparator<? super T> comp) */
        /* Returns the maximum element of the given collection, according to the order
        induced by the specified comparator. */

        /** static <T extends Object & Comparable<? super T>> T	min(Collection<? extends T> coll) */
        /* Returns the minimum element of the given collection, according to the
        natural ordering of its elements. */

        /** static <T> T	min(Collection<? extends T> coll, Comparator<? super T> comp) */
        /* Returns the minimum element of the given collection, according to the order
        induced by the specified comparator. */

        /** static int	frequency(Collection<?> c, Object o) */
        // Returns the number of elements in the specified collection equal to the specified object.

        /** static int	indexOfSubList(List<?> source, List<?> target) */
        /* Returns the starting position of the first occurrence of the specified target list
        within the specified source list, or -1 if there is no such occurrence. */

        /** static int	lastIndexOfSubList(List<?> source, List<?> target) */
        /* Returns the starting position of the last occurrence of the specified target list
        within the specified source list, or -1 if there is no such occurrence. */

        /** static boolean	disjoint(Collection<?> c1, Collection<?> c2) */
        // Returns true if the two specified collections have no elements in common.

        /** static <T> int	binarySearch(List<? extends Comparable<? super T>> list, T key) */
        // Searches the specified list for the specified object using the binary search algorithm.

        /** static <T> int	binarySearch(List<? extends T> list, T key, Comparator<? super T> c) */
        // Searches the specified list for the specified object using the binary search algorithm.





        /** ---------------- COMPARING, ORDERING, SHUFFLING -------------- */

        /** static <T> Comparator<T> reverseOrder() */
        /* Returns a comparator that imposes the reverse of the natural ordering on a
        collection of objects that implement the Comparable interface. */
        Comparator<String> reverseComparator1 = Collections.reverseOrder();

        /** static <T> Comparator<T>	reverseOrder(Comparator<T> cmp) */
        // Returns a comparator that imposes the reverse ordering of the specified comparator.
        Comparator<String> reverseComparator2 = Collections.reverseOrder(String::compareTo);

        /** static void	shuffle(List<?> list) */
        // Randomly permutes the specified list using a default source of randomness.
        Collections.shuffle(new ArrayList<>(Arrays.asList(7,4,8,2,1)));

        /** static void	shuffle(List<?> list, Random rnd) */
        // Randomly permute the specified list using the specified source of randomness.

        /** static void	reverse(List<?> list) */
        // Reverses the order of the elements in the specified list.

        /** static <T extends Comparable<? super T>> void	sort(List<T> list) */
        /* Sorts the specified list into ascending order, according to the natural
           ordering of its elements. */

        /** static <T> void	sort(List<T> list, Comparator<? super T> c) */
        // Sorts the specified list according to the order induced by the specified comparator.






        /** ---------------- ITERATORS AND ENUMERATIONS ------------------- */

        /** static <T> Enumeration<T>	emptyEnumeration() */
        // Returns an enumeration that has no elements.

        /** static <T> Iterator<T>	emptyIterator() */
        // Returns an iterator that has no elements.

        /** static <T> Enumeration<T>	enumeration(Collection<T> c) */
        // Returns an enumeration over the specified collection.

        /** static <T> ListIterator<T>	emptyListIterator() */
        // Returns a list iterator that has no elements.

        /** static <T> ArrayList<T>	list(Enumeration<T> e) */
        /* Returns an array list containing the elements returned by the specified enumeration
        in the order they are returned by the enumeration. */





        /** -------------------- SINGLETON DATA STRUCTURES ------------------------ */

        /** static <T> Set<T>	singleton(T o) */
        // Returns an immutable set containing only the specified object.

        /** static <K,V> Map<K,V>	singletonMap(K key, V value) */
        // Returns an immutable map, mapping only the specified key to the specified value

        /** static <T> List<T>	singletonList(T o) */
        // Returns an immutable list containing only the specified object.




        /** ---------------------- EMPTY DATA STRUCTURE ------------------------------ */

        /** static <K,V> Map<K,V>	emptyMap() */
        // Returns an empty map (immutable).

        /** static <K,V> NavigableMap<K,V>	emptyNavigableMap() */
        // Returns an empty navigable map (immutable).

        /** static <K,V> SortedMap<K,V>	emptySortedMap() */
        // Returns an empty sorted map (immutable).
        Map<String, Integer> emptySortedMap = Collections.emptySortedMap();

        /** static <E> NavigableSet<E>	emptyNavigableSet() */
        // Returns an empty navigable set (immutable).

        /** static <T> Set<T>	emptySet() */
        //Returns an empty set (immutable).
        Set<String> emptySet = Collections.emptySet();

        /** static <E> SortedSet<E>	emptySortedSet() */
        // Returns an empty sorted set (immutable).

        /** static <T> List<T>	emptyList() */
        // Returns an empty list (immutable).



        Map<String, Integer> map = new HashMap<>();
        NavigableMap<String, Integer> navigableMap = new TreeMap<>();
        SortedMap<String, Integer> sortedMap = new TreeMap<>();

        List<String> list = new ArrayList<>();

        Set<String> set = new HashSet<>();
        TreeSet<String> navigableSet = new TreeSet<>();
        SortedSet<String> sortedSet = new TreeSet<>();


        /** -------------------- UNMODIFIABLE DATA STRUCTURES ---------------------------- */

        /** static <T> Collection<T>	unmodifiableCollection(Collection<? extends T> c) */
        // Returns an unmodifiable view of the specified collection.
        Collection<String> unmodifiableCollection = Collections.unmodifiableCollection(list);

        /** static <K,V> Map<K,V>	unmodifiableMap(Map<? extends K,? extends V> m) */
        // Returns an unmodifiable view of the specified map.
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);

        /** static <K,V> SortedMap<K,V>	unmodifiableSortedMap(SortedMap<K,? extends V> m) */
        // Returns an unmodifiable view of the specified sorted map.
        SortedMap<String, Integer> unmodifiableSortedMap = Collections.unmodifiableSortedMap(sortedMap);

        /** static <K,V> NavigableMap<K,V>	unmodifiableNavigableMap(NavigableMap<K,? extends V> m) */
        // Returns an unmodifiable view of the specified navigable map.
        NavigableMap<String, Integer> unmodifiableNavigableMap = Collections.unmodifiableNavigableMap(navigableMap);

        /** static <T> Set<T>	unmodifiableSet(Set<? extends T> s) */
        // Returns an unmodifiable view of the specified set.
        Set<String> unmodifiableSet = Collections.unmodifiableSet(set);

        /** static <T> SortedSet<T>	unmodifiableSortedSet(SortedSet<T> s) */
        //Returns an unmodifiable view of the specified sorted set.
        SortedSet<String> unmodifiableSortedSet = Collections.unmodifiableSortedSet(sortedSet);

        /** static <T> NavigableSet<T>	unmodifiableNavigableSet(NavigableSet<T> s) */
        // Returns an unmodifiable view of the specified navigable set.
        NavigableSet<String> unmodifiableNavigableSet = Collections.unmodifiableNavigableSet(navigableSet);

        /** static <T> List<T>	unmodifiableList(List<? extends T> list) */
        // Returns an unmodifiable view of the specified list.
        List<String> unmodifiableList = Collections.unmodifiableList(list);




        /** ---------------------- SYNCHRONIZED DATA STRUCTURES -------------------------- */

        /** static <T> Collection<T>	synchronizedCollection(Collection<T> c) */
        // Returns a synchronized (thread-safe) collection backed by the specified collection.

        /** static <T> SortedSet<T>	synchronizedSortedSet(SortedSet<T> s) */
        // Returns a synchronized (thread-safe) sorted set backed by the specified sorted set.

        /** static <T> NavigableSet<T>	synchronizedNavigableSet(NavigableSet<T> s) */
        // Returns a synchronized (thread-safe) navigable set backed by the specified navigable set.

        /** static <T> Set<T>	synchronizedSet(Set<T> s) */
        // Returns a synchronized (thread-safe) set backed by the specified set.

        /** static <K,V> Map<K,V>	synchronizedMap(Map<K,V> m) */
        // Returns a synchronized (thread-safe) map backed by the specified map.

        /** static <K,V> NavigableMap<K,V>	synchronizedNavigableMap(NavigableMap<K,V> m) */
        // Returns a synchronized (thread-safe) navigable map backed by the specified navigable map.

        /** static <K,V> SortedMap<K,V>	synchronizedSortedMap(SortedMap<K,V> m) */
        // Returns a synchronized (thread-safe) sorted map backed by the specified sorted map.

        /** static <T> List<T>	synchronizedList(List<T> list) */
        // Returns a synchronized (thread-safe) list backed by the specified list.





        /** ----------------------- CHECKED DATA STRUCTURES ------------------------------- */

        /** static <E> Collection<E>	checkedCollection(Collection<E> c, Class<E> type) */
        // Returns a dynamically typesafe view of the specified collection.

        /** static <E> Set<E>	checkedSet(Set<E> s, Class<E> type) */
        // Returns a dynamically typesafe view of the specified set.

        /** static <E> SortedSet<E>	checkedSortedSet(SortedSet<E> s, Class<E> type) */
        // Returns a dynamically typesafe view of the specified sorted set.

        /** static <E> NavigableSet<E>	checkedNavigableSet(NavigableSet<E> s, Class<E> type) */
        // Returns a dynamically typesafe view of the specified navigable set.

        /** static <K,V> Map<K,V>	checkedMap(Map<K,V> m, Class<K> keyType, Class<V> valueType) */
        // Returns a dynamically typesafe view of the specified map.

        /** static <K,V> NavigableMap<K,V>	checkedNavigableMap(NavigableMap<K,V> m, Class<K> keyType, Class<V> valueType) */
        // Returns a dynamically typesafe view of the specified navigable map.

        /** static <K,V> SortedMap<K,V>	checkedSortedMap(SortedMap<K,V> m, Class<K> keyType, Class<V> valueType) */
        // Returns a dynamically typesafe view of the specified sorted map.

        /** static <E> List<E>	checkedList(List<E> list, Class<E> type) */
        // Returns a dynamically typesafe view of the specified list.

        /** static <E> Queue<E>	checkedQueue(Queue<E> queue, Class<E> type) */
        //Returns a dynamically typesafe view of the specified queue.



    }


}
