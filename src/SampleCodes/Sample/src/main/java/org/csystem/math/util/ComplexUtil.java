package org.csystem.math.util;

import org.csystem.math.Complex;

import java.util.Optional;
import java.util.function.Predicate;

public final class ComplexUtil {
    private ComplexUtil()
    {
        throw new UnsupportedOperationException("Utility class");
    }

    public static Optional<Complex> findFirst(Complex [] zs, Predicate<Complex> predicate)
    {
        for (var z : zs)
            if (predicate.test(z))
                return Optional.of(z);

        return Optional.empty();
    }
}
