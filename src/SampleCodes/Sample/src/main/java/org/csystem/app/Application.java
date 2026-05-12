package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.math.Fraction;
import org.csystem.math.util.RandomFractionFactory;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        var treeSet = new TreeSet<Fraction>(Comparator.nullsLast(Comparator.naturalOrder()));
        var random = new Random();
        var factory = new RandomFractionFactory(random);

        while (true) {
            var z = factory.createRandom(1, 10);
            Console.write("%s ", z);

            if (z.getRealValue() > 2)
                break;

            var isNotNull = random.nextBoolean();

            if (!isNotNull)
                Console.write("Null ");

            treeSet.add(isNotNull ? z : null);
        }

        Console.writeLine();
        treeSet.forEach(Console::writeLine);
    }
}