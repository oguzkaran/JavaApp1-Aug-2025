package org.csystem.util.datasource.factory;

import org.csystem.util.datasource.employee.Employee;
import org.csystem.util.datasource.people.MaritalStatus;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmployeeFactory {
    private static final MaritalStatus[] ms_status = MaritalStatus.values();
    private static final Random m_random = new Random();

    public final List<Employee> EMPLOYEES = new ArrayList<>();
    private static Employee parse(String s)
    {
        var infoStr = s.split(",");
        var id = infoStr[0];
        var name = infoStr[1];
        var emails = infoStr[2].split(";");
        var address = infoStr[3];
        var birthDate = LocalDate.parse(infoStr[4], DateTimeFormatter.ISO_LOCAL_DATE);
        var employee = new Employee(id, name, address, birthDate, ms_status[m_random.nextInt(ms_status.length)]);

        employee.getEmails().addAll(Arrays.stream(emails).toList());

        return employee;
    }

    public static EmployeeFactory loadFromTextFile(Path path)
    {
        var employeeFactory = new EmployeeFactory();
        try (var br = Files.newBufferedReader(path)) {
            employeeFactory.EMPLOYEES.addAll(br.lines()
                    .skip(1)
                    .map(EmployeeFactory::parse)
                    .toList());

        }
        catch (IOException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }

        return employeeFactory;
    }

    public static EmployeeFactory loadFromTextFile(String pathStr)
    {
        return loadFromTextFile(Path.of(pathStr));
    }
}
