package org.csystem.util.array;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayUtilBigDecimalMultiplyByTest {

    @Test
    void givenArray_whenPositiveValue_thenMultipliesCorrectly() {
        BigDecimal[] a = {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)};
        BigDecimal value = BigDecimal.valueOf(2);
        BigDecimal[] expected = {BigDecimal.valueOf(2), BigDecimal.valueOf(4), BigDecimal.valueOf(6)};

        ArrayUtil.multiplyBy(a, value);
        assertArrayEquals(expected, a);
    }

    @Test
    void givenArray_whenNegativeValue_thenMultipliesCorrectly() {
        BigDecimal[] a = {BigDecimal.valueOf(5), BigDecimal.valueOf(-10)};
        BigDecimal value = BigDecimal.valueOf(-2);
        BigDecimal[] expected = {BigDecimal.valueOf(-10), BigDecimal.valueOf(20)};

        ArrayUtil.multiplyBy(a, value);
        assertArrayEquals(expected, a);
    }

    @Test
    void givenArray_whenMultiplyByZero_thenAllElementsBecomeZero() {
        BigDecimal[] a = {BigDecimal.valueOf(100), BigDecimal.valueOf(-50), BigDecimal.valueOf(25)};
        BigDecimal value = BigDecimal.ZERO;
        BigDecimal[] expected = {BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO};

        ArrayUtil.multiplyBy(a, value);
        assertArrayEquals(expected, a);
    }

    @Test
    void givenEmptyArray_thenMethodDoesNotThrowException() {
        BigDecimal[] a = {};
        BigDecimal value = BigDecimal.valueOf(5);
        BigDecimal[] expected = {};

        ArrayUtil.multiplyBy(a, value);
        assertArrayEquals(expected, a);
    }

    @Test
    void given2DArray_whenPositiveValue_thenMultipliesCorrectly() {
        BigDecimal[][] a = {
                {BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(3), BigDecimal.valueOf(4)}
        };
        BigDecimal value = BigDecimal.valueOf(10);
        BigDecimal[][] expected = {
                {BigDecimal.valueOf(10), BigDecimal.valueOf(20)},
                {BigDecimal.valueOf(30), BigDecimal.valueOf(40)}
        };

        ArrayUtil.multiplyBy(a, value);
        assertArrayEquals(expected[0], a[0]);
        assertArrayEquals(expected[1], a[1]);
    }

    @Test
    void given2DArray_whenRaggedArray_thenMultipliesCorrectly() {
        BigDecimal[][] a = {
                {BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(3)}
        };
        BigDecimal value = BigDecimal.valueOf(5);
        BigDecimal[][] expected = {
                {BigDecimal.valueOf(5)},
                {BigDecimal.valueOf(10), BigDecimal.valueOf(15)}
        };

        ArrayUtil.multiplyBy(a, value);
        assertArrayEquals(expected[0], a[0]);
        assertArrayEquals(expected[1], a[1]);
    }

    @Test
    void given2DArray_whenMultiplyByZero_thenAllElementsBecomeZero() {
        BigDecimal[][] a = {
                {BigDecimal.valueOf(10), BigDecimal.valueOf(-5)},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(8)}
        };
        BigDecimal value = BigDecimal.ZERO;
        BigDecimal[][] expected = {
                {BigDecimal.ZERO, BigDecimal.ZERO},
                {BigDecimal.ZERO, BigDecimal.ZERO}
        };

        ArrayUtil.multiplyBy(a, value);
        assertArrayEquals(expected[0], a[0]);
        assertArrayEquals(expected[1], a[1]);
    }
}