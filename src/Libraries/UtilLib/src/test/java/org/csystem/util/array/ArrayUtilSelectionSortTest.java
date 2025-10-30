package org.csystem.util.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayUtilSelectionSortTest {
    @Test
    void givenArray_thenReturnsSorted()
    {
        int [] a = {1, 0, 3, 5, -4, 10};
        int [] expected = {-4, 0, 1, 3, 5, 10};

        ArrayUtil.selectionSort(a);

        assertArrayEquals(expected, a);
    }
}