package com.prometheus.learning.lang;

import learning.lang.interfaces.AutoCloseableImpl;

import java.io.IOException;

/**
 * Exception is an abnormal event that disrupts the program flow.
 * Exceptions must be handled in order for the program to not terminate abnormally.
 * Two ways of dealing with threads in program flow are to prevent exceptions by
 * verifying arguments before operations, or catching and dealing with exceptions.
 */

public class Exceptions {

    static {
        /** All exceptions (checked and unchecked) must be caught in static initializer block */
        //throw new RuntimeException();
    }

    /**
     * There are 3 types of exceptions:
     * 1) Checked exceptions a.k.a compile time exceptions, that must handler before compiling.
     * 2) Unchecked exceptions a.k.a runtime exceptions, that can occur at the time of execution.
     * 3) Errors, which the programmer can do nothing about during execution of a program.
     */
    public void exceptionTypes() {
        /**
         * All exceptions are subclasses of Throwable. Only throwable objects can be
         * used with throw and throws keywords and in catch block header.
         * The direct subclasses of Throwable are RuntimeException and IOException.
         */

        /** All exceptions that are subclasses of IOException throw checked exceptions.
         *  Usually classes and methods dealing with input/output streams and files throw these exceptions. */
        //FileInputStream inputStream = new FileInputStream(new File("")); //Checked exception, must be handled.

        int[] array = new int[1];
        //int a = array[2]; //throws unchecked ArrayIndexOuOfBounds, that is not forced to be handled

        /** Errors are usually caused by memory threads or internal JVM errors. */

    }

    public void cathingExceptions() {


        /** The code that is checked for exceptions are surrounded by try-block.
         *  Try block must always be accompanied with catch or finally block.
         *  If an exception is thrown in try block, the remainder of the block
         *  will be skipped and program jumps straight into catch block.
         *  Unlike if-statement and loops, curly brackets are
         *  mandatory for try-catch blocks
         */
        try {
            int[] array = new int[1];
            int a = array[2];
            /** Catch block states the types of Exceptions to be captured and dealt with.
             *  When an exception occurs, its type is compared with exception types in
             *  catch blocks */
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            /** Catch block header can contain many exceptions separated by |.
             * When a corresponding type (exact class or subclass type) is found,
             * the execution continues in that catch block.
             * The exceptions to be catched should normally be as specific as possible.*/
            /** Exceptions in a single catch must be unrelated (not superclass-subclass hierarchy) */
            /** Exception parameter e in multi exception catch is implicitly final */
            //When an ArrayIndexOutOfBound exception occurs in the try-block,
            //the execution of a program continues in this block.
        } catch (Exception e) { //checked when exception wasn't caught in the previous catch.
            //exceptions to be caught here cannot be more narrow than in previous catch.
            /** Exception parameter in a single exception catch can be changed */
            e = new Exception();
        }
        /** Broader exceptions cannot be catched after narrower exceptions, because
         * the broader catch block will never be reached.
         */
        /*catch(RuntimeException e) {

        }*/finally {
            /** Finally block is executed no matter if exception occurred in the try-block or not.
             *  It is even executed when return is used in try or catch block, and it is even
             *  executed when in loop and continue or break is called. Only System.exit() skips finally.
             *  The return value in finally block overrides return values in all other blocks.
             *  Finally block is executed before leaving the try or catch block.
             *  Finally block is a good place where to close all constructed streams in the try block.
             */

            /** When exceptions are thrown in a catch block, it will be thrown
             *  after the finally block has been executed */

            /**
             * array is not visible to this block since it was created in try block.
             * If access to array is needed, it has to be created outside of the try block.
             * array would also not be visible if it was created in try with resources header.
             */
            //int a = array[0];
        }

        /** Checked exceptions cannot be catched if they are not thrown in try block */
        //try {} catch (IOException e) {}

        /** Broader exception also cannot be infront of subclass exception in catch block
         * with multiple exceptions */
        //try {} catch (RuntimeException | NullPointerException e); //invalid, RuntimeException is broader

        /** IOException cannot be catched if it is not thrown in try-block, but Exception can be catched */
        //try {} catch (IOException e) {}
        try {} catch (Exception e) {}
    }

    public void myMethod() throws IOException {
    }

    public void throwingExceptions() {

        try {
            throw new Throwable();
        } catch (Throwable e) {

        }

        /**
         * Placing a method that may throw exceptions in try-block.
         */
        try {
            throwsException();
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Handling NullPointerException thrown by throwsException()");
        }
        //The flow of the method continues after the catch block is executed.

        /** Exceptions can be invoked explicitly by throw keyword. */
        throw new NullPointerException();

    }

