package org.csystem.util.datasource.factory;

import org.csystem.util.datasource.staff.StaffInfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Factory class for loading {@link StaffInfo} records from a text file.
 *
 * <p>Each line in the source file must be comma-separated and contain:
 * id, name, birthDate (yyyy-MM-dd), entryDate (yyyy-MM-dd), systemEntryDate (yyyy-MM-dd).
 * A random rest day ({@link DayOfWeek}) is assigned to each record during loading.</p>
 *
 * <p>Instances are created exclusively via the static {@code loadFromTextFile} factory methods.</p>
 */
public final class StaffFactory {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DayOfWeek[] DAY_OF_WEEKS = DayOfWeek.values();
    private static final Random m_random = new Random();

    /** The list of loaded {@link StaffInfo} records. */
    public final List<StaffInfo> STAFF = new ArrayList<>();

    private static StaffInfo getStaff(String line)
    {
        var staffInfo = line.split("[,]");

        return new StaffInfo()
                .setId(Integer.parseInt(staffInfo[0]))
                .setName(staffInfo[1])
                .setBirthDate(LocalDate.parse(staffInfo[2], FORMATTER))
                .setEntryDate(LocalDate.parse(staffInfo[3], FORMATTER))
                .setSystemEntryDate(LocalDate.parse(staffInfo[4], FORMATTER))
                .setRestDay(DAY_OF_WEEKS[m_random.nextInt(DAY_OF_WEEKS.length)]);
    }

    private StaffFactory()
    {}

    /**
     * Loads staff records from a text file at the given path string.
     *
     * @param path the path string to the source text file
     * @return a {@code StaffFactory} containing the loaded staff records
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static StaffFactory loadFromTextFile(String path) throws IOException
    {
        return loadFromTextFile(Path.of(path));
    }

    /**
     * Loads staff records from a text file at the given {@link Path}.
     *
     * @param path the path to the source text file
     * @return a {@code StaffFactory} containing the loaded staff records
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static StaffFactory loadFromTextFile(Path path) throws IOException
    {
        var result = new StaffFactory();

        try (var br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;

            while ((line = br.readLine()) != null)
                result.STAFF.add(getStaff(line));
        }

        return result;
    }

    /**
     * Returns all loaded staff records as an array.
     *
     * @return an array of {@link StaffInfo} objects
     */
    public StaffInfo[] getStaffAsArray()
    {
        return STAFF.toArray(new StaffInfo[0]);
    }
}
