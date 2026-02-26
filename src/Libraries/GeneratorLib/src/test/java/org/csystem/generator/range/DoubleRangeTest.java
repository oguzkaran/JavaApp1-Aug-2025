package org.csystem.generator.range;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoubleRangeTest {
    private double m_value;

    private void incrementForEachCallback(double val, double inc)
    {
        Assertions.assertEquals(m_value, val, 0.00001);
        m_value += inc;
    }

    private void operatorForEachCallback(double val)
    {
        Assertions.assertEquals(m_value, val, 0.00001);
        m_value = 2.4 * m_value + 1.45;
    }

    @Test
    public void givenValues_whenBeginEndInc_thenGenerateValues()
    {
        var begin = 1.23;
        var end = 2.34;
        var inc = 0.001;
        m_value = begin;

        new DoubleRange(begin, end, inc).forEach(val -> incrementForEachCallback(val, inc));
    }

    @Test
    public void givenOperator_thenGenerateValues()
    {
        var begin = 10;
        var end = 500;
        m_value = begin;

        new DoubleRange(begin, end, a -> 2.4 * a + 1.45).forEach(this::operatorForEachCallback);
    }
}
