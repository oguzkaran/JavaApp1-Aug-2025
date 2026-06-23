package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.array.ArrayUtil;
import org.csystem.util.numeric.NumberUtil;

import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        var r = new Random();

        int [] a = IntStream.generate(() -> r.nextInt(1, 100))
                .filter(n -> {Console.writeLine("%d generated", n); return NumberUtil.isPrime(n);})
                .limit(10).toArray();

        ArrayUtil.print(a);
        Console.writeLine();
    }
}
