package com.prometheus.learning.lang;

/**
 * Class Object is the root of the class hierarchy. Every class extends Object implicitly
 * and every object is type compatible with Object.
 */

public class Objects {

    public void objects() {
        
        Object object = new Integer(1);

        /** Every object inherits the methods from Object class and they can be overridden. */

        object.equals(object); //returns true if objects have the same reference
        object.hashCode(); //returns the hash code (integer) of the object, used in hashtables
        object.toString(); //returns the string representation of the object,
        //by default return object.getClass().getName() + "@" + Integer.toHexString(object.hashCode())
        object.getClass(); //returns the runtime class of the object - class java.main.java.learning.lang.Integer

        //object.clone(); //Overridden in subclass, overriding class must implement Cloneable
        //object().finalize(); //Overridden in subclass, Called by the garbage collector on an object when
        //garbage collection determines that there are no more references to the object.

        /** Multitheading methods */
        try {
            //Causes the current thread to wait until another thread invokes the notify()
            //method or the notifyAll() method for this object
            object.wait();

            //Causes the current thread to wait until either another thread invokes the notify() method or
            //the notifyAll() method for this object, or a specified amount of time has elapsed.
            object.wait(100);

            //Same as previous but with more precise time measure
            object.wait(100,100);

            //Wakes up a single thread that is waiting on this object's monitor.
            object.notify();

            //Wakes up all threads that are waiting on this object's monitor.
            object.notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
