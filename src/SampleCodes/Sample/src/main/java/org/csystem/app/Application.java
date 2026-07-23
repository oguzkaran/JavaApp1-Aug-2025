package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

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

    private static void createDestDirectory(Path destPath)
    {
        try {
            Files.createDirectories(destPath);
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred while creating directory:", e.getMessage());
        }
    }

    private static void copy(Path srcPath, Path destPath)
    {
        try (var dirStream = Files.newDirectoryStream(srcPath, p -> !Files.isDirectory(p))) {
            createDestDirectory(destPath);
            dirStream.forEach(p -> copyFile(p, destPath.resolve(p.getFileName())));
        }
        catch (NotDirectoryException ignore) {
            Console.Error.writeLine("%s is not a directory", srcPath);
        }
        catch (IOException e) {
            Console.Error.writeLine("IO error occurred while copying files to path:%s", srcPath);
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
        if (Files.exists(srcPath))
            doIfSourceIsDirectory(srcPath, destPath);
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