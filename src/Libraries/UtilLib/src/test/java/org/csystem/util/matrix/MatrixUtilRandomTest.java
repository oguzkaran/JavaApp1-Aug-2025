package org.csystem.util.matrix;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MatrixUtilRandomTest {
    private static final int COLUMN = 5;
    private static final int ROW = 5;
    private static final int ORIGIN = 1;
    private static final int BOUND = 5;
    private static final Random RN = new Random();


    @Test
    @Order(1)
    void givenValue_whenArray_thenReturnOriginBound()
    {
        int[][] array = MatrixUtil.randomMatrix(RN, COLUMN, ROW, ORIGIN, BOUND);

        assertEquals(COLUMN, array.length);
        assertEquals(ROW, array[1].length);
    }

    @Test
    @Order(3)
    void givenValue_whenArray_thenReturnRandom()
    {
        int[][] array = MatrixUtil.randomMatrix(RN, COLUMN, ROW, ORIGIN, BOUND);

        assertTrue( areNumbersAll(array, ORIGIN, BOUND));
    }

    @Test
    @Order(2)
    void givenValue_whenArray_thenReturnAreNumbersAll()
    {
        int [][] a = {{-1, 2, 3}, {4, 5, 6}};

        assertTrue(areNumbersAll(a,-1,7));
    }

    public static boolean areNumbersAll(int [][] a, int origin, int bound)
    {
        for (int[] ints : a)
            for (int anInt : ints)
                if (bound <= anInt && origin > anInt)
                    return false;
        return true;
    }
}
