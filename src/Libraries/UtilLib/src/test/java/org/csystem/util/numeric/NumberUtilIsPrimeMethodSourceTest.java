package org.csystem.util.numeric;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilIsPrimeMethodSourceTest {
    private static final String RESOURCE_FILE = "src/test/resources/numbers.csv";

    static Stream<Arguments> numberProvider() throws IOException
    {
        return Files.lines(Path.of(RESOURCE_FILE))
                .skip(1)
                .map(String::strip)
                .map(s -> s.split("[,]"))
                .map(str -> Arguments.of(Long.parseLong(str[0]), Boolean.parseBoolean(str[1])));
    }

    @Disabled("It can take too much time in some computers")
    @ParameterizedTest
    @MethodSource("numberProvider")
    void testPrimes(long input, boolean expected)
    {
        assertEquals(expected, NumberUtil.isPrime(input));
    }
}
