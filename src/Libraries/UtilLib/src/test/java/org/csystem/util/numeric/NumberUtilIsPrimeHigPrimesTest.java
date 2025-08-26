package org.csystem.util.numeric;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberUtilIsPrimeHigPrimesTest {
    @Disabled("It can take too much time in some computers")
    @ParameterizedTest
    @ValueSource(longs = {6584583408148485263L, 6245098347044246839L, 4434895834573449257L, 5697859706174583067L})
    void test(long val)
    {
        assertTrue(NumberUtil.isPrime(val));
    }
}
