package junit;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite is used to bundle a few unit test cases and run them together.
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestCalculator.class,
        TestStringParser.class
})


public class JunitTestSuite {
}
