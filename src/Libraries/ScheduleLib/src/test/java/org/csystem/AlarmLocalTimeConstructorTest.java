package org.csystem;

import org.csystem.scheduler.timeout.Alarm;
import org.csystem.util.thread.ThreadUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.TimerTask;

public class AlarmLocalTimeConstructorTest {
    private static final long MILLISECOND = 7000;
    private static final int SECOND = 5;

    private TimerTask createTimerTask(LocalTime time)
    {
        return new TimerTask() {
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

        alarm.start(createTimerTask(time));
        ThreadUtil.sleep(MILLISECOND);
    }
}
