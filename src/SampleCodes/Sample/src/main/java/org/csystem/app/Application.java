package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.Stack;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        var intStack = new Stack<Integer>();
        var random = new Random();

        while (true) {
            var val = random.nextInt(-10, 11);

            if (val == 0)
                break;

            intStack.push(val);
        }

        var value = random.nextInt(-10, 11);
        Console.writeLine("Value:%d", value);

        var order = intStack.search(value);

        Console.writeLine("%d%s", value, order != -1 ? " found at %d".formatted(order) : " not found");

        while (!intStack.empty())
            Console.write("%d ", intStack.pop());

        Console.writeLine();
    }
}
