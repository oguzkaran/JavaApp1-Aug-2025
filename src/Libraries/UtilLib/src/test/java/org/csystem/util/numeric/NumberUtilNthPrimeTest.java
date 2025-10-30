package org.csystem.util.numeric;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class NumberUtilNthPrimeTest {

    private static final String RESOURCE_FILE = "/nthprimetest.csv";

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE, numLinesToSkip = 1)
    void nthPrime(int input1, int input2, boolean expected)
    {
        assertEquals(expected, NumberUtil.nthPrime(input1) == input2);
    }

}
