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
            var count = Integer.parseInt(args[0]);
            var origin = Integer.parseInt(args[1]);
            var bound = Integer.parseInt(args[2]);
            var random = new Random();

            var primesList = random.ints(origin, bound)
                    .filter(NumberUtil::isPrime)
                    .limit(count)
                    .boxed() //.mapToObj(p -> p)
                    .toList();

            primesList.forEach(p -> Console.write("%d ", p));
            Console.writeLine();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid count value!...");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}