package org.csystem.util.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class MatrixUtilAddTest {
    @Test
    void givenValues_whenMatrix_thenReturnAdd()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}};
        int [][] b = {{7, 8, 9}, {5, 8, 9}};
        int [][] expected = {{8, 10, 12}, {9, 13, 15}};

        assertArrayEquals(expected, MatrixUtil.add(a, b));
    }
}
