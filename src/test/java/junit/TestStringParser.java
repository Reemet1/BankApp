package junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestStringParser {

    private String inputString;
    private String expectedResult;
    private StringParser stringParser;

    @Before
    public void initialize() {
        stringParser = new StringParser();
    }

    // Each parameter should be placed as an argument here
    // Every time runner triggers, it will pass the arguments
    // from parameters we defined in primeNumbers() method

    public TestStringParser(String inputString, String expectedResult) {
        this.inputString = inputString;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testUpperCase() {
        Assert.assertEquals(expectedResult, stringParser.upperCase(inputString));
    }

    @Parameterized.Parameters
    public static Collection strings() {
        return Arrays.asList(new Object[][] {
                {"hello","HELLO"}
        });
    }

}
