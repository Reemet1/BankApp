package com.prometheus.learning.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Stream;

public class FunctionalProgramming {

    /**
     * Functional interfaces are descripted in java.util.function package API.
     */

    public void funactionalProgramming() {


    }

    public void predicates() {
        List<Employee> employees = new ArrayList<>();
        Employee reemet = new Employee("Reemet", 29);
        Employee toomas = new Employee("Toomas", 25);
        Employee kalle = new Employee("Kalle", 24);
        Employee villu = new Employee("Villu", 35);
        Employee andres = new Employee("Andres", 42);
        employees.addAll(Arrays.asList(reemet, toomas, kalle, villu, andres));

        /** Predicates enable a predefined test conditions.
         *  parameter -> boolean condition */
        Predicate<Employee> testCondition = employee -> employee.getAge() > 30;

        for(Employee employee : employees) {
            if(testCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }

        IntPredicate intPredicate1 = i -> i > 0;
        IntPredicate intPredicate2 = i -> i < 50;
        System.out.println(intPredicate1.test(15));

        /** Composing predicates */
        System.out.println(intPredicate1.and(intPredicate2).test(60));

        /** Chained predicate can be assigned as a separate predicate */
        IntPredicate chained = intPredicate1.and(intPredicate2).or(intPredicate1).negate();
        chained.test(20);
    }

    public void suppliers() {

        /** Generating random integers using Supplier. Supplier takes no arguments
         *  but always return an object defined in diamond brackets */
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        int random = randomSupplier.get();

    }

    public void consumers() {

        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                s += "test";
            }
        };

        Consumer<String> consumer2 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> consumer3 = consumer1.andThen(consumer2);
        consumer3.accept("str");

