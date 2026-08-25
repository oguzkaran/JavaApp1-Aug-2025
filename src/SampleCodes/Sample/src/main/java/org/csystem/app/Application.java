package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
class Application {
    private static int ms_val;

    public static void run(String[] args)
    {
        var random = new Random();

        random.ints(1, 50).distinct().limit(6).sorted().forEach(v -> Console.write("%d ", v));
    }
}
