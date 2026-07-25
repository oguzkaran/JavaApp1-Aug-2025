package org.csystem.util.datasource.product.dto;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) holding a product's name and selling price.
 */
public class ProductNamePriceDTO {
    private String m_name;
    private BigDecimal m_price;

    /**
     * Constructs a {@code ProductNamePriceDTO} with the given name and price.
     *
     * @param name  the product name
     * @param price the selling price
     */
    public ProductNamePriceDTO(String name, BigDecimal price)
    {
        m_name = name;
        m_price = price;
    }

    /**
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName()
    {
        return m_name;
    }

    /**
     * Sets the product name.
     *
     * @param name the product name
     */
    public void setName(String name)
    {
        m_name = name;
    }

    /**
     * Returns the selling price of the product.
     *
     * @return the selling price
     */
    public BigDecimal getPrice()
    {
        return m_price;
    }

    /**
     * Sets the selling price of the product.
     *
     * @param price the selling price
     */
    public void setPrice(BigDecimal price)
    {
        m_price = price;
    }

    @Override
    public String toString()
    {
        return String.format("%s, %s", m_name, m_price);
    }
}
