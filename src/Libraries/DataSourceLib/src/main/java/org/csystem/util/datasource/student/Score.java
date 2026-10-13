package org.csystem.util.datasource.student;

import java.util.Arrays;

public enum Score {
    AA(91, 100, 4.00),
    BA(82, 90, 3.50),
    BB(73, 81, 3.00),
    CB(64, 72, 2.50),
    CC(55, 63, 2.00),
    DC(50, 54, 1.50),
    DD(45, 49, 1.00),
    FF(0, 44, 0.00);

    public final int minGrade, maxGrade;
    public final double successValue;

    Score(int minGrade, int maxGrade, double successValue)
    {
        this.minGrade = minGrade;
        this.maxGrade = maxGrade;
        this.successValue = successValue;
    }

    public static Score findScoreByGrade(int grade)
    {
        if (grade < 0 || grade > 100)
            throw new IllegalArgumentException("Grade must be between 0 and 100");

        return Arrays.stream(values())
                .filter(s -> s.minGrade <= grade)
                .filter(s -> grade < s.maxGrade)
                .findFirst().orElse(FF);
    }

    public static Score findScoreByGrade(double grade)
    {
        if (grade < 0 || grade > 100)
            throw new IllegalArgumentException("Grade must be between 0 and 100");

        return findScoreByGrade((int)Math.round(grade));
    }
}
