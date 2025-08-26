package org.csystem.util.numeric;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberUtilIsPrimeEdgeCasesTest {
    @ParameterizedTest
    @ValueSource(longs = {-1, 1, 0})
    void testNotPrimes(long val)
    {
        assertFalse(NumberUtil.isPrime(val));
    }

    @Test
    void givenValue_whenUniqueEvenPrime_thenTrue()
    {
        long input = 2;

        assertTrue(NumberUtil.isPrime(input));
    }
}
