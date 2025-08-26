package org.csystem.util.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilIsPangramTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/ispangramtest.csv", numLinesToSkip = 1)
    void test(String input1, String input2, boolean expected)
    {
        assertEquals(expected, StringUtil.isPangram(input1, input2));
    }
}
