package org.csystem.app;

import com.karandev.io.util.console.Console;

import java.util.NoSuchElementException;

class Application {
    public static void run(String[] args)
    {
        try {
            while (true) {
                var line = Console.readLine();
                Console.writeLine("Line -> %s", line);
            }
        }
        catch (NoSuchElementException ignore) {
            //...
        }
    }
}
