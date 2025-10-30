package org.csystem.util.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixUtilTransposeTest {
    @Test
    void givenValues_whenTwoArray_thenReturnTrue()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}};
        int [][] t = {{1, 4}, {2, 5}, {3, 6}};

        assertArrayEquals(a,MatrixUtil.transpose(t));
        assertArrayEquals(t,MatrixUtil.transpose(a));

    }
}
