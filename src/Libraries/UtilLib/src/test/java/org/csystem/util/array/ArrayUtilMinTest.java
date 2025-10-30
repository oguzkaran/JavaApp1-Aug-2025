package org.csystem.util.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayUtilMinTest {
    @Test
    void givenArray_thenReturnsMin()
    {
        int [] a = {0, 3, 5, -2, -7, 12, 15, -12, 24};
        var expected = -12;

        assertEquals(expected, ArrayUtil.min(a));
    }
}
