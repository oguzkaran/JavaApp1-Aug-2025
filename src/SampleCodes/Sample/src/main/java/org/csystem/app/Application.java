package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.ProductFactory;
import org.csystem.util.datasource.product.ProductInfo;

import java.io.IOException;
import java.util.Optional;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;
import static java.util.stream.Collectors.*;

@Slf4j
class Application {
    private static Optional<MinMaxProductDTO> mergerFunctionCallback(Optional<ProductInfo> pOpt1, Optional<ProductInfo> pOpt2)
    {
        return pOpt1.map(p -> new MinMaxProductDTO(p, pOpt2.orElse(null)));
    }

    private static void dataExistCallback(ProductFactory productFactory)
    {
        var opt = productFactory.PRODUCTS.stream()
                .filter(p -> p.getStock() > 0)
                .collect(teeing(maxBy(ProductInfo::compareTo), minBy(ProductInfo::compareTo),
                        Application::mergerFunctionCallback));

        opt.ifPresentOrElse(Console::writeLine, () -> Console.writeLine("No product found!"));
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

@Getter
@RequiredArgsConstructor
@Accessors(prefix = "m_")
@EqualsAndHashCode
class MinMaxProductDTO {
    private final ProductInfo m_max;
    private final ProductInfo m_min;

    @Override
    public String toString()
    {
        return "Min -> Name:%s, Total:%s%nMax -> Name:%s, Total:%s".formatted(m_min.getName(), m_min.getTotal(),
                m_max.getName(), m_max.getTotal());
    }
}