package org.csystem;

import org.csystem.scheduler.timeout.Alarm;
import org.csystem.util.thread.ThreadUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class AlarmLocalTimeConstructorTest {
    private static final int SECOND = 5;

    @Test
    void test()
    {
        var time = LocalTime.now().plusSeconds(SECOND);
        Alarm alarm = new Alarm(time);

        alarm.start(() -> Assertions.assertEquals(LocalTime.now().withNano(0), time.withNano(0)));
        ThreadUtil.sleep(SECOND * 1000 + 1000);
    }
}
