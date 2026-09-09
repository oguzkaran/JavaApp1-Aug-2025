package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.numeric.NumberUtil;

import java.util.Random;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 3, "Wrong number of arguments");
            var n = Integer.parseInt(args[0]);
            var a = Integer.parseInt(args[1]);
            var b = Integer.parseInt(args[2]);
            var random = new Random();

            random.ints(a, b + 1)
                    .filter(NumberUtil::isPrime)
                    .distinct()
                    .limit(n)
                    .sorted()
                    .forEach(v -> Console.write("%d ", v));
            Console.writeLine();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid value(s)");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}