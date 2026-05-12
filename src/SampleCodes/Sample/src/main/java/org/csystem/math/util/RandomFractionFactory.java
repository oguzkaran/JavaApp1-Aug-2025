package org.csystem.math.util;

import org.csystem.math.Complex;
import org.csystem.math.Fraction;

import java.util.random.RandomGenerator;

public class RandomFractionFactory {
    private final RandomGenerator m_randomGenerator;

    public RandomFractionFactory(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public Fraction createRandom(int origin, int bound)
    {
        return new Fraction(m_randomGenerator.nextInt(origin, bound), m_randomGenerator.nextInt(origin, bound));
    }

}
