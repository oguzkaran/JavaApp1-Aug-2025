package org.csystem.util.datasource.factory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Factory class for loading a list of names from a text file.
 *
 * <p>Each line in the source file is treated as a single name entry.</p>
 *
 * <p>Instances are created exclusively via the static {@code loadFromTextFile} factory methods.</p>
 */
public class NameFactory {

    /** The list of loaded name strings. */
    public final List<String> NAMES = new ArrayList<>();

    private NameFactory()
    {
    }

    /**
     * Loads names from a text file at the given {@link Path}.
     *
     * @param path the path to the source text file
     * @return a {@code NameFactory} containing the loaded names
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static NameFactory loadFromTextFile(Path path) throws IOException
    {
        try (var bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            var result = new NameFactory();

            String name;

            while ((name = bufferedReader.readLine()) != null)
                result.NAMES.add(name);

            return result;
        }
    }

    /**
     * Loads names from a text file at the given path string.
     *
     * @param path the path string to the source text file
     * @return a {@code NameFactory} containing the loaded names
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static NameFactory loadFromTextFile(String path) throws IOException
    {
        return loadFromTextFile(Path.of(path));
    }

    //...
}
