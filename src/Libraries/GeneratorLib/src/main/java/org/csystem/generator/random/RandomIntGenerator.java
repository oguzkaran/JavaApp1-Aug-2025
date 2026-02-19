package org.csystem.generator.random;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;

public class RandomIntGenerator implements Iterable<Integer> {
    private final RandomGenerator m_randomGenerator;
    private final int m_origin;
    private final int m_bound;
    private final int m_count;

    public RandomIntGenerator(RandomGenerator randomGenerator, int origin, int bound, int count)
    {
        m_randomGenerator = randomGenerator;
        m_origin = origin;
        m_bound = bound;
        m_count = count;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int idx;
            @Override
            public boolean hasNext()
            {
                return idx < m_count;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("Can not generate a value");

                ++idx;

                return m_randomGenerator.nextInt(m_origin, m_bound);
            }
        };
    }
}