    public void throwsException() throws NullPointerException, ArrayIndexOutOfBoundsException {
        /**
         * If NullPointerException or ArrayIndexOutOfBoundsException occurs in this method
         * and the exceptional code is not in try block, the execution of the method
         * is stopped and the exception is thrown out to the method that was invoking
         * the current method, and the exception must be handled there, or thrown
         * to its invoking method again. When this happens, the exception is said
         * to 'propagate up the call stack' until it is caught.
         *
         * An exception can be thrown up the method chain until it reached
         * the main method, after which the program will be terminated.
         */
        throw new ArrayIndexOutOfBoundsException();

        //System.out.println("String"); //Unreachable statement
    }

    public void creatingExceptions() {

        /** Custom exception classes can be defined */

        /** To create unchecked exception, the class has to extend RuntimeException or any of its sublass. */
        class CustomUncheckedException extends RuntimeException {

            public CustomUncheckedException(String message) {
                System.out.println(message);
            }

        }

        try {
            throw new CustomUncheckedException("This is a custom unchecked exception");
        } catch (CustomUncheckedException e) {
            System.out.println("Handling custom unchecked exception");
        }

        /** To create checked exception, the class has to extend IOException or Exception classes. */
        class CustomCheckedException extends Exception {

            public CustomCheckedException(String message) {
                System.out.println(message);
            }
        }

        /** Has to be handled or thrown to invoking method */
        //throw new CustomCheckedException("Custom checked exception");
    }

    public void exceptionMethods() {

        try {
            throw new ArrayIndexOutOfBoundsException("IndexOutOfBoundsMessage");
        } catch (ArrayIndexOutOfBoundsException e) {
            /** The message given to this exceptions' constructor  */
            String message = e.getMessage();

            /** Cause of an exception may be another exception thrown at lower levels */
            e.initCause(new IndexOutOfBoundsException());
            e.getCause();

            /** Prints the strackTrace into standard err stream. The strackTrace can be
             *  written to other destination if specified in the argument. */
            e.printStackTrace();

            /** Returns an array of StrackTraceElement objects, which
             *  describe the classes, methods and lines where the exception occurred,
             *  in the order in which they occurred.
             *  Each element represents a single stack frame.
             *  All stack frames except for the one at the top of the stack represent a method invocation.*/
            StackTraceElement[] stackTrace = e.getStackTrace();

            /** StrackTraceElement contains the file name, class name, method name and line nr
             * where the exception occurred */
            StackTraceElement stackTraceElement = stackTrace[0];
            System.out.println("The exception was thrown in " +
                    stackTraceElement.getFileName() + " file, in " +
                    stackTraceElement.getClassName() + " class, in " +
                    stackTraceElement.getMethodName() + " method and in " +
                    stackTraceElement.getLineNumber() + " line.");

            /** Java program puts methods on a stack, the method currently being executed is at
             *  the top of the stack. If the method is exited, it will be removed from
             *  the top of the stack and the method that becomes next on the stack
             *  is executed.
             */

        }


    }

    public void tryWithResources() throws Exception{

        /**
         * A stream of test can be defined in the header of try-block,
         * but it has to implement AutoCloseable interface. The stream or
         * resource will be closed automatically (in reverse order that they were declared)
         * after the try block is executed, without the need of finally block.
         */
        try (AutoCloseableImpl autoCloseable1 = new AutoCloseableImpl(); AutoCloseableImpl autoCloseable2 = new AutoCloseableImpl()) {
            //actions with autoClosable
        }
        /** A try-with-resources does not have to be followed by catch or finally block */

        AutoCloseableImpl autoCloseable1;
        /** Compilation fails, since resources must be declared in try */
        /*try (autoCloseable = new AutoCloseableImpl()) {
            //actions with autoClosable
        } catch (Exception e) {} */

        /** When exceptions are thrown in both closing the resources and in try block,
         *  the exceptions resulting in closing resources will be suppressed
         */
    }

    public int nestedTryBlocks() {


        try {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {

            } finally {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {

        }

        /** In this case, value 0 is returned */
        try {
            return 1/0;
        } catch (NumberFormatException e) {
            return 1;
        } finally {
            return 0;
        }


    }

    /** Method can throws Error (and any subclass of Error) and can return a Throwable object */
    public Exception returningException() throws Error {
        return new Exception();
    }

}
