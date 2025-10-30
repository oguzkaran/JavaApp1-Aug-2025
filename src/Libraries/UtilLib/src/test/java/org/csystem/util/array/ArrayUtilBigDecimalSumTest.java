package org.csystem.util.array;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayUtilBigDecimalSumTest {
    @Test
    void givenArray_whenArray_thenReturnsSum()
    {
        BigDecimal[] a = {new BigDecimal("0.1"), new BigDecimal("0.2"), new BigDecimal("0.3")};
        var expected = new BigDecimal("0.6");

        assertEquals(expected, ArrayUtil.sum(a));
    }

    @Test
    void givenArray_withPositiveValues_returnsCorrectSum()
    {
        BigDecimal[] a = {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)};
        var expected = BigDecimal.valueOf(6);

        assertEquals(expected, ArrayUtil.sum(a));
    }

    @Test
    void givenArray_withNegativeValues_returnsCorrectSum()
    {
        BigDecimal[] a = {BigDecimal.valueOf(-1), BigDecimal.valueOf(-2), BigDecimal.valueOf(-3)};
        var expected = BigDecimal.valueOf(-6);

        assertEquals(expected, ArrayUtil.sum(a));
    }

    @Test
    void givenArray_withMixedValues_returnsCorrectSum()
    {
        BigDecimal[] a = {BigDecimal.valueOf(5), BigDecimal.valueOf(-2), BigDecimal.valueOf(3)};
        var expected = BigDecimal.valueOf(6);

        assertEquals(expected, ArrayUtil.sum(a));
    }

    @Test
    void givenArray_withZeroValues_returnsZero()
    {
        BigDecimal[] a = {BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO};
        var expected = BigDecimal.ZERO;

        assertEquals(expected, ArrayUtil.sum(a));
    }

    @Test
    void givenArray_whenEmpty_returnsZero()
    {
        BigDecimal[] a = {};
        var expected = BigDecimal.ZERO;

        assertEquals(expected, ArrayUtil.sum(a));
    }

}
