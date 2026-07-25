package org.csystem.util.datasource.factory;

import org.csystem.util.datasource.people.MaritalStatus;
import org.csystem.util.datasource.people.Person;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Factory class for loading {@link Person} records from a text file.
 *
 * <p>Each line in the source file must be comma-separated and contain:
 * id, name, gender, birthDate (dd/MM/yyyy). A random {@link MaritalStatus}
 * is assigned to each person during loading.</p>
 *
 * <p>Instances are created exclusively via the static {@code loadFromTextFile} factory methods.</p>
 */
public final class PersonFactory {
    private static final MaritalStatus[] ms_status = MaritalStatus.values();
    private static final Random m_random = new Random();

    /** The list of loaded {@link Person} records. */
    public final List<Person> PEOPLE = new ArrayList<>();

    private static Person getPerson(String line)
    {
        var peopleInfo = line.split("[,]");

        return new Person()
                .setId(Integer.parseInt(peopleInfo[0]))
                .setName(peopleInfo[1])
                .setGender(peopleInfo[2])
                .setBirthDate(peopleInfo[3])
                .setMaritalStatus(ms_status[m_random.nextInt(ms_status.length)]);
    }

    private PersonFactory()
    {}

    /**
     * Loads person records from a text file at the given {@link Path}.
     *
     * @param path the path to the source text file
     * @return a {@code PersonFactory} containing the loaded person records
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static PersonFactory loadFromTextFile(Path path) throws IOException
    {
        var result = new PersonFactory();

        try (var br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;

            while ((line = br.readLine()) != null)
                result.PEOPLE.add(getPerson(line));
        }

        return result;
    }

    /**
     * Loads person records from a text file at the given path string.
     *
     * @param path the path string to the source text file
     * @return a {@code PersonFactory} containing the loaded person records
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static PersonFactory loadFromTextFile(String path) throws IOException
    {
        return loadFromTextFile(Path.of(path));
    }

    /**
     * Returns all loaded people as an array.
     *
     * @return an array of {@link Person} objects
     */
    public Person[] getPeopleAsArray()
    {
        return PEOPLE.toArray(new Person[0]);
    }

    /**
     * Returns all loaded people as an {@link Iterable}.
     *
     * @return an iterable over {@link Person} objects
     */
    public Iterable<Person> getPeopleAsIterable()
    {
        return PEOPLE;
    }
}
