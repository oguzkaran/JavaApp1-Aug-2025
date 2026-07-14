package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.StaffFactory;
import org.csystem.util.datasource.staff.StaffNameAgeDTO;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 3, "Wrong number of arguments");
            var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            var factory = StaffFactory.loadFromTextFile(args[0]);
            var staffs = factory.getStaffAsArray();
            var minDate = LocalDate.parse(args[1], formatter);
            var maxDate = LocalDate.parse(args[2], formatter);

            Arrays.stream(staffs)
                    .filter(s -> s.getBirthDate().isAfter(minDate))
                    .filter(s -> s.getBirthDate().isBefore(maxDate))
                    .map(s -> new StaffNameAgeDTO(s.getName(), s.getAge()))
                    .forEach(Console::writeLine);
        }
        catch (DateTimeParseException ignore) {
            Console.Error.writeLine("Invalid date format");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}