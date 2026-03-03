package org.csystem.math.util.equation;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class QuadraticEquationRoots {
    private static final double VALUE = 0.000001;
    public final double x1;
    public final double x2;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof QuadraticEquationRoots r
                && Math.abs(x1 - r.x1) < VALUE
                && Math.abs(x2 - r.x2) < VALUE;
    }
}
