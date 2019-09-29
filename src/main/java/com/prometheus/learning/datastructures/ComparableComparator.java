package com.prometheus.learning.datastructures;

import java.util.*;

public class ComparableComparator {


    /**
     * Comparable objects have to implement Comparable<ObjectType> interface
     * and its compareTo(ObjectType type) method. Objects that implement
     * Comparable can be ordered in one way defined by compareTo method
     * and defines the natural ordering of objects of this type.
     */
    public void comparable() {

        Person person1 = new Person("Reemet", 29);
        Person person2 = new Person("Kalmer", 21);
        Person person3 = new Person("Viktor", 38);
        Person person4 = new Person("Sirle", 25);
        Person person5 = new Person("Kersti", 29);

        List<Person> people = new ArrayList<>();
        people.addAll(Arrays.asList(person1, person2, person3, person4, person5));

        Collections.sort(people);

        for(Person person : people) {
            System.out.println(person);
        }



    }

    /**
     * Comparators are defined separate from the class whose objects they are ordering.
     * Comparators can be defined as a class, can be implemented with object creation
     * or be given to Collections.sort method as anonymous classes. A class
     * implementing a Comparator interface has to implement its one method
     * compare(Object o1, Object o2)
     */
    public void comparator() {

        Person person1 = new Person("Reemet", 29);
        Person person2 = new Person("Kalmer", 21);
        Person person3 = new Person("Viktor", 38);
        Person person4 = new Person("Sirle", 25);
        Person person5 = new Person("Kersti", 29);

        List<Person> people = new ArrayList<>();
        people.addAll(Arrays.asList(person1, person2, person3, person4, person5));

        Collections.sort(people, new PersonComparator());

        for(Person person : people) {
            System.out.println(person);
        }

        System.out.println("---------------------");

        Comparator<Person> personComparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };

        Collections.sort(people, personComparator);

        for(Person person : people) {
            System.out.println(person);
        }

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if(p1.getAge() > p2.getAge()) return 1;
                else if(p1.getAge() < p2.getAge()) return -1;
                else return 0;
            }
        });

        for(Person person : people) {
            System.out.println(person);
        }


    }

    public void lambdaComparator() {

        Person person1 = new Person("Reemet", 29);
        Person person2 = new Person("Kalmer", 21);
        Person person3 = new Person("Viktor", 38);
        Person person4 = new Person("Sirle", 25);
        Person person5 = new Person("Kersti", 29);

        List<Person> people = new ArrayList<>();
        people.addAll(Arrays.asList(person1, person2, person3, person4, person5));

        Collections.sort(people, (p1, p2) -> {
            if(p1.getAge() > p2.getAge()) return 1;
            else if (p1.getAge() < p2.getAge()) return -1;
            else return 0;
        });


        Comparator<Person> personComparator1 = (p1,p2) -> p1.getName().compareTo(p2.getName());

        /** If Person is Comparable */
        Comparator<Person> personComparator2 = Person::compareTo;

        /** Defining Comparator with Function */
        Comparator<Person> personComparator3 = Comparator.comparing(Person::getName);


    }

    public class PersonComparator implements Comparator<Person> {

        /**
         * if p1.value < p2.value returns -1 (1), then p1 comes before (after) p2 in ordering,
         * which means the order will be ascending (descending)
         */
        @Override
        public int compare(Person p1, Person p2) {
            if(p1.getAge() > p2.getAge()) return 1;
            else if(p1.getAge() < p2.getAge()) return -1;
            else return 0;
        }

    }

    public class Person implements Comparable<Person> {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /**
         * if this.value < person.value returns -1 (1), then 'this' becomes before (after) person in their ordering,
         * which means the ordering will be ascending (descending)
         */
        @Override
        public int compareTo(Person person) {
            if(this.age > person.getAge()) return 1;
            else if(this.age < person.age) return -1;
            else return 0;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return this.name + " : " + this.age;
        }


    }

}
