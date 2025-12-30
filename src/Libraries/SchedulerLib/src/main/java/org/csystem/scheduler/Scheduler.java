package org.csystem.scheduler;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private final Timer m_timer;
    private final long m_delay;
    private final long m_interval;
    private Runnable m_cancelTask;

    private static TimerTask createTimerTask(Runnable task)
    {
        return new TimerTask() {
            public void run()
            {
                task.run();
            }
        };
    }

    private Scheduler(long intervalInMillis, long delay)
    {
        m_timer = new Timer();
        m_interval = intervalInMillis;
        m_delay = delay;
    }

    public static Scheduler of(long interval, TimeUnit timeUnit)
    {
        return of(timeUnit.toMillis(interval));
    }

    public static Scheduler of(long intervalInMillis)
    {
        return of(intervalInMillis, 0);
    }

    public static Scheduler of(long interval, long delay, TimeUnit timeUnit)
    {
        return of(timeUnit.toMillis(interval), timeUnit.toMillis(delay));
    }

    private static Scheduler of(long intervalInMillis, long delay)
    {
        return new Scheduler(intervalInMillis, delay);
    }

    public final Scheduler schedule(Runnable task)
    {
        return schedule(task, (Runnable)null);
    }

    public final Scheduler schedule(Runnable task, Runnable cancelTask)
    {
        m_cancelTask = cancelTask;
        m_timer.scheduleAtFixedRate(createTimerTask(task), m_delay, m_interval);

        return this;
    }

    public final Scheduler schedule(Runnable task, LocalDateTime dateTime)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public final void cancel()
    {
        if (m_cancelTask != null)
            m_cancelTask.run();

        m_timer.cancel();
    }
}
