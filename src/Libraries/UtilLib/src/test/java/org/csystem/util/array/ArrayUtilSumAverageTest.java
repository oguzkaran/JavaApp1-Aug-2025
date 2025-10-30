package org.csystem.util.array;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArrayUtilSumAverageTest {
    @Test
    @Order(1)
    void givenArray_thenReturnsSum()
    {
        int [] a = {1, 3, 5, 7, 9};
        var expected = 25;

        assertEquals(expected, ArrayUtil.sum(a));
    }

    @Test
    @Order(2)
    void givenArray_thenReturnsAverage()
    {
        int [] a = {1, 3, 5, 7, 9};
        var expected = ArrayUtil.sum(a) / 5.;

        assertEquals(expected, ArrayUtil.average(a));
    }

}
