package org.csystem.util.datasource.people;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Represents a person with personal details such as name, gender, birth date, and marital status.
 *
 * <p>Uses a fluent setter API (each setter returns {@code this}) to enable method chaining.
 * Persons are naturally ordered by age (ascending) via {@link Comparable}.</p>
 */
public class Person implements Comparable<Person> {
    private static final DateTimeFormatter ms_dateTimeFormatter;
    private int m_id;
    private String m_name;
    private String m_gender;
    private LocalDate m_birthDate;
    private MaritalStatus m_maritalStatus;

    static {
         ms_dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    /**
     * Sets the unique identifier of the person.
     *
     * @param id the person's id
     * @return this instance for method chaining
     */
    public Person setId(int id)
    {
        m_id = id;

        return this;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the person's name
     * @return this instance for method chaining
     */
    public Person setName(String name)
    {
        //..
        m_name = name;

        return this;
    }

    /**
     * Sets the gender of the person.
     *
     * @param gender the person's gender
     * @return this instance for method chaining
     */
    public Person setGender(String gender)
    {
        //..
        m_gender = gender;

        return this;
    }

    /**
     * Sets the birth date by parsing a string in {@code dd/MM/yyyy} format.
     *
     * @param str the birth date string
     * @return this instance for method chaining
     */
    public Person setBirthDate(String str)
    {
        return setBirthDate(LocalDate.parse(str, ms_dateTimeFormatter));
    }

    /**
     * Sets the birth date from individual day, month, and year components.
     *
     * @param day   the day of birth
     * @param month the month of birth
     * @param year  the year of birth
     * @return this instance for method chaining
     */
    public Person setBirthDate(int day, int month, int year)
    {
        return setBirthDate(LocalDate.of(year, month, day));
    }

    /**
     * Sets the birth date from a {@link LocalDate}.
     *
     * @param birthDate the birth date
     * @return this instance for method chaining
     */
    public Person setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;

        return this;
    }

    /**
     * Sets the marital status of the person.
     *
     * @param maritalStatus the marital status
     * @return this instance for method chaining
     */
    public Person setMaritalStatus(MaritalStatus maritalStatus)
    {
        m_maritalStatus = maritalStatus;

        return this;
    }

    /**
     * Returns the unique identifier of the person.
     *
     * @return the person's id
     */
    public int getId()
    {
        return m_id;
    }

    /**
     * Returns the name of the person.
     *
     * @return the person's name
     */
    public String getName()
    {
        return m_name;
    }

    /**
     * Returns the gender of the person.
     *
     * @return the person's gender
     */
    public String getGender()
    {
        return m_gender;
    }

    /**
     * Returns the birth date of the person.
     *
     * @return the birth date
     */
    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    /**
     * Calculates and returns the approximate age of the person in years.
     *
     * @return the age in years as a {@code double}
     */
    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
    }

    /**
     * Returns the marital status of the person.
     *
     * @return the marital status
     */
    public MaritalStatus getMaritalStatus()
    {
        return m_maritalStatus;
    }

    @Override
    public int compareTo(Person other)
    {
        return Double.compare(getAge(), other.getAge());
    }

    @Override
    public int hashCode()
    {
        return m_id;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Person))
            return false;

        return ((Person)obj).m_id == m_id;
    }

    @Override
    public String toString()
    {
        return String.format("[%d]%s:%s(%s->%.2f)\"%s\"", m_id, m_name, m_gender,
                ms_dateTimeFormatter.format(m_birthDate), this.getAge(), m_maritalStatus);
    }

    //...
}
