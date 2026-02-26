package org.csystem.generator.range;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.DoubleUnaryOperator;

@AllArgsConstructor
@Accessors(prefix = "m_")
public class DoubleRange implements Iterable<Double> {
    private final double m_begin;
    private final double m_end;
    private final DoubleUnaryOperator m_doubleUnaryOperator;

    public DoubleRange(double begin, double end, double inc)
    {
        this(begin, end, a -> a + inc);
    }

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<>() {
            double value = m_begin;

            @Override
            public boolean hasNext()
            {
                return value <= m_end;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("Can not generate a value");

                var result = value;
                value = m_doubleUnaryOperator.applyAsDouble(value);

                return result;
            }
        };
    }
}
