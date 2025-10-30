package org.csystem.app;

import com.karandev.io.util.console.Console;

import java.util.GregorianCalendar;
import java.util.Calendar;

class Application {
    public static void run(String[] args)
    {
        var now = new GregorianCalendar();

        Console.writeLine("%02d/%02d/%04d %02d:%02d:%02d", now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1,
                now.get(Calendar.YEAR), now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));
    }
}
