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

                var result = value++;

                return result;
            }
        };
    }
}
