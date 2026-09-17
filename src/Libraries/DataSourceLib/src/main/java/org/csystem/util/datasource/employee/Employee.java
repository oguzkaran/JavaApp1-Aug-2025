package org.csystem.util.datasource.employee;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String m_id;
    private String m_name;
    private final List<String> m_emails = new ArrayList<>();
    private String m_address;

    public Employee(String id, String name, String address)
    {
        m_id = id;
        m_name = name;
        m_address = address;
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

    public void setAddress(String address)
    {
        m_address = address;
    }

    //...
}
