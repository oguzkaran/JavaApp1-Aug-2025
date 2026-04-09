package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        Console.writeLine(Util.CountMinutes("9:00am-10:00am")); //60
        Console.writeLine(Util.CountMinutes("1:00pm-11:00am")); // 1320
        Console.writeLine(Util.CountMinutes("12:30pm-12:00am")); // 690
        Console.writeLine(Util.CountMinutes("1:23am-1:08am")); // 1425
    }
}

class Util {
    public static long CountMinutes(String str)
    {
        var formatter = DateTimeFormatter.ofPattern("h:mma");
        var info = str.split("-");
        var startTime = LocalTime.parse(info[0].toUpperCase(), formatter);
        var endTime = LocalTime.parse(info[1].toUpperCase(), formatter);

        return startTime.isBefore(endTime) ? ChronoUnit.MINUTES.between(startTime, endTime)
                : 24 * 60 - ChronoUnit.MINUTES.between(endTime,startTime);
    }
}
