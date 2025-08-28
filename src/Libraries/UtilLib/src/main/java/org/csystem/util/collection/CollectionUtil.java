package org.csystem.util.collection;

import org.csystem.util.string.StringUtil;

import java.util.ArrayList;
import java.util.random.RandomGenerator;

/**
 * Utility class for collection operations
 * Last Update: 28th August 2025
 * @author JavaApp1-Aug-2025 Group
 */

public final class CollectionUtil {
    private CollectionUtil()
    {
    }

    public static ArrayList<String> randomStringListTR(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        var list = new ArrayList<String>();

        for (var i = 0; i < count; ++i)
            list.add(StringUtil.randomTextTR(randomGenerator, randomGenerator.nextInt(min, bound)));

        return list;
    }

    public static ArrayList<String> randomStringListTR(RandomGenerator randomGenerator, int min, int bound)
    {
        return randomStringListTR(randomGenerator, randomGenerator.nextInt(min, bound), min, bound);
    }

    //...
}
