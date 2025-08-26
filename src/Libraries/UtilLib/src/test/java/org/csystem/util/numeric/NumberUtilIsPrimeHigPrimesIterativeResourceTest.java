package org.csystem.util.numeric;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberUtilIsPrimeHigPrimesIterativeResourceTest {
    private static final String RESOURCE_FILE = "src/test/resources/primes.txt";
    @Disabled("It can take too much time in some computers")
    @ParameterizedTest
    @ValueSource(strings = RESOURCE_FILE)
    void testPrimes(String filePath) throws IOException
    {
        Files.lines(Path.of(filePath))
                .map(String::strip)
                .filter(s -> !s.isEmpty())
                .mapToLong(Long::parseLong)
                .forEach(n -> assertTrue(NumberUtil.isPrime(n)));
    }
}
