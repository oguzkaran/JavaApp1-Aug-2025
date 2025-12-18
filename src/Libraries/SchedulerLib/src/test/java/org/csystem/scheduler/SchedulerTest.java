package org.csystem.scheduler;

import org.csystem.util.thread.ThreadUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class SchedulerTest {
    private int m_count;

    private void increment()
    {
        ++m_count;
    }

    @Test
    void test()
    {
        var scheduler = Scheduler.of(1, TimeUnit.SECONDS).schedule(this::increment);

        ThreadUtil.sleep(5_000);
        scheduler.cancel();

        Assertions.assertEquals(6, m_count);
    }
}
