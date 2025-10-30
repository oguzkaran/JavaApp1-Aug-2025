package org.csystem.util.array;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayUtilBigDecimalMaxTest {
    @Test
    void givenArray_whenPositiveValues_returnsCorrectMax() {
        BigDecimal[] a = {BigDecimal.valueOf(5), BigDecimal.valueOf(12), BigDecimal.valueOf(8)};
        var expected = BigDecimal.valueOf(12);

        assertEquals(expected, ArrayUtil.max(a));
    }

    @Test
    void givenArray_whenNegativeValues_returnsCorrectMax() {
        BigDecimal[] a = {BigDecimal.valueOf(-5), BigDecimal.valueOf(-2), BigDecimal.valueOf(-8)};
        var expected = BigDecimal.valueOf(-2);

        assertEquals(expected, ArrayUtil.max(a));
    }

    @Test
    void givenArray_whenMixedValues_returnsCorrectMax() {
        BigDecimal[] a = {BigDecimal.valueOf(5), BigDecimal.valueOf(-2), BigDecimal.valueOf(3)};
        var expected = BigDecimal.valueOf(5);

        assertEquals(expected, ArrayUtil.max(a));
    }

    @Test
    void givenArray_whenZeroValues_returnsCorrectMax() {
        BigDecimal[] a = {BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO};
        var expected = BigDecimal.ZERO;

        assertEquals(expected, ArrayUtil.max(a));
    }

    @Test
    void givenArray_whenMixedWithZero_returnsCorrectMax() {
        BigDecimal[] a = {BigDecimal.valueOf(5), BigDecimal.valueOf(0), BigDecimal.valueOf(-3)};
        var expected = BigDecimal.valueOf(5);

        assertEquals(expected, ArrayUtil.max(a));
    }

    @Test
    void givenArray_whenSingleElement_returnsThatElement() {
        BigDecimal[] a = {BigDecimal.valueOf(100)};
        var expected = BigDecimal.valueOf(100);

        assertEquals(expected, ArrayUtil.max(a));
    }

    @Test
    void givenArray_whenEmpty_throwsIllegalArgumentException() {
        BigDecimal[] a = {};
        assertThrows(IllegalArgumentException.class, () -> ArrayUtil.max(a));
    }

    @Test
    void givenArrayAndStartIndex_whenSubArrayHasMax_returnsCorrectMax() {
        BigDecimal[] a = {BigDecimal.valueOf(10), BigDecimal.valueOf(2), BigDecimal.valueOf(18)};
        var expected = BigDecimal.valueOf(18);

        assertEquals(expected, ArrayUtil.max(a, 1));
    }

    @Test
    void givenArrayAndStartIndex_whenStartIndexIsZero_returnsCorrectMax() {
        BigDecimal[] a = {BigDecimal.valueOf(10), BigDecimal.valueOf(2), BigDecimal.valueOf(8)};
        var expected = BigDecimal.valueOf(10);

        assertEquals(expected, ArrayUtil.max(a, 0));
    }

    @Test
    void givenArrayAndStartIndex_whenStartIndexIsAtEnd_returnsCorrectMax() {
        BigDecimal[] a = {BigDecimal.valueOf(10), BigDecimal.valueOf(2), BigDecimal.valueOf(8)};
        var expected = BigDecimal.valueOf(8);

        assertEquals(expected, ArrayUtil.max(a, 2));
    }
}