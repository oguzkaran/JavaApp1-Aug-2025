package org.csystem.util.numeric;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class NumberUtilNumToStrENTest {

    private static final String RESOURCE_FILE = "/numtostren.csv";

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE, numLinesToSkip = 1)
    void numToStrEn(int input1, String input2, boolean expected)
    {
        assertEquals(expected, NumberUtil.numToStrEN(input1).equals(input2));
    }
}
