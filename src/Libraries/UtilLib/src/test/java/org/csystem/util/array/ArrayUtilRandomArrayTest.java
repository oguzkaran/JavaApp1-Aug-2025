package org.csystem.util.array;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArrayUtilRandomArrayTest {
    private static final Random m_randomgenerator = new Random();
    private static final int COUNT = 1000;
    private static final int ORIGIN = 0;
    private static final int BOUND = 100;

    static IntStream testCallProvider()
    {
        return IntStream.generate(() -> m_randomgenerator.nextInt(5, 100)).limit(COUNT);
    }

    @ParameterizedTest
    @MethodSource("testCallProvider")
    @Order(1)
    void test_isCountSame(int count)
    {
        int [] a = ArrayUtil.randomArray(m_randomgenerator, count, ORIGIN, BOUND);
        assertEquals(count, a.length);
    }

    @Order(2)
    @Test
    void test_areAllMembersWithinRange()
    {
        int [] a = ArrayUtil.randomArray(m_randomgenerator, COUNT, ORIGIN, BOUND);

        for (var val : a)
            assertTrue(val >= ORIGIN && val < BOUND);
    }
}
