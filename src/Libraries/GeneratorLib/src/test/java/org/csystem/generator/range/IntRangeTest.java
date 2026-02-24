package org.csystem.generator.range;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntRangeTest {
    private int m_value;

    private void forEachCallback(int val)
    {
        Assertions.assertEquals(m_value++, val);
    }

    @Test
    public void givenStep_whenOne_thenGenerateValues()
    {
        var begin = 10;
        var end = 20;
        m_value = begin;

        new IntRange(begin, end).forEach(this::forEachCallback);
    }
}
