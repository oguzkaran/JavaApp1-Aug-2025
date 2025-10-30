package org.csystem.util.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixUtilSubtractTest {
    @Test
    void givenValues_whenArrays_thenReturnSubtractArray()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}};
        int [][] b = {{7, 8, 9}, {5, 8, 9}};
        int [][] expected = {{-6, -6, -6}, {-1, -3, -3}};

        assertArrayEquals(expected, MatrixUtil.subtract(a, b));
    }
}
