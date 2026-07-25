package org.csystem.util.datasource.staff;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Represents a staff member with identity, dates, and a rest day.
 *
 * <p>Uses a fluent setter API (each setter returns {@code this}) to enable method chaining.</p>
 */
public class StaffInfo {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int m_id;
    private String m_name;
    private LocalDate m_birthDate;
    private LocalDate m_entryDate;
    private LocalDate m_systemEntryDate;
    private DayOfWeek m_restDay;

    /**
     * Returns the unique identifier of the staff member.
     *
     * @return the staff member's id
     */
    public int getId()
    {
        return m_id;
    }

    /**
     * Sets the unique identifier of the staff member.
     *
     * @param id the staff member's id
     * @return this instance for method chaining
     */
    public StaffInfo setId(int id)
    {
        m_id = id;

        return this;
    }

    /**
     * Returns the name of the staff member.
     *
     * @return the staff member's name
     */
    public String getName()
    {
        return m_name;
    }

    /**
     * Sets the name of the staff member.
     *
     * @param name the staff member's name
     * @return this instance for method chaining
     */
    public StaffInfo setName(String name)
    {
        m_name = name;

        return this;
    }

    /**
     * Returns the birth date of the staff member.
     *
     * @return the birth date
     */
    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    /**
     * Sets the birth date of the staff member.
     *
     * @param birthDate the birth date
     * @return this instance for method chaining
     */
    public StaffInfo setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;

        return this;
    }

    /**
     * Returns the date the staff member joined the organization.
     *
     * @return the entry date
     */
    public LocalDate getEntryDate()
    {
        return m_entryDate;
    }

    /**
     * Sets the date the staff member joined the organization.
     *
     * @param entryDate the entry date
     * @return this instance for method chaining
     */
    public StaffInfo setEntryDate(LocalDate entryDate)
    {
        m_entryDate = entryDate;

        return this;
    }

    /**
     * Returns the date the staff member was registered in the system.
     *
     * @return the system entry date
     */
    public LocalDate getSystemEntryDate()
    {
        return m_systemEntryDate;
    }

    /**
     * Sets the date the staff member was registered in the system.
     *
     * @param systemEntryDate the system entry date
     * @return this instance for method chaining
     */
    public StaffInfo setSystemEntryDate(LocalDate systemEntryDate)
    {
        m_systemEntryDate = systemEntryDate;

        return this;
    }

    /**
     * Returns the rest day assigned to the staff member.
     *
     * @return the rest day
     */
    public DayOfWeek getRestDay()
    {
        return m_restDay;
    }

    /**
     * Sets the rest day for the staff member.
     *
     * @param restDay the rest day
     * @return this instance for method chaining
     */
    public StaffInfo setRestDay(DayOfWeek restDay)
    {
        m_restDay = restDay;

        return this;
    }

    /**
     * Calculates and returns the approximate age of the staff member in years.
     *
     * @return the age in years as a {@code double}
     */
    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
    }

    @Override
    public int hashCode()
    {
        return m_id;
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof StaffInfo si && si.m_id == m_id;
    }

    @Override
    public String toString()
    {
        return String.format("[%d]%s %s %s, %s, %s", m_id, m_name, FORMATTER.format(m_birthDate),
                FORMATTER.format(m_entryDate), FORMATTER.format(m_systemEntryDate), m_restDay);
    }
}
