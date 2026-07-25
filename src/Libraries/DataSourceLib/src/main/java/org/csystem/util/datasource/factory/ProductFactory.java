package org.csystem.util.datasource.factory;

import org.csystem.util.datasource.product.ProductInfo;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Factory class for loading {@link ProductInfo} records from a text file.
 *
 * <p>The source file is expected to have a header line (which is skipped) followed by
 * comma-separated lines with: id, name (may contain commas), stock, cost, price.</p>
 *
 * <p>Instances are created exclusively via the static {@code loadFromTextFile} factory methods.</p>
 */
public final class ProductFactory {

    /** The list of loaded {@link ProductInfo} records. */
    public final List<ProductInfo> PRODUCTS = new ArrayList<>();

    private static String join(String [] strings, int startIndex, int endIndex, String delimiter) //İleride tek hamlede yapacağız
    {
        var sb = new StringBuilder();
        for (int i = startIndex; i < endIndex; ++i)
            sb.append(strings[i]).append(delimiter);

        return sb.substring(0, sb.length() - delimiter.length());
    }

    private static ProductInfo getProduct(String line)
    {
        var productsInfo = line.split("[,]");
        var id = Integer.parseInt(productsInfo[0]);
        var name = join(productsInfo, 1, productsInfo.length - 3, ",");
        var stock = Integer.parseInt(productsInfo[productsInfo.length - 3]);
        var cost = new BigDecimal(productsInfo[productsInfo.length - 2]);
        var price = new BigDecimal(productsInfo[productsInfo.length - 1]);

        return new ProductInfo().setId(id).setName(name).setPrice(price).setCost(cost).setStock(stock);
    }

    private ProductFactory()
    {}

    /**
     * Loads all products as an {@link Optional}-wrapped {@code ProductFactory} from a text file at the given path string.
     * Returns {@link Optional#empty()} if the file is empty (no header line found).
     *
     * @param path the path string to the source text file
     * @return an {@link Optional} containing a {@code ProductFactory}, or empty if the file has no content
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static Optional<ProductFactory> loadFromTextFile(String path) throws IOException
    {
        Optional<ProductFactory> result = Optional.empty();

        try (var br = Files.newBufferedReader(Path.of(path), StandardCharsets.UTF_8)) {
            if (br.readLine() == null)
                return result;

            var productFactory = new ProductFactory();
            String line;

            while ((line = br.readLine()) != null)
                productFactory.PRODUCTS.add(getProduct(line));

            result = Optional.of(productFactory);
        }

        return result;
    }

    /**
     * Loads product records from a text file at the given {@link Path}.
     * The first line (header) is skipped.
     *
     * @param path the path to the source text file
     * @return a {@code ProductFactory} containing the loaded product records
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static ProductFactory loadFromTextFile(Path path) throws IOException
    {
        var result = new ProductFactory();

        try (var br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            if (br.readLine() == null)
                return result;
            String line;

            while ((line = br.readLine()) != null)
                result.PRODUCTS.add(getProduct(line));
        }

        return result;
    }

    /**
     * Returns all loaded products as an {@link Iterable}.
     *
     * @return an iterable over {@link ProductInfo} objects
     */
    public Iterable<ProductInfo> getProductsAsIterable()
    {
        return PRODUCTS;
    }

    /**
     * Returns a randomly selected product, or empty if the product list is empty.
     *
     * @param r the {@link Random} instance used for selection
     * @return an {@link Optional} containing a random {@link ProductInfo}, or empty if no products are loaded
     */
    public Optional<ProductInfo> getRandomProduct(Random r)
    {
        return PRODUCTS.isEmpty() ? Optional.empty() : Optional.of(PRODUCTS.get(r.nextInt(PRODUCTS.size())));
    }
}
