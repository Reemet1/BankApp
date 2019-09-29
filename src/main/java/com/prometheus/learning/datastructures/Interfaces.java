package com.prometheus.learning.datastructures;

import java.util.*;

public class Interfaces {

    public void interfaces() {
    }

    public void collection() {
        /**The top interface for collections hierarchy is Collection interface */
        Collection collection = null;
        collection.clear(); //Removes all elements from this collection
        collection.isEmpty(); //Returns true if collection has no elemenents
        collection.size(); //Returns the number of elements in collection
        collection.add(1); //Adds a single element of type <Type> to this collection
        collection.addAll(new ArrayList()); //Adds a collection of elements into collection
        collection.contains(1); //Returns true if collection contains a given element
        collection.containsAll(new ArrayList<>()); //Returns true if collection contains all elements in a given collection
        collection.remove(1); //Removes given object from collection
        collection.removeAll(new ArrayList<>()); //Removes all elemenents present in a given collection
        collection.iterator(); //Returns an Iterator that can be used to traverse through the elements
        collection.toArray(); //Returns Object[] that contains the elements of collection
    }

    public void list() {
        /** Collection interface is extended by the following interfaces */
        List list = null;
        list.add(1, new Object()); //Adds an object to specified index
        list.get(1); //Returns the element in given index
        list.indexOf(new Object()); //Returns the index of given object
        list.set(0, 10);
        list.remove(0);
    }

    public void set() {
        /** There are no duplicate elements (a.equals(b)) in Set (maximum of one null element) */
        Set set = null;
        set.add(1);
        set.remove(1);
        set.contains(1);
        set.iterator();
    }

    public void queue() {
        Queue queue = null;
    }


    public void map() {

        /** Map is not an extension of Collection */
        Map map = null;
        map.get("keyName"); //Get object with key 'keyName'
        map.keySet(); //Returns a Set of all the keys of this map
        map.put("keyName", "value"); //Puts a new value, which will be referred with key 'keyValue'
        map.values(); //Values or this map
        map.containsKey("keyValue"); //Returns true if keyValue is in the keySet
        map.remove("keyValue");

        /** Keys of maps are unique and form a set. When using put() method on key
         *  that already exists, the value for that key will be overwritten.
         *  put() will return the previous value if it existed or null
         */
    }


}
