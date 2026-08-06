package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.io.file.FileUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    private static char getOption(Path dir)
    {
        char c;

        do
            c = Console.readChar("Are you sure to delete that directory '%s'?".formatted(dir));
        while (c != 'Y' && c != 'y' && c != 'N' && c != 'n');

        return c;
    }

    private static void delete(Path path)
    {
        try {
            if (Files.isDirectory(path)) {
                var option = getOption(path);

                if (option == 'Y' || option == 'y') {
                    FileUtil.deleteDir(path);
                    Console.writeLine("Directory %s deleted successfully", path);
                }
            }
            else {
                Files.delete(path);
                Console.writeLine("File %s deleted successfully", path);
            }
        }
        catch (IOException e) {
            Console.Error.writeLine("IO error occurred while calculating:%s", path);
        }
    }

    private static void doDelete(Path path)
    {
        if (Files.exists(path))
            delete(path);
        else
            Console.Error.writeLine("%s not found", path);
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments");

        try {
            var path = Path.of(args[0]);

            doDelete(path);
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred: %s", e.getMessage());
        }
    }
}