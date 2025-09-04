package org.csystem.util.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayUtilMaxTest {
    @Test
    void givenValues_whenArray_thenReturnsMax()
    {
        int [] a = {3, -4, 9, 7, 2, 8, 3};
        var expected = 9;

        assertEquals(expected, ArrayUtil.max(a));
    }

    @Test
    void givenValues_whenVarargs_thenReturnsMax()
    {
        var expected = 9;

        assertEquals(expected, ArrayUtil.max(3, -4, 9, 7, 2, 8, 3));
    }
}
