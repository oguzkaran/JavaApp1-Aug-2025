package org.csystem.game.lottery;

import java.util.TreeSet;
import java.util.random.RandomGenerator;

public class NumericLottery {
    private final RandomGenerator m_randomGenerator;

    public NumericLottery(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public int [] getNumbers()
    {
        var numbers = new int[6];

        var treeSet = new TreeSet<Integer>();

        while (treeSet.size() != 6)
            treeSet.add(m_randomGenerator.nextInt(1, 50));

        int i = 0;

        for (var val : treeSet)
            numbers[i++] = val;

        return numbers;
    }

    public int [][] getNumbers(int n)
    {
        var columns = new int[n][];

        for (var i = 0; i < n; ++i)
            columns[i] = getNumbers();

        return columns;
    }
}
