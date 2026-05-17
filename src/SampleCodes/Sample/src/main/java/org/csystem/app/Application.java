package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.math.Complex;
import org.csystem.math.util.RandomComplexFactory;

import java.util.HashSet;
import java.util.Random;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        var treeSet = new HashSet<Complex>();
        var factory = new RandomComplexFactory(new Random());

        while (true) {
            var z = factory.createRandom(-5, 5);
            Console.write("%s ", z);

            if (z.getNorm() > 5)
                break;

            treeSet.add(z);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }
}