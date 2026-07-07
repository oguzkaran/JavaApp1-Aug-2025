package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.ProductFactory;
import org.csystem.util.datasource.product.ProductInfo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    private static void dataExistCallback(ProductFactory productFactory, BigDecimal minCost, BigDecimal maxCost)
    {
        productFactory.PRODUCTS.stream()
                .filter(p -> minCost.compareTo(p.getCost()) < 0)
                .filter(p -> p.getCost().compareTo(maxCost) < 0)
                .forEach(Console::writeLine);
    }

    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 3, "Wrong number of arguments");
            ProductFactory.loadFromTextFile(args[0])
                    .ifPresentOrElse(pf -> dataExistCallback(pf, new BigDecimal(args[1]), new BigDecimal(args[2])), () -> Console.Error.writeLine("Data not exist!..."));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Stock value must be an integer number!...");
        }
        catch (IOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}
