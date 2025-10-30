package org.csystem.util.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixUtilSumTest {
    @Test
    void givenValue_whenMatrix_thenReturnSumDiagnol()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int expected = 15;

        assertEquals(expected, MatrixUtil.sumDiagonal(a));
    }

    @Test
    void givenValue_whenMatrix_thenReturnSum()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int expected = 45;

        assertEquals(expected, MatrixUtil.sum(a));
    }
}
