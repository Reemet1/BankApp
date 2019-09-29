package com.prometheus.learning.lambdas;

public class FunctionalInterfaces {

    public void functionalInterfaces() {

        /** Regular way of using interfaces */
        TestPredicate<Integer> predicate = new TestPredicate<Integer>(){
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };

        TestProducer<String> producer = new TestProducer<String>() {
            @Override
            public String produce() {
                return "String";
            }
        };

        TestConsumer<String> consumer = new TestConsumer<String>() {
            @Override
            public void consume(String param) {
                System.out.println(param);
            }
        };

        TestFunction<Integer> function = new TestFunction<Integer>() {
            @Override
            public Integer map(Integer param) {
                return param*2;
            }
        };

        predicate.test(1);
        producer.produce();
        consumer.consume("String");
        function.map(1);



        /** Doing the same with lambdas */

        predicate = i -> i > 0;
        producer = () -> "String";
        consumer = System.out::println;
        function = a -> 2*a;

        predicate.test(1);
        producer.produce();
        consumer.consume("String");
        function.map(1);



    }

    interface TestPredicate<T> {
        boolean test(T param);
    }

    interface TestProducer<T> {
        T produce();
    }

    interface TestConsumer<T> {
        void consume(T param);
    }

    interface TestFunction<T> {
        T map(T param);
    }

}
