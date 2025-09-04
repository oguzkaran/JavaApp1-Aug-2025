package org.csystem.util.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayUtilMergeTest {
    @Test
    void givenValues_whenTwoArrays_thenReturnsMergerArray()
    {
        int [] a = {1, 2, 3, 4};
        int [] b = {5, 6, 7, 8, 9};
        int [] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertArrayEquals(expected, ArrayUtil.merge(a, b));
    }

    @Test
    void givenValues_whenArrayAndVarargs_thenReturnsMergerArray()
    {
        int [] a = {1, 2, 3, 4};
        int [] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertArrayEquals(expected, ArrayUtil.merge(a, 5, 6, 7, 8, 9));
    }
}
