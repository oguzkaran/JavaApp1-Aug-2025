package org.csystem.util.datasource.factory;

import org.csystem.util.datasource.student.StudentInfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Factory class for loading {@link StudentInfo} records from a text file.
 *
 * <p>The source file is expected to have a header line (which is skipped) followed by
 * comma-separated lines with: name, midtermGrade, finalGrade. A random lecture is
 * assigned to each student from a predefined set during loading.</p>
 *
 * <p>Instances are created exclusively via the static {@code loadFromTextFile} factory methods.</p>
 */
public final class StudentFactory {
    private static final String[] ms_lectures = {"Matematik", "Fizik", "Kimya", "Biyoloji"};
    private static final Random m_random = new Random();

    /** The list of loaded {@link StudentInfo} records. */
    public final List<StudentInfo> STUDENTS = new ArrayList<>();

    private static StudentInfo getPerson(String line)
    {
        var studentInfo = line.split("[,]");

        return new StudentInfo(studentInfo[0], Integer.parseInt(studentInfo[1]), Integer.parseInt(studentInfo[2]),
                ms_lectures[m_random.nextInt(ms_lectures.length)]);

    }

    private StudentFactory()
    {}

    /**
     * Loads student records from a text file at the given {@link Path}.
     * The first line (header) is skipped.
     *
     * @param path the path to the source text file
     * @return a {@code StudentFactory} containing the loaded student records
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static StudentFactory loadFromTextFile(Path path) throws IOException
    {
        var result = new StudentFactory();

        try (var br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            br.readLine();

            String line;

            while ((line = br.readLine()) != null)
                result.STUDENTS.add(getPerson(line));
        }

        return result;
    }
}
