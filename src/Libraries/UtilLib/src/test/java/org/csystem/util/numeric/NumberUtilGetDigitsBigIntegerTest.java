package org.csystem.util.numeric;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NumberUtilGetDigitsBigIntegerTest {
    @Test
    void givenValue_whenBigInteger_thenReturnsDigits()
    {
        var input1 = BigInteger.valueOf(123);
        var input2 = BigInteger.valueOf(1_234);
        var input3 = BigInteger.valueOf(123_567);
        var input4 = BigInteger.valueOf(1_234_567);
        var input5 = BigInteger.valueOf(-1_234_567);

        assertArrayEquals(new int[]{1, 2, 3}, NumberUtil.getDigits(input1));
        assertArrayEquals(new int[]{1, 2, 3, 4}, NumberUtil.getDigits(input2));
        assertArrayEquals(new int[]{1, 2, 3, 5, 6, 7}, NumberUtil.getDigits(input3));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, NumberUtil.getDigits(input4));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, NumberUtil.getDigits(input5));
    }

    @Test
    void givenValue_whenBigInteger_thenReturnsDigitsInTwos()
    {
        var input1 = BigInteger.valueOf(123);
        var input2 = BigInteger.valueOf(1_234);
        var input3 = BigInteger.valueOf(123_567);
        var input4 = BigInteger.valueOf(1_234_567);
        var input5 = BigInteger.valueOf(-1_234_567);

        assertArrayEquals(new int[]{1, 23}, NumberUtil.getDigitsInTwos(input1));
        assertArrayEquals(new int[]{12, 34}, NumberUtil.getDigitsInTwos(input2));
        assertArrayEquals(new int[]{12, 35, 67}, NumberUtil.getDigitsInTwos(input3));
        assertArrayEquals(new int[]{1, 23, 45, 67}, NumberUtil.getDigitsInTwos(input4));
        assertArrayEquals(new int[]{1, 23, 45, 67}, NumberUtil.getDigitsInTwos(input5));
    }

    @Test
    void givenValue_whenBigInteger_thenReturnsDigitsInThrees()
    {
        var input1 = BigInteger.valueOf(123);
        var input2 = BigInteger.valueOf(1_234);
        var input3 = BigInteger.valueOf(123_567);
        var input4 = BigInteger.valueOf(1_234_567);
        var input5 = BigInteger.valueOf(-1_234_567);

        assertArrayEquals(new int[]{123}, NumberUtil.getDigitsInThrees(input1));
        assertArrayEquals(new int[]{1, 234}, NumberUtil.getDigitsInThrees(input2));
        assertArrayEquals(new int[]{123, 567}, NumberUtil.getDigitsInThrees(input3));
        assertArrayEquals(new int[]{1, 234, 567}, NumberUtil.getDigitsInThrees(input4));
        assertArrayEquals(new int[]{1, 234, 567}, NumberUtil.getDigitsInThrees(input5));
    }
}
