package org.csystem.util.numeric;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilIsPrimeResourceTest {
    private static final String RESOURCE_FILE = "/numbers.csv";
    @Disabled("It can take too much time in some computers")
    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE, numLinesToSkip = 1)
    void testPrimes(long input, boolean expected)
    {
        assertEquals(expected, NumberUtil.isPrime(input));
    }
}
