package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.stream.Collectors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 3, "Wrong number of arguments");
            var n = Integer.parseUnsignedInt(args[0]);
            var a = Integer.parseInt(args[1]);
            var b = Integer.parseInt(args[2]);
            var random = new Random();

            var numbersMap = random.ints(a, b + 1)
                    .limit(n)
                    .peek(v -> log.info("{}", v))
                    .boxed()
                    .collect(Collectors.partitioningBy(v -> v % 2 == 0, Collectors.toUnmodifiableSet()));

            Console.writeLine("Evens:");
            numbersMap.get(true).forEach(v -> Console.write("%d ", v));

            Console.writeLine("\n");
            Console.writeLine("Odds:");
            numbersMap.get(false).forEach(v -> Console.write("%d ", v));
            Console.writeLine();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid values!...");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}