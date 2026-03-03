package org.csystem.util.equation;

import org.csystem.math.util.equation.EquationUtil;
import org.csystem.math.util.equation.QuadraticEquationRoots;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquationUtilQuadraticEquationTests {
    @Test
    public void givenValues_whenCoefficients_thenReturnDifferentRoots()
    {
        var a = 1;
        var b = -3;
        var c = -18;
        var expected = new QuadraticEquationRoots(6, -3);
        var actualOpt = EquationUtil.solveQuadraticEquation(a, b, c);

        Assertions.assertTrue(actualOpt.isPresent());
        Assertions.assertEquals(expected, actualOpt.get());
    }

    @Test
    public void givenValues_whenCoefficients_thenReturnSameRoots()
    {
        var a = 1;
        var b = 4;
        var c = 4;
        var expected = new QuadraticEquationRoots(-2, -2);
        var actualOpt = EquationUtil.solveQuadraticEquation(a, b, c);

        Assertions.assertTrue(actualOpt.isPresent());
        Assertions.assertEquals(expected, actualOpt.get());
    }

    @Test
    public void givenValues_whenCoefficients_thenNoRealRoots()
    {
        var a = 1;
        var b = 1;
        var c = 1;
        var actualOpt = EquationUtil.solveQuadraticEquation(a, b, c);

        Assertions.assertTrue(actualOpt.isEmpty());
    }
}
