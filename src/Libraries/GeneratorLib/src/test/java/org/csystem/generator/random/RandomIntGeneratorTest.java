package org.csystem.generator.random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomIntGeneratorTest {
    private int m_counter;
    private static boolean isBetween(int a, int origin, int bound)
    {
        return origin <= a && a < bound;
    }

    @Test
    public void iterate_whenCIncrementCounter_thenEqualCount()
    {
        var count = 10;
        var origin = 1;
        var bound = 100;
        var generator = new RandomIntGenerator(new Random(), count, origin, bound);

        generator.forEach(i -> ++m_counter);
        Assertions.assertEquals(count, m_counter);
    }

    @Test
    public void iterate_whenGenerateValues_thenAllInRange()
    {
        var count = 10;
        var origin = 1;
        var bound = 100;
        var generator = new RandomIntGenerator(new Random(), count, origin, bound);

        generator.forEach(val -> Assertions.assertTrue(isBetween(val, origin, bound)));
    }
}
