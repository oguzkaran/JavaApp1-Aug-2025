package org.csystem.util.datasource.staff;

import lombok.*;

/**
 * Base Data Transfer Object (DTO) for staff-related DTOs.
 *
 * <p>Provides the common {@code name} field shared by all staff DTOs.</p>
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class StaffBaseDTO {
    /** The name of the staff member. */
    public String name;
}
