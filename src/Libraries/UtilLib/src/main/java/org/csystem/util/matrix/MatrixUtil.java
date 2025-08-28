/**
 * Utility class for array operations
 * Last Update: 28th August 2025
 * @author JavaApp1-Aug-2025 Group
 */
package org.csystem.util.matrix;

import org.csystem.util.array.ArrayUtil;

import java.util.random.RandomGenerator;

public final class MatrixUtil {
    private MatrixUtil()
    {
    }

    public static int [][] add(int [][] a, int [][] b)
    {
        var m = a.length;
        var n = a[0].length;
        var r = new int[m][n];

        for (var i = 0; i < m; ++i)
            for (var j = 0; j < n; ++j)
                r[i][j] = a[i][j] + b[i][j];

        return r;
    }

    public static double [][] add(double [][] a, double [][] b)
    {
        var m = a.length;
        var n = a[0].length;
        var r = new double[m][n];

        for (var i = 0; i < m; ++i)
            for (var j = 0; j < n; ++j)
                r[i][j] = a[i][j] + b[i][j];

        return r;
    }

    public static int [][] randomMatrix(RandomGenerator randomGenerator, int m, int n, int origin, int bound)
    {
        var result = new int[m][];

        for (var i = 0; i < m; ++i)
            result[i] = ArrayUtil.randomArray(randomGenerator, n, origin, bound);

        return result;
    }

    public static int [][] randomSquareMatrix(RandomGenerator randomGenerator, int n, int origin, int bound)
    {
        return randomMatrix(randomGenerator, n, n, origin, bound);
    }

    public static boolean isMatrix(int [][] a)
    {
        for (var i = 1; i < a.length; ++i)
            if (a[i].length != a[0].length)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static int max(int [][] a)
    {
        return ArrayUtil.max(a);
    }

    public static int min(int [][] a)
    {
        return ArrayUtil.min(a);
    }

    public static int [][] multiply(int [][] a, int [][] b)
    {
        var m = a.length;
        var n = a[0].length;
        var p = b[0].length;
        var r = new int[m][p];

        for (var i = 0; i < m; ++i)
            for (var j = 0; j < n; ++j)
                for (var k = 0; k < p; ++k)
                    r[i][k] += a[i][j] * b[j][k];

        return r;
    }

    public static void multiplyBy(int [][] a, int value)
    {
        ArrayUtil.multiplyBy(a, value);
    }

    public static void print(int [][] a)
    {
        print(a, 1);
    }

    public static void print(int [][] a, int n)
    {
        ArrayUtil.print(a, n);
    }

    public static int [][] subtract(int [][] a, int [][] b)
    {
        var m = a.length;
        var n = a[0].length;
        var r = new int[m][n];

        for (var i = 0; i < m; ++i)
            for (var j = 0; j < n; ++j)
                r[i][j] = a[i][j] - b[i][j];

        return r;
    }

    public static long sum(int [][] a)
    {
        var total = 0L;

        for (var array : a)
            total += ArrayUtil.sum(array);

        return total;
    }

    public static long sumDiagonal(int [][] a)
    {
        var total = 0L;

        for (var i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static int [][] transpose(int [][] a)
    {
        var m = a.length;
        var n = a[0].length;
        var r = new int[n][m];

        for (var i = 0; i < n; ++i)
            for (var j = 0; j < m; ++j)
                r[i][j] = a[j][i];

        return r;
    }
}
