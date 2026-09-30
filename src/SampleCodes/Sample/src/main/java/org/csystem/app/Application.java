package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.employee.Employee;
import org.csystem.util.datasource.factory.EmployeeFactory;

import java.io.UncheckedIOException;
import java.util.stream.Collectors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");

            var factory = EmployeeFactory.loadFromTextFile(args[0]);

            var names = factory.EMPLOYEES.stream()
                    .map(Employee::getName)
                    .collect(Collectors.joining(", ", "[[ ", " ]]"));

            Console.writeLine(names);
        }
        catch (UncheckedIOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}