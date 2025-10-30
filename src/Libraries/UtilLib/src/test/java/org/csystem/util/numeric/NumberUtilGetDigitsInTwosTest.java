package org.csystem.util.numeric;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NumberUtilGetDigitsInTwosTest {

    private static final String RESOURCE_FILE = "/getdigitsintwos.csv";

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE, numLinesToSkip = 1)
    void getDigits(long val, String expectedDigits)
    {
        var digitsStr = expectedDigits.split(" ");
        var digits = new int[digitsStr.length];

        for (int i = 0; i < digits.length; i++)
            digits[i] = Integer.parseInt(digitsStr[i]);

        assertArrayEquals(digits, NumberUtil.getDigitsInTwos(val));
    }
}
