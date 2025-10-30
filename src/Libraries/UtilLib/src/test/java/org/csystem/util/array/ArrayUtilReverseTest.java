package org.csystem.util.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayUtilReverseTest {
    @Test
    void givenIntArray_thenReturnsReverse()
    {
        int [] a = {1, 2, 3, 4, 5};
        int [] expected = {5, 4, 3, 2, 1};

        ArrayUtil.reverse(a);

        assertArrayEquals(expected, a);
    }

    @Test
    void givenCharArray_thenReturnsReverse()
    {
        char [] a = {'e', 'd', 'i', 'p'};
        char [] expected = {'p', 'i', 'd', 'e'};

        ArrayUtil.reverse(a);

        assertArrayEquals(expected, a);
    }
}
