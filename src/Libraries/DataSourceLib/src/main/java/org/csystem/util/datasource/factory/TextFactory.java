package org.csystem.util.datasource.factory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TextFactory {

    public final List<String> LINES = new ArrayList<>();

    private TextFactory()
    {
    }

    public static TextFactory loadFromTextFile(Path path) throws IOException
    {
        try (var bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            var result = new TextFactory();

            String line;

            while ((line = bufferedReader.readLine()) != null)
                result.LINES.add(line);

            return result;
        }
    }

    public static TextFactory loadFromTextFile(String path) throws IOException
    {
        return loadFromTextFile(Path.of(path));
    }

    //...
}
