package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.game.lottery.NumericLottery;

import java.util.Arrays;
import java.util.Random;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    private static void writeNumbersCallback(int [] a)
    {
        Arrays.stream(a).forEach(v -> Console.write("%02d ", v));
        Console.writeLine();
    }

    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            int n = Integer.parseInt(args[0]);
            var lottery = new NumericLottery(new Random());

            Arrays.stream(lottery.getNumbers(n)).forEach(Application::writeNumbersCallback);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid count value");
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}