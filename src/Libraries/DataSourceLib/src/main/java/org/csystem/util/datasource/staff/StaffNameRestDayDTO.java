package org.csystem.util.datasource.staff;

import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;
import java.util.Objects;

@Builder
@Data
public final class StaffNameRestDayDTO {
    public final String name;
    public final DayOfWeek restDay;

    @Override
    public String toString()
    {
        return String.format("%s - %s", name, restDay);
    }
}
