package org.csystem.diagnostics;

import java.util.concurrent.TimeUnit;

/**
 * Class for measuring the time of a code snippet
 * @author JavaApp1-Aug-2025 group
 */
public class StopWatch {
    private long m_start;
    private long m_stop;

    public static StopWatch create()
    {
        return new StopWatch();
    }

    public static StopWatch createStarted()
    {
        return (new StopWatch()).start();
    }

    public StopWatch start()
    {
        m_start = System.nanoTime();
        return this;
    }

    public StopWatch stop()
    {
        m_stop = System.nanoTime();
        return this;
    }

    public long elapsedTime(TimeUnit timeUnit)
    {
        return timeUnit.convert(m_stop - m_start, TimeUnit.NANOSECONDS);
    }
}
