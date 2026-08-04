package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.numeric.NumberUtil;

import java.util.Random;
import java.util.stream.IntStream;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var count = Integer.parseInt(args[0]);
            var random = new Random();

            IntStream.generate(random::nextInt).filter(NumberUtil::isPrime).limit(count).forEach(Console::writeLine);
        }
        catch (NumberFormatException e) {
            Console.Error.writeLine("Invalid count value");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}