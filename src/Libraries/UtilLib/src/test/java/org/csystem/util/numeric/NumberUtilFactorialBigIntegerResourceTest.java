package org.csystem.util.numeric;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilFactorialBigIntegerResourceTest {
    private static final String RESOURCE_FILE = "/factorialTest.csv";
    @Disabled("It can take too much time in some computers")
    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE, numLinesToSkip = 1)
    void testFactorials(String input, String expected)
    {
        assertEquals(new BigInteger(expected), NumberUtil.factorial(new BigInteger(input)));
    }
}
