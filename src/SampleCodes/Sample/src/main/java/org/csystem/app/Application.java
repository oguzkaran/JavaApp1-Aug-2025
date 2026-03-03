package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.math.geometry.Point;

import java.time.LocalDate;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        var p1 = Point.createCartesian(100, 100);
        var p2 = Point.createCartesian(200, 300);

        Util.write(p1, LocalDate.now());
        Util.write(p2);
    }
}

class Util {
    public static void write(Point p, LocalDate localDate)
    {
        Console.writeLine("Point:%s, Date:%s", p, localDate);
        //...
    }

    public static void write(Point p)
    {
        Console.writeLine("Point:%s", p);
        //...
    }
}


