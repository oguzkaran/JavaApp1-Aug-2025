package org.csystem.app;

import com.karandev.io.util.console.Console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

class Application {
    public static void run(String[] args)
    {
        while (true) {
            var days = Console.readLong("Input days left:");

            if (days <= 0)
                break;

            var hour = TimeUnit.DAYS.toHours(days);

            Console.writeLine("%d days is %d hours",  days, hour);
        }
    }
}

class Alarm {
    public Alarm(LocalTime time)
    {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public Alarm(LocalDateTime dateTime)
    {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public Alarm(LocalDate date)
    {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void start(TimerTask timerTask)
    {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void cancel()
    {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
