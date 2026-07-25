package org.csystem.util.datasource.staff;

import lombok.*;

/**
 * Data Transfer Object (DTO) holding a staff member's name and computed age.
 *
 * @see StaffBaseDTO
 */
@EqualsAndHashCode(callSuper = true)
public final class StaffNameAgeDTO extends StaffBaseDTO {
    /** The age of the staff member in years. */
    public final double age;

    /**
     * Constructs a {@code StaffNameAgeDTO} with the given name and age.
     *
     * @param name the staff member's name
     * @param age  the staff member's age in years
     */
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
