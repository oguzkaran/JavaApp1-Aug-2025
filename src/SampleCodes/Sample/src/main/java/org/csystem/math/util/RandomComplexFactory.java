package org.csystem.math.util;

import org.csystem.math.Complex;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;

public class RandomComplexFactory {
    private final RandomGenerator m_randomGenerator;

    public RandomComplexFactory(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public Complex createRandom(double origin, double bound)
    {
        return new Complex(m_randomGenerator.nextDouble(origin, bound), m_randomGenerator.nextDouble(origin, bound));
    }

    public Complex [] createRandom(int count, double origin, double bound)
    {
        var result = new Complex[count];

        for (var i = 0; i < count; i++)
            result[i] = createRandom(origin, bound);

        return result;
    }
}
