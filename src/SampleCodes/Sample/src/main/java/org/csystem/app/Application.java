package org.csystem.app;

import com.karandev.io.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        Util.printInts("Values", 10, 20, 30);
        Util.printInts("Değerler", 10, 20);
        Util.printInts("Boş");
    }
}

class Util {
    public static void printInts(String prompt, int...ints)
    {
        Console.write("%s:", prompt);
        for (var a : ints)
            Console.write("%d ", a);

        Console.writeLine();
    }
}
