package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.EmployeeFactory;

import java.io.UncheckedIOException;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var count = Integer.parseInt(args[1]);

            if (count < 1)
                throw new NumberFormatException();

            var factory = EmployeeFactory.loadFromTextFile(args[0]);

            var opt = factory.EMPLOYEES
                    .stream()
                    .limit(count)
                    .flatMap(e -> e.getEmails().stream())
                    .reduce("%s;%s"::formatted);

            opt.ifPresentOrElse(Console::writeLine, () -> Console.writeLine("No such employee exists!"));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid count value!...");
        }
        catch (UncheckedIOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}