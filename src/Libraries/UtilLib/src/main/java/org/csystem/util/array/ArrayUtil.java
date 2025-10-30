/**
 * Utility class for array operations
 * @author JavaApp1-Aug-2025 Group
 */
package org.csystem.util.array;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.random.RandomGenerator;

public final class ArrayUtil {
    private ArrayUtil()
    {
    }

    private static void bubbleSortAscending(int [] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (a[k] < a[k + 1])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortAscending(BigDecimal[] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1].compareTo(a[k]) < 0)
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(BigDecimal [] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (a[k].compareTo(a[k + 1]) < 0)
                    swap(a, k, k + 1);
    }

    private static void selectionSortAscending(int [] a)
    {
        int min, minIndex;

        for (var i = 0; i < a.length - 1; ++i) {
            min = a[i];
            minIndex = i;

            for (var k = i + 1; k < a.length; ++k)
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        int max, maxIndex;

        for (var i = 0; i < a.length - 1; ++i) {
            max = a[i];
            maxIndex = i;

            for (var k = i + 1; k < a.length; ++k)
                if (max < a[k]) {
                    max = a[k];
                    maxIndex = k;
                }
            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    public static double average(int [] a)
    {
        return sum(a) / (double)a.length;
    }

    public static double average(double [] a)
    {
        return sum(a) / (double)a.length;
    }

    public static double average(long [] a)
    {
        return sum(a) / (double)a.length;
    }

    public static BigDecimal average(BigDecimal [] a, RoundingMode roundingMode)
    {
        return sum(a).divide(BigDecimal.valueOf(a.length), roundingMode);
    }

    public static BigDecimal average(BigDecimal [] a, int scale, RoundingMode roundingMode)
    {
        return sum(a).divide(BigDecimal.valueOf(a.length), scale, roundingMode);
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }

    public static void bubbleSort(int [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static void bubbleSort(BigDecimal [] a)
    {
        bubbleSort(a, false);
    }

    public static void bubbleSort(BigDecimal [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static void drawHistogram(int [] data, int n, char ch)
    {
        var maxValue = ArrayUtil.max(data);

        for (var grade : data) {
            var count = (int)Math.floor(grade * n / (double)maxValue);

            while (count-- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static int [] randomArray(RandomGenerator randomGenerator, int count, int origin, int bound)
    {
        var a = new int[count];

        for (var i = 0; i < count; ++i)
            a[i] = randomGenerator.nextInt(origin, bound);

        return a;
    }

    public static double [] randomArray(RandomGenerator randomGenerator, int count, double origin, double bound)
    {
        var a = new double[count];

        for (var i = 0; i < count; ++i)
            a[i] = randomGenerator.nextDouble(origin, bound);

        return a;
    }

    public static boolean [] randomArray(RandomGenerator randomGenerator, int count)
    {
        var a = new boolean[count];

        for (var i = 0; i < count; ++i)
            a[i] = randomGenerator.nextBoolean();

        return a;
    }

    public static int [] histogramData(int [] a, int n)
    {
        var data = new int[n + 1];

        for (var val : a)
            ++data[val];

        return data;
    }

    public static int max(int...a)
    {
        return max(a, 0);
    }

    public static int max(int [] a, int startIndex)
    {
        var result = a[startIndex];

        for (var i = startIndex + 1; i < a.length; ++i)
            result = Math.max(result, a[i]);

        return result;
    }

    public static int max(int [][] a)
    {
        var result = Integer.MIN_VALUE;

        for (var array : a)
            result = Math.max(result, max(array));

        return result;
    }

    public static int [] merge(int [] a, int...b)
    {
        var merged = new int[a.length + b.length];

        for (var i = 0; i < a.length; ++i)
            merged[i] = a[i];

        for (var i = 0; i < b.length; ++i)
            merged[a.length + i] = b[i];

        return merged;
    }

    public static int min(int...a)
    {
        return min(a, 0);
    }

    public static int min(int [] a, int startIndex)
    {
        var result = a[startIndex];

        for (var i = startIndex + 1; i < a.length; ++i)
            result = Math.min(result, a[i]);

        return result;
    }

    public static int min(int [][] a)
    {
        var result = Integer.MAX_VALUE;

        for (var array : a)
            result = Math.min(result, min(array));

        return result;
    }

    public static void multiplyBy(int [] a, int value)
    {
        for (var i = 0; i < a.length; ++i)
            a[i] *= value;
    }

    public static void multiplyBy(int [][] a, int value)
    {
        for (var array : a)
            multiplyBy(array, value);
    }

    public static int partition(int [] a, int threshold)
    {
        var partitionPoint = 0;

        while (partitionPoint != a.length && a[partitionPoint] < threshold)
            ++partitionPoint;

        if (partitionPoint == a.length)
            return partitionPoint;

        for (var i = partitionPoint + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, partitionPoint++);

        return partitionPoint;
    }

    public static int partitionByEven(int [] a)
    {
        var partitionPoint = 0;

        while (partitionPoint != a.length && a[partitionPoint] % 2 == 0)
            ++partitionPoint;

        if (partitionPoint == a.length)
            return partitionPoint;

        for (var i = partitionPoint + 1; i < a.length; ++i)
            if (a[i] % 2 == 0)
                swap(a, i, partitionPoint++);

        return partitionPoint;
    }

    public static void print(int [] a)
    {
        print(a, ' ', '\n');
    }

    public static void print(int [] a, char sep, char end)
    {
        print(a, 1, sep, end);
    }

    public static void print(int [] a, int n)
    {
        print(a, n, ' ', '\n');
    }

    public static void print(int [] a, int n, char sep, char end)
    {
        var fmt = "%%0%dd%c".formatted(n, sep);

        for (var val : a)
            System.out.printf(fmt, val, sep);

        System.out.print(end);
    }

    public static void print(int [][] a)
    {
        print(a, 1);
    }

    public static void print(int [][] a, int n)
    {
        for (var array : a)
            print(array, n, ' ', '\n');
    }

    public static void print(double [] a)
    {
        print(a, '\n', '\n');
    }

    public static void print(double [] a, char sep, char end)
    {
        for (var val : a)
            System.out.printf("%f%c", val, sep);

        System.out.print(end);
    }

    public static void reverse(int [] a)
    {
        var left = 0;
        var right = a.length - 1;

        while (left < right)
            swap(a, left++, right--);
    }

    public static void reverse(char [] a)
    {
        var left = 0;
        var right = a.length - 1;

        while (left < right)
            swap(a, left++, right--);
    }

    public static void selectionSort(int [] a)
    {
        selectionSort(a, false);
    }

    public static void selectionSort(int [] a, boolean descending)
    {
        if (descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static long sum(int [] a)
    {
        var total = 0;

        for (var val : a)
            total += val;

        return total;
    }

    public static double sum(double [] a)
    {
        var total = 0.;

        for (var val : a)
            total += val;

        return total;
    }


    public static long sum(long [] a)
    {
        var total = 0L;

        for (var val : a)
            total += val;

        return total;
    }

    public static BigDecimal sum(BigDecimal [] a)
    {
        var total = BigDecimal.ZERO;

        for (var val : a)
            total = total.add(val);

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static BigDecimal max(BigDecimal... a)
    {
        if (a.length == 0)
            throw new IllegalArgumentException("max(BigDecimal...): empty array");
        return max(a, 0);
    }

    public static BigDecimal max(BigDecimal[] a, int startIndex)
    {
        var result = a[startIndex];

        for (var i = startIndex + 1; i < a.length; ++i)
            result = result.max(a[i]);

        return result;
    }
  
    public static BigDecimal min(BigDecimal... a)
    {
        if (a.length == 0)
            throw new IllegalArgumentException("min(BigDecimal...): empty array");
        return min(a, 0);
    }

    public static BigDecimal min(BigDecimal[] a, int startIndex)
    {
        var result = a[startIndex];
        for (var i = startIndex + 1; i < a.length; ++i)
            result = result.min(a[i]);

        return result;
    }

    public static void multiplyBy(BigDecimal[] a, BigDecimal value)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = a[i].multiply(value);
    }
  
    public static void multiplyBy(BigDecimal[][] a, BigDecimal value)
    {
        for (var array : a)
            multiplyBy(array, value);
    }    
      
    public static void swap(BigDecimal [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }
}
