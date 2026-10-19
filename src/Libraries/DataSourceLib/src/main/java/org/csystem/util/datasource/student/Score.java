package org.csystem.util.datasource.student;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public enum Score {
    AA(91, 100, 4.00),
    BA(82, 90, 3.50),
    BB(73, 81, 3.00),
    CB(64, 72, 2.50),
    CC(55, 63, 2.00),
    DC(50, 54, 1.50),
    DD(45, 49, 1.00),
    FF(0, 44, 0.00);

    private static final NavigableMap<Integer, Score> ms_map = new TreeMap<>();

    static {
        Arrays.stream(values()).forEach(s -> ms_map.put(s.minGrade, s));
    }

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

        return ms_map.get(ms_map.floorKey(grade));
    }

    public static Score findScoreByGrade(double grade)
    {
        if (grade < 0 || grade > 100)
            throw new IllegalArgumentException("Grade must be between 0 and 100");

        return findScoreByGrade((int)Math.round(grade));
    }
}