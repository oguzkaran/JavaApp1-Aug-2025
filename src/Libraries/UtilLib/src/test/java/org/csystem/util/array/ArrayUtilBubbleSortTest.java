package org.csystem.util.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayUtilBubbleSortTest {
    @Test
    void givenArray_thenReturnsSorted()
    {
        int [] a = {1, 0, 3, 5, -4, 10};
        int [] expected = {-4, 0, 1, 3, 5, 10};

        ArrayUtil.bubbleSort(a);

        assertArrayEquals(expected, a);
    }
}
