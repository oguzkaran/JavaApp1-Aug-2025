package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.generator.random.RandomIntGenerator;

import java.util.Random;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        var generator = new RandomIntGenerator(new Random(), 1, 100, 50);

        var iter = generator.iterator();

        while (iter.hasNext()) {
            int val = iter.next();

            Console.write("%02d ", val);
        }

        Console.writeLine();

        iter = generator.iterator();

        while (iter.hasNext()) {
            int val = iter.next();

            Console.write("%02d ", val);
        }

        Console.writeLine();
    }
}