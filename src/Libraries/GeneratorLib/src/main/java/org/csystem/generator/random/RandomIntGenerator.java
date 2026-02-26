package org.csystem.generator.random;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.random.RandomGenerator;

@AllArgsConstructor
@Accessors(prefix = "m_")
public class RandomIntGenerator implements Iterable<Integer> {
    private final RandomGenerator m_randomGenerator;
    private final int m_count;
    private final int m_origin;
    private final int m_bound;

    public OptionalInt findFirst(IntPredicate predicate)
    {
        for (var v : this)
            if (predicate.test(v))
                return OptionalInt.of(v);

        return OptionalInt.empty();
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
