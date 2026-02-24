package org.csystem.generator.range;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Iterator;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Accessors(prefix = "m_")
public class IntRange implements Iterable<Integer> {
    private final int m_begin;
    private final int m_end;
    private final int m_step;

    public IntRange(int begin, int end)
    {
        this(begin, end, 1);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int value = m_begin;

            @Override
            public boolean hasNext()
            {
                return value <= m_end;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("Can not generate a value");

                var result = value;
                value += m_step;

                return result;
            }
        };
    }
}
