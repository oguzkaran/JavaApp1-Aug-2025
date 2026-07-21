package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;
import static java.util.Objects.requireNonNull;

@Slf4j
class Application {
    private static void copyFile(Path filePath, Path destPath)
    {
        try {
            Files.copy(filePath, destPath);
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred while copying file:", e.getMessage());
        }
    }

    private static void copy(Path srcPath, Path destPath)
    {
        try {
            Files.createDirectories(destPath);
            var files = new File(srcPath.toAbsolutePath().toString()).listFiles((d, n) -> !new File(d, n).isDirectory());

            requireNonNull(files, "IO error occurred while copying files to path:%s".formatted(srcPath));

            Arrays.stream(files)
                    .forEach(f -> copyFile(f.toPath(), destPath.resolve(Path.of(f.getName()))));
        }
        catch (NullPointerException e) {
            Console.Error.writeLine("Error occurred:%s", e.getMessage());
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred while creating directory:", e.getMessage());
        }
    }

    private static void doIfSourceIsDirectory(Path srcPath, Path destPath)
    {
        if (Files.notExists(destPath))
            copy(srcPath, destPath);
        else
            Console.Error.writeLine("%s already exists. Copy operation can not be started", destPath);
    }

    private static void doCopy(Path srcPath, Path destPath)
    {
        if (Files.exists(srcPath)) {
            if (Files.isDirectory(srcPath))
                doIfSourceIsDirectory(srcPath, destPath);
            else
                Console.Error.writeLine("%s is not a directory", srcPath);
        }
        else
            Console.Error.writeLine("%s not found", srcPath);
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments");

        try {
            var srcPath = Path.of(args[0]);
            var destPath = Path.of(args[1]);

            doCopy(srcPath, destPath);
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred: %s", e.getMessage());
        }
    }
}