package org.csystem.util.datasource.product.dto;

/**
 * Data Transfer Object (DTO) holding a product's name and stock quantity.
 */
public class ProductNameStockDTO {
    /** The product name. */
    public String name;
    /** The stock quantity of the product. */
    public int stock;

    /**
     * Constructs a {@code ProductNameStockDTO} with the given name and stock quantity.
     *
     * @param name  the product name
     * @param stock the stock quantity
     */
    public ProductNameStockDTO(String name, int stock)
    {
        this.name = name;
        this.stock = stock;
    }

    //...

    @Override
    public String toString()
    {
        return String.format("%s,%d", name, stock);
    }
}
