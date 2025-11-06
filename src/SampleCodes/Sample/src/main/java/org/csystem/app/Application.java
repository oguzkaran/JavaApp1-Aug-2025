package org.csystem.app;

import com.karandev.io.util.console.Console;

import java.time.LocalDate;

class Application {
    public static void run(String[] args)
    {
        var endOfCurrentMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1).minusDays(1);

        Console.writeLine(endOfCurrentMonth);
    }
}