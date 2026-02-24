package org.csystem.generator.range;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntRangeTest {
    private int m_value;

    @Test
    public void givenStep_whenOne_thenGenerateValues()
    {
        var begin = 10;
        var end = 20;
        m_value = begin;

        new IntRange(begin, end).forEach(val -> Assertions.assertEquals(m_value++, val));
    }

    private void step2ForEachCallback(int val, int step)
    {
        Assertions.assertEquals(m_value, val);
        m_value += step;
    }

    @Test
    public void givenStep_whenTwo_thenGenerateValues()
    {
        var begin = 10;
        var end = 20;
        var step = 2;
        m_value = begin ;

        new IntRange(begin, end, step).forEach(val -> step2ForEachCallback(val, step));
    }
}
