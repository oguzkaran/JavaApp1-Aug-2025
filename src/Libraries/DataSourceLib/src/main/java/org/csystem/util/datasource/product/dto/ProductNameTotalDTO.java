package org.csystem.util.datasource.product.dto;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) holding a product's name and its total profit value.
 */
public class ProductNameTotalDTO {
    /** The product name. */
    public String name;
    /** The total profit value of the product. */
    public BigDecimal total;

    /**
     * Constructs a {@code ProductNameTotalDTO} with the given name and total.
     *
     * @param name  the product name
     * @param total the total profit value
     */
    public ProductNameTotalDTO(String name, BigDecimal total)
    {
        this.name = name;
        this.total = total;
    }

    //...

    @Override
    public String toString()
    {
        return String.format("%s,%s", name, total);
    }
}
