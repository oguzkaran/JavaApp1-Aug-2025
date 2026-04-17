package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        var linkedList = new LinkedList<String>();

        while (true) {
            var s = Console.read("Input text:");

            if ("quit".equals(s))
                break;

            linkedList.push(s);
        }

        while (!linkedList.isEmpty()) {
            var str = linkedList.pop();

            Console.write("%s ", str);
        }

        Console.writeLine();
    }
}