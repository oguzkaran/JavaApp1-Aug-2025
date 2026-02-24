package org.csystem.generator.random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomIntGeneratorTest {
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
        int counter = 0;

        for (var ignore : generator)
            ++counter;

        Assertions.assertEquals(count, counter);
    }

    @Test
    public void iterate_whenGenerateValues_thenAllInRange()
    {
        var count = 10;
        var origin = 1;
        var bound = 100;
        var generator = new RandomIntGenerator(new Random(), count, origin, bound);

        for (var val : generator)
            Assertions.assertTrue(isBetween(val, origin, bound));
    }
}
