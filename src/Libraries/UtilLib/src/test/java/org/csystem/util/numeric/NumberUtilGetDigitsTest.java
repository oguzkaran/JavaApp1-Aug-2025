package org.csystem.util.numeric;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class NumberUtilGetDigitsTest {

    private static final String RESOURCE_FILE = "/getdigits.csv";

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE, numLinesToSkip = 1)
    void getDigits(long val, String expectedDigits)
    {
        var digitsStr = expectedDigits.split(" ");
        var digits = new int[digitsStr.length];

        for (int i = 0; i < digits.length; i++)
            digits[i] = Integer.parseInt(digitsStr[i]);

        assertArrayEquals(digits, NumberUtil.getDigits(val));
    }
}
