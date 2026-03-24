package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.TreeSet;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        var strList = new ArrayList<String>();
        var strSet = new TreeSet<String>();

        while (true) {
            var s = Console.read("Input text:");

            if ("quit".equals(s))
                break;

            strList.add(s);
        }

        Console.writeLine("String List:");
        strList.forEach(s -> Console.write("%s ", s));
        Console.writeLine();

        strSet.addAll(strList);
        Console.writeLine("String Set:");
        strSet.forEach(s -> Console.write("%s ", s));
    }
}


