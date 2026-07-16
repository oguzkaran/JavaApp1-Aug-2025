package org.csystem.util.datasource.staff;

import lombok.*;

@EqualsAndHashCode(callSuper = true)

public final class StaffNameAgeDTO extends StaffBaseDTO {
    public final double age;

    public StaffNameAgeDTO(String name, double age)
    {
        super(name);
        this.age = age;
    }

    @Override
    public String toString()
    {
        return String.format("%s - %.2f", name, age);
    }
}
