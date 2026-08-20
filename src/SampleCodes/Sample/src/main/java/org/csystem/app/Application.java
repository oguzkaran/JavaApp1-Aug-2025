package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var n = Integer.parseInt(args[0]);
            var result = IntStream.rangeClosed(2, n)
                    .mapToObj(BigInteger::valueOf)
                            .reduce(BigInteger.ONE, BigInteger::multiply);

            Console.writeLine("%d! = %s", n, result);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid value");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}