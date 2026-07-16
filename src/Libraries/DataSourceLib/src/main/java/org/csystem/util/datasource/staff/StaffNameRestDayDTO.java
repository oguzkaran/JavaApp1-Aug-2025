package org.csystem.util.datasource.staff;

import lombok.*;

import java.time.DayOfWeek;

@EqualsAndHashCode(callSuper = true)
public final class StaffNameRestDayDTO extends StaffBaseDTO {
    public final DayOfWeek restDay;

    public StaffNameRestDayDTO(String name, DayOfWeek restDay)
    {
        super(name);
        this.restDay = restDay;
    }

    @Override
    public String toString()
    {
        return String.format("%s - %s", name, restDay);
    }
}
