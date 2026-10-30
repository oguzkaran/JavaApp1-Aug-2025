package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.employee.Employee;
import org.csystem.util.datasource.factory.EmployeeFactory;

import java.io.UncheckedIOException;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;
import static java.util.stream.Collectors.*;

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

            var emailsMap = factory.EMPLOYEES.stream()
                    .limit(count)
                    .collect(groupingBy(Employee::getMaritalStatus, flatMapping(e -> e.getEmails().stream(), joining(";"))));

            emailsMap.forEach((k, v) -> Console.writeLine("%s:%s", k, v));
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