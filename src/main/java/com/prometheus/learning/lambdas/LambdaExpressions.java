package com.prometheus.learning.lambdas;

import java.util.*;

/**
 * Lambda expression is a feature of Java 8 that simplifies work
 * with interfaces that have only one method. They are often used with anonymous classes.
 * Using lambda expressions often shorten the code considerably. Interfaces with
 * only one method are called functional interfaces
 */
public class LambdaExpressions {

    public void lambdaExpressions() {

        /** Lambda expressions are written as (argument list) -> {actions} */

        /** Creating a thread with single line runnable task using lambda */
        new Thread(()-> System.out.println("Runnable task reated with lambda"));

        /** Creating a thread with multi line runnable task using lambda */
        new Thread(()-> {
            System.out.println("Runnable task with lambda 1");
            System.out.println("Runnable task with lambda 2");
            System.out.println("Runnable task with lambda 3");
        });

        Runnable runnable = () -> System.out.println("Runnable instance");

        /** Lambda expression body surrounded with curly braces has to end each statement with a semicolon,
         * while in single statement lambda without curly braces the semicolon is not needed. */

        /** When a lambda requires only one parameter, it can be written without parenthesis */


        List<Employee> employees = new ArrayList<>();
        Employee reemet = new Employee("Reemet", 29);
        Employee toomas = new Employee("Toomas", 25);
        Employee kalle = new Employee("Kalle", 24);
        Employee villu = new Employee("Villu", 35);
        Employee andres = new Employee("Andres", 42);
        employees.addAll(Arrays.asList(reemet, toomas, kalle, villu, andres));

        /** Sorting employees by name with 2 ways using lambdas */
        Collections.sort(employees, (Employee employee1, Employee employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        /** Since the type of comparable objects can be determined from employees list,
         * the types on lambda parameters can be left undefined */
        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        /** Simplify the lambda even further */
        Collections.sort(employees, (Comparator.comparing(Employee::getName)));

        /** Printing out names of each employee using lambda */
        employees.forEach(employee -> System.out.println(employee.getName()));

        List<String> names = new ArrayList<>(Arrays.asList("name1","name2","name3"));
        names.forEach(System.out::println);

        /** Lambdas in JavaFX */

        //Button button = new Button();

        /** Lambdas can be used with all kinds of action listeners on an object */
        /*button.setOnAction(event -> {
            System.out.println("Button clicked");
            System.out.println("Actions based on click");
        });

        button.setOnKeyPressed(event -> System.out.println("Key pressed")); */

        /** Assigning a lambda to a variable that can be use later. The return
         * statement of the the expression is implicit with one statement lambda body,
         * but with multi statement lambda body the return has to be explicitly written */
        UpperConcat uc = (String s1, String s2) -> s1.toUpperCase() + s2.toUpperCase();
        uc = (String s1, String s2) -> {
            String str = s1.toUpperCase() + s2.toUpperCase();
            return str;
        };
        /** Shorter lambda */
        uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        /** Method reference */
        uc = (String::concat);

        /** And now the UpperConcat lambda implementation 'uc' can be used */
        String str = uc.upperAndConcat("String1", "String2");

    }

    interface UpperConcat {
        public String upperAndConcat(String s1, String s2);
    }

    class Employee {



        String name;
        int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

    }


}
