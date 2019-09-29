package com.prometheus.learning.lambdas;


import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Streams, introduced in Java 8, are not like input/output streams.
 * A stream is a sequence of elements supporting sequential and
 * parallel aggregate operations.
 */

public class Streams {

    public void streams() {

        List<String> bingoNumbers = Arrays.asList("g14", "G16","G49","I26","O79");

        /** Ordering and printing numbers that start with G */
        /*bingoNumbers //Collection is a source of this stream
                .stream() //starts a stream
                .map(String::toUpperCase) //accepts a function, returns a value
                .filter(s -> s.startsWith("G")) //accepts a Predicate
                .sorted()
                .forEach(System.out::println); //accepts a Consumer, returns no stream */


        Predicate<String> predicate = s -> s.startsWith("G");
        Function<String, String> function = String::toUpperCase; //str -> str.toUpperCase()
        Consumer<String> consumer = System.out::println;

        /*new Predicate<String>() {
            @Override
            public boolean test(String o) {
                return false;
            }
        };

        new Function<String, String>() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        };

        new Consumer<>() {
            @Override
            public void accept(Object o) {
            }
        }; */

        bingoNumbers.stream().map(function).filter(predicate).forEach(consumer);

        /**Order of aggregates can be changed */
        bingoNumbers.stream().filter(predicate).map(function).forEach(consumer);

        int[] numbers = {1,2,3,4,5,6,7,8,9};
        Arrays.stream(numbers)
                .map(i -> i*3)
                .filter(i -> i < 15 && i % 2 == 0)
                .forEach(System.out::println);

        List<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        numberList.removeIf(i -> i % 2 == 0); //removes all pair numbers from numberList

        /** Instead of printing out the resulting stream, it can be saved into a
         *  new list variable with collect() */
        List<Integer> collected =
                numberList
                .stream()
                .peek(i -> System.out.println(i)) //takes Consumer, used for logging mostly
                .map(i -> i*3) //takes Function
                .filter(i -> i < 15 && i % 2 == 0) //takes Predicate
                .collect(Collectors.toList());
                //.collect(ArrayList::new, ArrayList::add, ArrayList::addAll); //equivalent

        /** The operations on a stream are not executed if the chain doesn't end with
         *  terminal operator, i.e streams are lazily operated
         */

        /** Creating streams */
        Stream<Integer> intStream1 = Stream.of(1,2,3,4,5,6,7,8,9);
        Stream<Integer> intStream2 = Stream.of(10,11,12,13,14,15,16,17,1,2,3,4,5,6);
        Stream<Integer> filteredStream = intStream1.filter(i -> i % 2 == 0);

        /** forEach in Stream does not guarantee the order of elements, that means it is nondeterministic*/
        intStream1.forEach(i -> System.out.println(i));

        /** forEach from List guarantees the order of elements that are being operated,
         *  that means its deterministic */
        collected.forEach(i -> System.out.println(i));

        Stream<Integer> newStream = collected.stream();

        /**Concatenating streams */
        Stream<Integer> concatStream = Stream.concat(intStream1, intStream2);
        Stream<Integer> noDuplicateStream  = concatStream.distinct(); //uses equals()

        /** A stream pipeline can be used only once (otherwise an IllegalStateException is thrown),
         *  and the input data should not be modifier during stream pipelining. Though when
         *  a resulting stream of one aggregate operation is referenced to variable, the
         *  stream saved into that variable can be used again */

        /** Source elements are passed and processed through the stream pipeline one by one */

        /** Primitive streams */
        Test test1 = new Test(1,2,3);
        Test test2 = new Test(4,5,6);
        Stream<Test> stream = Stream.of(test1, test2);

        IntStream intStream = stream.mapToInt(p -> p.intValue);
        LongStream longStream = stream.mapToLong(p -> p.longValue);
        DoubleStream doubleStream = stream.mapToDouble(p -> p.doubleValue);

    }

    public void streamSearching() {

        Test test1 = new Test(1,2,3);
        Test test2 = new Test(4,5,6);
        Stream<Test> stream = Stream.of(test1, test2);

        /** Gets a random element in a stream or an empty Optional, if stream is empty */
        Optional<Test> findAny = stream.findAny();
        Test result1 = findAny.get();

        /** Gets the first element in a stream or an empty Optional, is stream is empty */
        Optional<Test> findFirst = stream.findFirst();
        Test resyult2 = findFirst.get();

        /** Returns true if any of the values match the predicate, otherwise when stream is empty
         *  or none of the elements in a stream matches the predicate, return false */
        boolean anyMatch = stream.anyMatch(i -> i.doubleValue > 0);

        /** Returns true if all of the values match the predicate or the stream is empty, otherwise
         * if at least of the elements in a stream doesn't match the predicate, return false */
        boolean allMatch = stream.allMatch(i -> i.doubleValue > 0);

        /** Returns true if none of the values match the predicate or the stream is empty */
        boolean noneMatch = stream.noneMatch(i -> i.doubleValue > 0);

        /** The previous search methods are short-circuiting, meaning when the result
         *  is already known to be true or false, the rest of the elements will not be checked
         *  agaisnt the predicate */


    }

