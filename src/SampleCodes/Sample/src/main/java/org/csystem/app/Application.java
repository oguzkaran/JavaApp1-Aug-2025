package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.generator.ObjectArrayGenerator;

import java.util.Arrays;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var n = Integer.parseInt(args[0]);
            var generator = new ObjectArrayGenerator();

            Arrays.stream(generator.createObjectArray(n))
                    .peek(o -> log.info("Dynamic type:{}, Value:{}", o.getClass().getSimpleName(), o))
                    .filter(o -> o instanceof String)
                    .map(o -> ((String)o).toUpperCase())
                    .forEach(Console::writeLine);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid count value");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }
    }
}