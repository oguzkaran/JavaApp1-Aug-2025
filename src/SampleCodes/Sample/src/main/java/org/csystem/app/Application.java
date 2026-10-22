package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.ProductFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    private static <E> void print(Iterable<E> iterable)
    {
        iterable.forEach(Console::writeLine);
    }

    private static void dataExistCallback(ProductFactory productFactory, BigDecimal threshold)
    {
        var iterator = productFactory.PRODUCTS.stream()
                .filter(p -> p.getStock() > 0)
                .filter(p -> p.getTotal().compareTo(threshold) > 0)
                .iterator();

        print(() -> iterator);
    }

    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 2, "Wrong number of arguments");
            var threshold = new BigDecimal(args[1]);

            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(pf -> dataExistCallback(pf, threshold),
                            () -> Console.Error.writeLine("Data not exist!..."));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid threshold value!...");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}