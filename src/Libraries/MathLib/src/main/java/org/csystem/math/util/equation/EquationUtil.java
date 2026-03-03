package org.csystem.math.util.equation;

import java.util.Optional;

public final class EquationUtil {
    private EquationUtil()
    {
        throw new UnsupportedOperationException("Utility class");
    }

    public static Optional<QuadraticEquationRoots> solveQuadraticEquation(double a, double b, double c)
    {
        var disc = b * b - 4 * a * c;

        if (disc >= 0) {
            var sqrt = Math.sqrt(disc);

            return Optional.of(new QuadraticEquationRoots((-b + sqrt) / (2 * a), (-b - sqrt) / (2 * a)));
        }

        return Optional.empty();
    }
}
