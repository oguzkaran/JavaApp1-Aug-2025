package org.csystem;

import org.csystem.scheduler.timeout.CountDownScheduler;
import org.csystem.scheduler.timeout.CountDownSchedulerEx;
import org.csystem.util.thread.ThreadUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class CountDownSchedulerExTimeUnitConstructorTest {
    private static final long TOTAL_SECONDS = 5;
    private static final int PERIOD_IN_SECONDS = 1;
    private static final int PERIOD_IN_MILLISECONDS = PERIOD_IN_SECONDS * 1000;
    private static final long TOTAL_MILLISECONDS = TOTAL_SECONDS * 1000;

    private CountDownScheduler createScheduler(LocalTime time)
    {
        return new CountDownSchedulerEx(TOTAL_SECONDS, PERIOD_IN_SECONDS, TimeUnit.SECONDS) {
            public void onStart()
            {
                System.out.println("Started");
                System.out.printf("%02d", TOTAL_SECONDS);
            }

            public void onTick(long remainingMilliseconds)
            {
                System.out.printf("%02d%n", (TOTAL_MILLISECONDS  - remainingMilliseconds) / PERIOD_IN_MILLISECONDS);
            }

            public void onFinish()
            {
                System.out.println("Finished");
                var now = LocalTime.now().withNano(0);

                Assertions.assertEquals(time, now);
            }
        };
    }

    @Test
    @Disabled
    void test()
    {
        var time = LocalTime.now().withNano(0).plusSeconds(TOTAL_SECONDS);

        createScheduler(time).start();
        ThreadUtil.sleep(PERIOD_IN_MILLISECONDS + 1000);
    }
}
