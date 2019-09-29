package junit;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Annotations are like meta-tags that you can add to your code,
 * and apply them to methods or in class. These annotations in JUnit provide the
 * following information about test methods:
 * - which methods are going to run before and after test methods.
 * - which methods run before and after all the methods, and.
 * - which methods or classes will be ignored during the execution.
 */
//@Ignore - a whole class can be ignored
public class TestCalculator {

    Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Actions before test sessions");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Actions after test sessions");
    }

    @Before
    public void before() {
        calculator = new Calculator();
        System.out.println("Actions before test");
    }

    @After
    public void after() {
        System.out.println("Actions after test");
    }

    @Test
    public void testCalculator() {
        System.out.println("Testing calculator");
    }

    @Ignore
    @Test
    public void testIgnored() {
        System.out.println("This test is ignored");
    }

    // This test will run 4 times since we have 5 parameters defined
    @Test
    public void testAddition() {
        double a = 10;
        double b = 5;
        System.out.println("Adding " + a + " and " + b);
        assertEquals(15, calculator.add(a,b),15);
    }

    /**
     * Timeout can be set for testmethod (milliseconds)
     */
    @Test(timeout = 1)
    public void testPrintMessage() {
        assertEquals("Hello World","Hello World");
    }

    /**
     * Expected exception can be declared with exception = Exception.class
     */
    @Test(expected = NullPointerException.class)
    public  void testThrowingException() {
        String str = null;
        str.split("");
    }

    @Test
    public void testAssertions() {
        //test data
        String str1 = new String ("abc");
        String str2 = new String ("abc");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 5;
        int val2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray =  {"one", "two", "three"};

        //Check that two objects are equal
        assertEquals(str1, str2);

        //Check that a condition is true
        assertTrue (val1 < val2);

        //Check that a condition is false
        assertFalse(val1 > val2);

        //Check that an object isn't null
        assertNotNull(str1);

        //Check that an object is null
        assertNull(str3);

        //Check if two object references point to the same object
        assertSame(str4,str5);

        //Check if two object references not point to the same object
        assertNotSame(str1,str3);

        //Check whether two arrays are equal to each other.
        assertArrayEquals(expectedArray, resultArray);
    }

}
