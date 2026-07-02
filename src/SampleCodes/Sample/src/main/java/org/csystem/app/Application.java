package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.ProductFactory;

import java.math.BigDecimal;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            var threshold = new BigDecimal(Console.readDouble("Threshold:"));

            ProductFactory.loadFromTextFile(args[0]).get().PRODUCTS
                    .stream()
                    .filter(p -> p.getStock() > 0)
                    .filter(p -> p.getCost().compareTo(threshold) > 0)
                    .forEach(Console::writeLine);
        }
        catch (Exception e) {
            Console.Error.writeLine("Error while loading product file:%s", e.getMessage());
        }
    }
}
