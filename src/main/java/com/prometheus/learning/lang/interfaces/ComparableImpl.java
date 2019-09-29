package com.prometheus.learning.lang.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class implementing Cloneable interface maintains a natural ordering (< = >) among its objects.
 * The natural ordering is determined by compareTo() method, which will be used
 * to order a list of objects of this class by Collections.sort(collection) method.
 */
public class ComparableImpl implements Comparable<ComparableImpl> {

    int value;

    public ComparableImpl(int value) {
        this.value = value;
    }

    /**
     * It is recommended that compareTo() method is in union with equals() method,
     * that means a.compareTo(b) == 0 if and only if a.equals(b).
     */
    @Override
    public int compareTo(ComparableImpl obj) {
        if(value < obj.value) return -1;
        else if (value > obj.value) return 1;
        else return 0;
    }

    public void comparableTest() {

        ComparableImpl c1 = new ComparableImpl(1);
        ComparableImpl c2 = new ComparableImpl(5);
        ComparableImpl c3 = new ComparableImpl(2);

        List<ComparableImpl> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        Collections.sort(list);

        System.out.println(list);

    }

    public String toString() {
        return value + "";
    }
}
