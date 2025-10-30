package org.csystem.util.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayUtilHistogramDataTest {
    @Test
    void givenArray_thenReturnMemberCountsArray()
    {
        int [] a = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        int [] expected = {3, 3, 3, 3};

        assertArrayEquals(expected, ArrayUtil.histogramData(a, 3));

    }
}
