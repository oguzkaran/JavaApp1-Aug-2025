package org.csystem.util.array;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayUtilBubbleSortBigDecimalTest {
    @Test
    void givenArray_thenReturnsSortedAscending()
    {
        BigDecimal[] a = {BigDecimal.valueOf(1), BigDecimal.valueOf(0), BigDecimal.valueOf(3),
                BigDecimal.valueOf(5), BigDecimal.valueOf(-4), BigDecimal.valueOf(10)};
        BigDecimal[] expected = {BigDecimal.valueOf(-4), BigDecimal.valueOf(0), BigDecimal.valueOf(1),
                BigDecimal.valueOf(3), BigDecimal.valueOf(5), BigDecimal.valueOf(10)};

        ArrayUtil.bubbleSort(a);

        assertArrayEquals(expected, a);
    }
}