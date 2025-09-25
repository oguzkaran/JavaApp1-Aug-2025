package org.csystem.app;

import com.karandev.io.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        var a = Console.readBigDecimal("Input first number:");
        var b = Console.readBigDecimal("Input second number:");

        Console.writeLine(a.compareTo(b));
    }
}

