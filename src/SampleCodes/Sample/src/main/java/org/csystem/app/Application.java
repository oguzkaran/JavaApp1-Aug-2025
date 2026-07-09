package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.StaffFactory;

import java.io.IOException;
import java.util.Arrays;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var factory = StaffFactory.loadFromTextFile(args[0]);
            var staffs = factory.getStaffAsArray();

            Arrays.stream(staffs)
                    .filter(s -> s.getRestDay().toString().startsWith(args[1]))
                    .forEach(Console::writeLine);
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}