package org.csystem.app;


import com.karandev.io.util.console.Console;
import org.csystem.math.geometry.Point;

class Application {
    public static void run(String[] args)
    {
        Point p = Point.createCartesian(100, 100);

        Console.writeLine(p);
    }
}
