package org.csystem.generator.range;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntRangeTest {
    private int m_value;

    private void step2ForEachCallback(int val, int step)
    {
        Assertions.assertEquals(m_value, val);
        m_value += step;
    }

    private void operatorForEachCallback(int val)
    {
        Assertions.assertEquals(m_value, val);
        m_value = 2 * m_value + 1;
    }

    @Test
    public void givenStep_whenOne_thenGenerateValues()
    {
        var begin = 10;
        var end = 20;
        m_value = begin;

        new IntRange(begin, end).forEach(val -> Assertions.assertEquals(m_value++, val));
    }

    @Test
    public void givenStep_whenTwo_thenGenerateValues()
    {
        var begin = 10;
        var end = 20;
        var step = 2;
        m_value = begin;

        new IntRange(begin, end, step).forEach(val -> step2ForEachCallback(val, step));
    }

    @Test
    public void givenOperator_whenTwoTimesPlusOne_thenGenerateValues()
    {
        var begin = 10;
        var end = 500;
        m_value = begin;

        new IntRange(begin, end, a -> 2 * a + 1).forEach(this::operatorForEachCallback);
    }
}
