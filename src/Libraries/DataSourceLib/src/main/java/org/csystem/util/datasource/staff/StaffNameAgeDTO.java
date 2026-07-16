package org.csystem.util.datasource.staff;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public final class StaffNameAgeDTO {
    public final String name;
    public final double age;

    @Override
    public String toString()
    {
        return String.format("%s - %.2f", name, age);
    }
}
