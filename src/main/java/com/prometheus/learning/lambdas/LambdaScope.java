package com.prometheus.learning.lambdas;

public class LambdaScope {

    public void lambdaScope() {

        TestClass testObj = new TestClass();
        testObj.doSomething();

    }

    public String doStringStuff(UpperConcat uc, String str1, String str2) {
        return uc.upperConcat(str1,str2);
    }

    interface UpperConcat {

        public String upperConcat(String str1, String str2);

    }


    class TestClass {

        public String doSomething() {

            int i = 0;
            i++;

            System.out.println("TestClass class's name is " + getClass().getSimpleName());

            /** Anonymous class's name is "" (empty string) */
            String str = doStringStuff(new UpperConcat() {
                @Override
                public String upperConcat(String str1, String str2) {
                    /** Variable i needs to be final to be used in an anonymous inner class,
                     *  because it doesn't belong to inner class's instance fields */
                    //System.out.println("i = " + i);
                    //i++;
                    System.out.println("The anonymous class's name is " + getClass().getSimpleName());
                    return str1.toUpperCase() + str2.toUpperCase();
                }
            }, "String1", "String2");

            UpperConcat uc = (s1, s2) -> {
                /** Suprisingly, this lambda class's name is TestClass. This means
                 *  that this lambda isn't a class. Lambda is treated like a nested
                 *  block of code and its scope is that of this nested block */
                System.out.println("Lambda expression class's name is " + getClass().getSimpleName());

                /** Same for i in lamda expression, the i must be effectively final, which means
                 * it has to be declared final or be not changed in lambda */
                //i++;

                String result = s1.toUpperCase() + s2.toUpperCase();
                return result;
            };

            /** i can be modifier in block */
            {
                i++;
                System.out.println(i);
            }

            return doStringStuff(uc, "String1", "String2");

        }
    }

}