    public void optionalClass() {

        /** The Optional class was introduced to avoid null-references */

        String str = null;

        /** NullPointerExeption */
        //str.toUpperCase();

        if(str != null) {
            System.out.println(str.toUpperCase());
        }

        /** It is better to use Optional class instead of null check */
        Optional<String> optStr = Optional.empty();

        /** NoSuchElementException */
        //optStr.get().toUpperCase();

        if(optStr.isPresent()) {
            /** get() should only be used when the object is guaranteed to be non-empty */
            System.out.println(optStr.get().toUpperCase());
        }

        /** Optional class does not have public constructors, so its instances can only be
         *  created via static factory methods. */

        /** Creating Optional instances */
        Optional<Object> optInst1 = Optional.empty(); //creates empty instance
        Optional<String> optInst2 = Optional.of("String"); //Creates Optional instance with value "String"
        //Optional<String> optInts3 = Optional.of(null); //NullPointerException

        Optional<String> optInst4 = Optional.ofNullable("String"); //Creates Optional instance with value "String"
        Optional<String> optInst5 = Optional.ofNullable(null); //Returns empty object, no exception

        /** Retrieving value from Optional instance */
        String value = optInst2.get(); //gets a value "String"
        //optInst1.get(); //NoSuchElementException
        /** orElse can be used to return an alternative value when the initial value is empty */
        System.out.println(optInst4.orElse("Alternative String"));

        /** orElseGet can be used to return an alternative value from the provided supplier
         *  when the original value is empty */
        optInst5.orElseGet(() -> "Alternative String from Supplier");

        /** Throws exception provided by Supplier when original value is empty */
        optInst5.orElseThrow(() -> new RuntimeException("optInst5 is empty"));

        if(optInst1.isPresent()) {
            System.out.println("optInst1 value is present");
        } else System.out.println("optInst1 is empty");

        /** Applies consumer to the value if present, otherwise do nothing */
        optInst5.ifPresent(System.out::println);

        /** Returns the original value if it passes the filter, otherwise return empty optional */
        Optional<String> filtered = optInst5.filter(i -> i.startsWith("S"));

        /** Returns a mapped (modified) original optional value or empty value, if the original is empty */
        Optional<Integer> mapped = optInst5.map(String::length);

        /** flatMap is usually used instead of map, when the return type of Function is Optional */
        Optional<String> flatMapped = optInst5.flatMap(s -> Optional.of(s.toUpperCase()));

    }

    public void reductionOperations() {

        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        /** count, max, min and reduce can be used by Stream, IntStream, LongStream, DoubleStream */

        /** Returns the number of elements in a stream */
        long count = intStream.count();

        /** Returns Optional holding the minimum value of the stream */
        Optional<Integer> min = intStream.min(Comparator.naturalOrder());

        /** Returns Optional holding the maximum value of the stream */
        Optional<Integer> max = intStream.max(Integer::compare);

        /** reduce(BinaryOperator<T> accumulator) performs a reduction on the elements of the stream,
         *  using an associative accumulation function, and returns an Optional describing the reduced value */

        Optional<Integer> reduced = intStream.reduce(Integer::sum);

        Integer reducedInt = intStream.reduce(0, (i,j)->i+j);

        /** average and sum methods only work with primitive streams */
        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5);

        /** Returns an OptionalDouble describing the mean value of the elements in a primitive stream */
        OptionalDouble opAverage = intStream1.average();
        double average = opAverage.getAsDouble();

        int sum = intStream1.sum();

        /** If the input stream is empty, then the resulting Optional from a reduction operation is also empty */

    }

    public void sorting() {

        Stream<Integer> intStream = Stream.of(6, 1, 4, 9, 3, 5, 7, 2, 8);

        /** Sorts elements of stream by their natural ordering. Class of the elements used
         *  in this method must implement Comparable, otherwise ClassCastException is thrown */
        Stream<Integer> sorted = intStream.sorted();


        /** Sorts elements of a stream using a given comparator */
        sorted = intStream.sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        /** Shorter versions */
        sorted =intStream.sorted((i1,i2) -> i1.compareTo(i2));
        sorted =intStream.sorted(Integer::compareTo);

        /** Sorting is intermediate operation and is terminated only when a terminating operator is used */

        Stream<Integer> sortedStream = new ArrayList<>(Arrays.asList(5,3,9,1,3)).stream().sorted();
        sortedStream.forEachOrdered(System.out::println);

    }

    public void collections() {

        /**An ordinary reduction of stream elements using the reduce method can collect data,
         * but its performance might not be as good since a new instance of the result type
         * is created each time an element is handled.
         *
         * A mutable reduction operation accumulates input elements into a mutable result container
         * as it processes elements of the stream. Mutable reduction can be achieved with collect() method.
         */

        /** <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R,R> combiner) */

        /** The Collectors class provides a number of predefined static factory methods to create collectors */

        Stream<String> stream = Stream.of("A","B","B","A");

        List<String> list = stream.collect(Collectors.toList());
        Set<String> set = stream.collect(Collectors.toSet());

        LinkedList<String> linkedList = stream.collect(Collectors.toCollection(() -> new LinkedList<>()));

        Stream<String> testStream = Stream.of("str1","str2");              //keymapper       valuemapper
        Map<String, Integer> mapping = testStream.collect(Collectors.toMap(String::toString, String::length));
    }

    public void flatMap() {




    }

    class Test {

        int intValue;
        long longValue;
        double doubleValue;

        public Test(int intValue, long longValue, double doubleValue) {
            this.intValue = intValue;
            this.longValue = longValue;
            this.doubleValue = doubleValue;
        }

        public int getIntValue() {
            return intValue;
        }

        public long getLongValue() {
            return longValue;
        }

        public double getDoubleValue() {
            return doubleValue;
        }

    }

}
