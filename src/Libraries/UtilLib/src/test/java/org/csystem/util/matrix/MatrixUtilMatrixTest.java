package org.csystem.util.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixUtilMatrixTest {
    @Test
    void givenValue_whenArray_thenReturnIsMatrix()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 1, 2}};
        int [][] b = {{1, 2, 5, 6, 6}, {4, 5}, {7, 8, 9}, {0, 1, 2, 6}};

        assertEquals(true, MatrixUtil.isMatrix(a));
        assertEquals(false, MatrixUtil.isMatrix(b));
    }
}