        Consumer<String> consumer4 = s -> System.out.println("Consumer");

    }

    public void functions() {

        /**
         * Consumer - doesnt return a value
         * Supplier - doesnt accept a parameter
         * Predicate - returns only boolean
         * Function - takes parameter and returns a value
         */

        Employee reemet = new Employee("Reemet Ammer", 29);

        /** First type parameter is lambda parameter type and second type parameter is
         *  lambda's return type,
         */
        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(" "));
        };

        /** Shorter way */
        getFirstName = employee -> {
            return employee.getName().substring(0, employee.getName().indexOf(" "));
        };
        System.out.println("First name: " + getFirstName.apply(reemet));

        /** Chaining functions. When chaining functions, the return type of the
         *  first function must match the argument type(s) of the second function */

        Function<String, String> upperCase = arg -> arg.toUpperCase();
        Function<String, String> firstLetter = arg -> arg.substring(0,1);
        Function<String, String> chainedFunction = upperCase.andThen(firstLetter);

        /** Same as andThen() but in reverse order */
        firstLetter.compose(upperCase);

        System.out.println("Uppercase first letter: " + chainedFunction.apply("Reemet"));

        /** Bifunction takes 2 arguments and returns a value */
        BiFunction<Integer, String, String> biFunction = (i, str) -> {
            return str + " " + i;
        };

        System.out.println(biFunction.apply(10, "Number is"));

        /** UnaryOperator accepts a single argument and returns an object of the same type */
        UnaryOperator<String> uppercase = str -> str.toUpperCase();

        Stream<String> strs = Stream.generate(() -> new String("abc"));

        /** Constructor reference */
        strs = Stream.generate(String::new);


    }

    public void primitiveFunctionalInterfaces() {

        /** Primitive predicate's test(x) method accepts a parameter of type int, long or double */
        IntPredicate intPredicate = i -> i == 0;
        LongPredicate longPredicate = l -> l > 0;
        DoublePredicate doublePredicate = d -> d < 0;

        intPredicate.test(1);
        longPredicate.test(1L);
        doublePredicate.test(1d);

        /** The previous predicates are equivalent to predicates of the Wrapper classes,
         *  but produce ore overhead at compile and runtime due to autoboxing */
        Predicate<Integer> intObjPredicate;
        Predicate<Long> longObjPredicate;
        Predicate<Double> doubleObjPredicate;

        /** The same rules apply for xxxConsumer, xxxProducer, xxxSupplier */

        /** Supplies also has boolean type */
        BooleanSupplier booleanSupplier;

        /** With primitive functions there are more options */

        /** Accepts int, long or double and returns Object */
        IntFunction intFunction;
        LongFunction longFunction;
        DoubleFunction doubleFunction;

        /** Accepts int, long or double and returns X */
        IntFunction<Integer> intIntFunction;
        LongFunction<Long> longLongFunction;
        DoubleFunction<Double> doubleDoubleFunction;

        /** XToYFunction - Accepts X and returns Y */
        IntToDoubleFunction intToDoubleFunction;
        IntToLongFunction intToLongFunction;
        LongToDoubleFunction longToDoubleFunction;
        LongToIntFunction longToIntFunction;
        DoubleToIntFunction doubleToIntFunction;
        DoubleToLongFunction doubleToLongFunction;
        
    }

    /** BiFunctional interfaces are functional interfaces with which take 2 parameters */
    public void binaryFunctionalInterfaces() {

        BiPredicate<String, Integer> biPredicate = (s,i) -> s.isEmpty() && i > 0;
        BiConsumer<String, Integer> biConsumer = (s,i) -> System.out.println(s + i);
        BiFunction<String, Integer, String> biFunction = (s,i) -> s + i.toString();
        /** Supplier has to binary version, since it has no parameters */

        biPredicate.test("str", 1);
        biConsumer.accept("str", 1);
        String result = biFunction.apply("str", 1);

        /** First parameter must be Integer and second parameter int, long or double */
        ObjIntConsumer<Integer> objIntConsumer = (i1,i2) -> {};
        ObjLongConsumer<Integer> objLongConsumer = (i,l) -> {};
        ObjDoubleConsumer<Integer> objDoubleConsumer = (i,d) -> {};
        objIntConsumer.accept(new Integer(1), 1);
        objLongConsumer.accept(new Integer(1), 1L);
        objDoubleConsumer.accept(new Integer(1), 1d);

        /** Returns primitive type int, long or double */
        ToIntBiFunction<String, Integer> toIntBiFunction = (s,i) -> 1;
        ToLongBiFunction<String, Integer> toLongBiFunction = (s,i) -> 1L;
        ToDoubleBiFunction<String, Integer> toDoubleBiFunction = (s,i) -> 1d;

        toIntBiFunction.applyAsInt("str", 1);
        toLongBiFunction.applyAsLong("str", 1);
        toDoubleBiFunction.applyAsDouble("str",1);


        /** BinaryOperator is a subinterface of BiFunction, in which the types
         *  of 2 parameters and return type are all the same */
        BinaryOperator<Integer> binaryOperator = (i1,i2) -> i1+i2;
        IntBinaryOperator intBinaryOperator = (i1,i2) -> i1+i2;
        LongBinaryOperator longBinaryOperator = (l1,l2) -> l1-l2;
        DoubleBinaryOperator doubleBinaryOperator = (d1,d2) -> d1*d2;

        Integer result1 = binaryOperator.apply(new Integer(1),new Integer(2));
        int result2 = intBinaryOperator.applyAsInt(1,2);
        long result3 = longBinaryOperator.applyAsLong(3L,4L);
        double result4 = doubleBinaryOperator.applyAsDouble(5d,6d);

    }

    public void unaryOperators() {

        /** UnaryOperator is a subinterface of Function, and takes only one parameter instead of two */
        UnaryOperator<Integer> unaryOperator = i -> i*i;
        Integer square = unaryOperator.apply(2);

        List<String> strings = new ArrayList<>(Arrays.asList("str1", "str2", "str3"));
        strings.replaceAll(s -> s.toUpperCase());

    }

    public void methodReferences() {

        List<String> strings = new ArrayList<>();
        strings.add("str1");
        strings.add("str2");

        Stream<String> strStream = strings.stream();

        /** Static method reference (String.valueOf(Object)) */
        strStream.forEach(String::valueOf);

        /** Instance method reference (takes no argument)*/
        strStream.forEach(String::isEmpty);


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
