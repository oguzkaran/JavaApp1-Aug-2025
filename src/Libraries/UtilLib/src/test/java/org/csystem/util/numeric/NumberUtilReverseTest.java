package org.csystem.util.numeric;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class NumberUtilReverseTest {

    private static final String RESOURCE_FILE = "/reversetest.csv";

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE, numLinesToSkip = 1)
    void reverse(int input1, int input2, boolean expected)
    {
        assertEquals(expected, NumberUtil.reverse(input1) == input2);
    }
}
