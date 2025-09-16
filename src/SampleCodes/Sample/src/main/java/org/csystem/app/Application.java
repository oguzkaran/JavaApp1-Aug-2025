package org.csystem.app;

import com.karandev.io.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        while (true) {
            var a = Console.readBigDecimal("Input first number:");
            var b = Console.readBigDecimal("Input second number:");
            var c = Console.readBigDecimal("Input third number:");
            var d = a.add(b);

            Console.writeLine("a = %.200f", a);
            Console.writeLine("b = %.200f", b);
            Console.writeLine("c = %.200f", c);
            Console.writeLine("d = %.200f", d);

            if (c.equals(d))
                break;
        }
    }
}

