package org.csystem.util.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class MatrixUtilMultiplyTest {
    @Test
    void givenValue_whenArray_thenReturnMultiply()
    {
        int [][] a = {{1, 0, 1}, {2, 1, 1}, {0, 1, 1}, {1, 1, 2}};
        int [][] b = {{1, 2, 1}, {2, 3, 1}, {4, 2, 2}};
        int [][] expected = {{5, 4, 3}, {8, 9, 5}, {6, 5, 3}, {11, 9, 6}};

        assertArrayEquals(expected, MatrixUtil.multiply(a, b));
    }

    @Test
    void givenValue_whenArray_thenReturnMultiplyBy()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}};
        int value = 2;
        int [][] expected = {{2, 4, 6}, {8, 10, 12}};

        MatrixUtil.multiplyBy(a, value);
        assertArrayEquals(expected, a);
    }
}
