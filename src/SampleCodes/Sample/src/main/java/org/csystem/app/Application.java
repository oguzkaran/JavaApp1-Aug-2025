package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.employee.Employee;
import org.csystem.util.datasource.factory.EmployeeFactory;

import java.io.UncheckedIOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    private static void employeeResulCallback(Boolean pred, List<Employee> employees)
    {
        var str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        Console.writeLine("[%s] -> %s", pred ? "GE" : "S", str);
        Console.writeLine("\n");
    }
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var date = LocalDate.parse(args[1], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            var factory = EmployeeFactory.loadFromTextFile(args[0]);

            var employeesMap = factory.EMPLOYEES.stream()
                            .collect(Collectors.partitioningBy(e -> e.getBirthDate().isBefore(date)));

            employeesMap.forEach(Application::employeeResulCallback);
        }
        catch (DateTimeParseException ignore) {
            Console.Error.writeLine("Invalid date format. Date format must be like 06-09-2021");
        }
        catch (UncheckedIOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}