package org.csystem.game.lottery;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;

public class NumericLottery {
    private final RandomGenerator m_randomGenerator;

    public NumericLottery(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public int [][] getNumbers(int n)
    {
        return Stream.generate(() -> m_randomGenerator.ints(1, 50).distinct().limit(6).sorted().toArray())
                .limit(n).toArray(int[][]::new);
    }
}
