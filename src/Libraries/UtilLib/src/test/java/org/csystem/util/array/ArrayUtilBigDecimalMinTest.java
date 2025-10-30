package org.csystem.util.array;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayUtilBigDecimalMinTest {
    @Test
    void givenArray_whenPositiveValues_returnsCorrectMin() {
        BigDecimal[] a = {BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.valueOf(8)};
        var expected = BigDecimal.valueOf(2);

        assertEquals(expected, ArrayUtil.min(a));
    }

    @Test
    void givenArray_whenNegativeValues_returnsCorrectMin() {
        BigDecimal[] a = {BigDecimal.valueOf(-5), BigDecimal.valueOf(-2), BigDecimal.valueOf(-8)};
        var expected = BigDecimal.valueOf(-8);

        assertEquals(expected, ArrayUtil.min(a));
    }

    @Test
    void givenArray_whenMixedValues_returnsCorrectMin() {
        BigDecimal[] a = {BigDecimal.valueOf(5), BigDecimal.valueOf(-2), BigDecimal.valueOf(3)};
        var expected = BigDecimal.valueOf(-2);

        assertEquals(expected, ArrayUtil.min(a));
    }

    @Test
    void givenArray_whenZeroValues_returnsCorrectMin() {
        BigDecimal[] a = {BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO};
        var expected = BigDecimal.ZERO;

        assertEquals(expected, ArrayUtil.min(a));
    }

    @Test
    void givenArray_whenMixedWithZero_returnsCorrectMin() {
        BigDecimal[] a = {BigDecimal.valueOf(5), BigDecimal.valueOf(0), BigDecimal.valueOf(-3)};
        var expected = BigDecimal.valueOf(-3);

        assertEquals(expected, ArrayUtil.min(a));
    }

    @Test
    void givenArray_whenSingleElement_returnsThatElement() {
        BigDecimal[] a = {BigDecimal.valueOf(10)};
        var expected = BigDecimal.valueOf(10);

        assertEquals(expected, ArrayUtil.min(a));
    }

    @Test
    void givenArray_whenEmpty_throwsIllegalArgumentException() {
        BigDecimal[] a = {};
        assertThrows(IllegalArgumentException.class, () -> ArrayUtil.min(a));
    }

    @Test
    void givenArrayAndStartIndex_whenSubArrayHasMin_returnsCorrectMin() {
        BigDecimal[] a = {BigDecimal.valueOf(10), BigDecimal.valueOf(2), BigDecimal.valueOf(8)};
        var expected = BigDecimal.valueOf(2);

        assertEquals(expected, ArrayUtil.min(a, 1));
    }

    @Test
    void givenArrayAndStartIndex_whenStartIndexIsZero_returnsCorrectMin() {
        BigDecimal[] a = {BigDecimal.valueOf(10), BigDecimal.valueOf(2), BigDecimal.valueOf(8)};
        var expected = BigDecimal.valueOf(2);

        assertEquals(expected, ArrayUtil.min(a, 0));
    }

    @Test
    void givenArrayAndStartIndex_whenStartIndexIsAtEnd_returnsCorrectMin() {
        BigDecimal[] a = {BigDecimal.valueOf(10), BigDecimal.valueOf(2), BigDecimal.valueOf(8)};
        var expected = BigDecimal.valueOf(8);

        assertEquals(expected, ArrayUtil.min(a, 2));
    }
}