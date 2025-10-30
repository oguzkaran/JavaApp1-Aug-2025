package org.csystem.util.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayUtilPartitionTest {
    @Test
    void givenThresholdValue_thenReturnPartitionIndex()
    {
        int [] a = {10, 3, 4, 5, 2, 1, 7, 9, 8, 6};
        var threshold = 6;
        var expected = 5;

        assertEquals(expected, ArrayUtil.partition(a, threshold));
    }
}
