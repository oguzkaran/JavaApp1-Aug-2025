package org.csystem.app;


import com.karandev.io.util.console.Console;
import org.csystem.math.geometry.Point;
import org.csystem.util.string.StringUtil;

import java.util.Random;

class Application {
    public static void run(String[] args)
    {
        Random random = new Random();
        int n = Console.readInt("Input count:", "Invalid value!...");

        while (n-- > 0)
            Console.writeLine("%s", StringUtil.generateRandomTextTR(random, random.nextInt(5, 14)));

        Point p = Point.createCartesian(random.nextDouble(-100, 100), random.nextDouble(-100, 100));

        Console.writeLine(p);
    }
}
