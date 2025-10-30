package org.csystem.util.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayUtilLongSumTest {
    @Test
    void givenArray_whenArray_thenReturnsSum()
    {
        long [] a = {1, 2, 3, 4, 5};
        var expected = 15;

        assertEquals(expected, ArrayUtil.sum(a));
    }
}
