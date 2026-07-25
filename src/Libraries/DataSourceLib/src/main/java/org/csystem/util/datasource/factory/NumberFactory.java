package org.csystem.util.datasource.factory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Factory class for loading an array of integers from a text file.
 *
 * <p>The source file format is: the first line contains the count {@code n},
 * followed by {@code n} lines each containing a single integer value.</p>
 *
 * <p>Instances are created exclusively via the static {@code loadFromTextFile} factory methods.</p>
 */
public class NumberFactory {
    private final int[] m_numbers;

    private NumberFactory(int n)
    {
        m_numbers = new int[n];
    }

    /**
     * Loads numbers from a text file at the given {@link Path}.
     *
     * @param path the path to the source text file
     * @return a {@code NumberFactory} containing the loaded numbers
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static NumberFactory loadFromTextFile(Path path) throws IOException
    {
        try (var bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            var countStr = bufferedReader.readLine();

            if (countStr == null)
                return new NumberFactory(0);

            var count = Integer.parseInt(countStr);
            var result = new NumberFactory(count);

            for (int i = 0; i < count; ++i)
                result.m_numbers[i] = Integer.parseInt(bufferedReader.readLine());

            return result;
        }
    }

    /**
     * Loads numbers from a text file at the given path string.
     *
     * @param path the path string to the source text file
     * @return a {@code NumberFactory} containing the loaded numbers
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static NumberFactory loadFromTextFile(String path) throws IOException
    {
        return loadFromTextFile(Path.of(path));
    }

    /**
     * Returns a defensive copy of the loaded numbers array.
     *
     * @return an array of integers loaded from the file
     */
    public int[] getNumbers()
    {
        return Arrays.copyOf(m_numbers, m_numbers.length);
    }
}
