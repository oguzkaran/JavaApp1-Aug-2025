package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.StaffFactory;
import org.csystem.util.datasource.staff.StaffInfo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 3, "Wrong number of arguments");
            var minDate = LocalDate.parse(args[1], DateTimeFormatter.ISO_LOCAL_DATE);
            var maxDate = LocalDate.parse(args[2], DateTimeFormatter.ISO_LOCAL_DATE);
            var factory = StaffFactory.loadFromTextFile(args[0]);
            var staffs = factory.getStaffAsArray();

            var namesOpt = Arrays.stream(staffs)
                    .filter(s -> s.getEntryDate().isAfter(minDate))
                    .filter(s -> s.getEntryDate().isBefore(maxDate))
                    .peek(s -> log.info("{}", s))
                    .map(StaffInfo::getName)
                    .reduce("%s, %s"::formatted);

            namesOpt.ifPresentOrElse(str -> Console.writeLine("Names:%s", str), () -> Console.writeLine("No staff found"));
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}