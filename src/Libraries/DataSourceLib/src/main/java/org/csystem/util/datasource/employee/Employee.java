package org.csystem.util.datasource.employee;

import lombok.ToString;
import org.csystem.util.datasource.people.MaritalStatus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@ToString
public class Employee {
    private String m_id;
    private String m_name;
    private final List<String> m_emails = new ArrayList<>();
    private String m_address;
    private LocalDate m_birthDate;
    private MaritalStatus m_maritalStatus;

    public Employee(String id, String name, String address, LocalDate birthDate, MaritalStatus maritalStatus)
    {
        m_id = id;
        m_name = name;
        m_address = address;
        m_birthDate = birthDate;
        m_maritalStatus = maritalStatus;
    }

    public String getId()
    {
        return m_id;
    }

    public void setId(String id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public List<String> getEmails()
    {
        return m_emails;
    }

    public String getAddress()
    {
        return m_address;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;
    }

    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
    }

    public void setAddress(String address)
    {
        m_address = address;
    }

    public MaritalStatus getMaritalStatus()
    {
        return m_maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus)
    {
        m_maritalStatus = maritalStatus;
    }

    //...
}
