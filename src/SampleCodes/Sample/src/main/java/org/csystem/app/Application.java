package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.ProductFactory;

import java.io.IOException;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    private static void dataExistCallback(ProductFactory productFactory)
    {
        var products = productFactory.PRODUCTS.stream()
                .distinct()
                .sorted((p1, p2) -> p2.getStock() - p1.getStock())
                .toList();

        products.forEach(Console::writeLine);
    }

    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(Application::dataExistCallback,
                            () -> Console.Error.writeLine("Data not exist!..."));
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}