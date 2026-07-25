package org.csystem.util.datasource.staff;

import lombok.*;

import java.time.DayOfWeek;

/**
 * Data Transfer Object (DTO) holding a staff member's name and their assigned rest day.
 *
 * @see StaffBaseDTO
 */
@EqualsAndHashCode(callSuper = true)
public final class StaffNameRestDayDTO extends StaffBaseDTO {
    /** The day of the week on which the staff member rests. */
    public final DayOfWeek restDay;

    /**
     * Constructs a {@code StaffNameRestDayDTO} with the given name and rest day.
     *
     * @param name    the staff member's name
     * @param restDay the staff member's rest day
     */
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
