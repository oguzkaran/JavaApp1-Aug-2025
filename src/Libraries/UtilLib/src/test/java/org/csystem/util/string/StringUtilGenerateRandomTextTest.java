package org.csystem.util.string;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringUtilGenerateRandomTextTest {
    private static final Random m_randomGenerator = new Random();
    private static final int COUNT = 100_000;
    private static final String SOURCE_TEXT = "abcdef";

    static IntStream testCallProvider()
    {
        return IntStream.generate(() -> m_randomGenerator.nextInt(5, 15)).limit(COUNT);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/areallintest.csv", numLinesToSkip = 1)
    @Order(1)
    void test_areAllCharactersIn(String input1, String input2, boolean expected)
    {
        assertEquals(expected, StringUtil.areAllCharactersIn(input1, input2));
    }

    @Disabled("It can take too much time")
    @ParameterizedTest
    @MethodSource("testCallProvider")
    @Order(2)
    void test_randomText(int count)
    {
        String text = StringUtil.randomText(m_randomGenerator, count,  SOURCE_TEXT);

        assertEquals(count, text.length());
        assertTrue(StringUtil.areAllCharactersIn(text, SOURCE_TEXT));
    }
}
