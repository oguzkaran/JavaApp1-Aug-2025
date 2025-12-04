package org.csystem;

import org.csystem.scheduler.timeout.Alarm;
import org.csystem.util.thread.ThreadUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class AlarmLocalTimeConstructorTest {
    private static final int SECOND = 5;

    private Runnable createRunnable(LocalTime time)
    {
        return new Runnable() {
            public void run()
            {
                var now = LocalTime.now().withNano(0);

                Assertions.assertEquals(now, time.withNano(0));
            }
        };
    }
    @Test
    void test()
    {
        var time = LocalTime.now().plusSeconds(SECOND);
        Alarm alarm = new Alarm(time);

        alarm.start(createRunnable(time));
        ThreadUtil.sleep(SECOND * 1000 + 1000);
    }
}
