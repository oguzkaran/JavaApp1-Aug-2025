package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.numeric.NumberUtil;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.LongStream;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;


@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            int count = Short.parseShort(args[0]);

            if (count <= 0)
                throw new NumberFormatException();

            var random = new Random();

            var primes = LongStream.generate(random::nextLong)
                    .peek(v -> log.info("{}", v))
                    .filter(NumberUtil::isPrime).limit(count).toArray();

            Console.writeLine("Generated prime numbers:");
            Arrays.stream(primes).forEach(Console::writeLine);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid count value");
        }
    }
}