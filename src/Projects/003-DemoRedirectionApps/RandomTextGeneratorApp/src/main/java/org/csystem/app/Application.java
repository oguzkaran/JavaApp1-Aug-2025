package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.util.Random;

class Application {
    public static void run(String[] args)
    {
        if (args.length != 3) {
            Console.Error.writeLine("Wrong number of arguments");
            System.exit(1);
        }

        try {
            var count = Integer.parseInt(args[0]);

            if (count <= 0) {
                Console.Error.writeLine("count must be positive");
                System.exit(1);
            }

            var min = Integer.parseInt(args[1]);
            var bound = Integer.parseInt(args[2]);
            var random = new Random();

            while (count-- > 0)
                Console.writeLine(StringUtil.randomTextTR(random, random.nextInt(min, bound)));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Arguments must be 4 bytes integer numbers!...");
        }
        catch (Exception ignore) {
            Console.Error.writeLine("Invalid Values!...");
        }
    }
}
