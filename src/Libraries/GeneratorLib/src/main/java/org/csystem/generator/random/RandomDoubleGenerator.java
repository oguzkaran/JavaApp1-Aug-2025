package org.csystem.generator.random;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;

@AllArgsConstructor
@Accessors(prefix = "m_")
public class RandomDoubleGenerator implements Iterable<Double> {
    private final RandomGenerator m_randomGenerator;
    private final int m_count;
    private final double m_origin;
    private final double m_bound;

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<>() {
            int idx;
            @Override
            public boolean hasNext()
            {
                return idx < m_count;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("Can not generate a value");

                ++idx;

                return m_randomGenerator.nextDouble(m_origin, m_bound);
            }
        };
    }
}
