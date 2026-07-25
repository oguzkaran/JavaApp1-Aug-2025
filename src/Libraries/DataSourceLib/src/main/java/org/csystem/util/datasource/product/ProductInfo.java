package org.csystem.util.datasource.product;

import java.math.BigDecimal;

/**
 * Represents a product with pricing, stock, and cost information.
 *
 * <p>Uses a fluent setter API (each setter returns {@code this}) to enable method chaining.
 * Products are naturally ordered by price (ascending) via {@link Comparable}.</p>
 */
public class ProductInfo implements Comparable<ProductInfo> {
    private int m_id;
    private String m_name = "";
    private int m_stock;
    private BigDecimal m_cost = BigDecimal.ZERO;
    private BigDecimal m_price = BigDecimal.ZERO;

    /**
     * Returns the unique identifier of the product.
     *
     * @return the product's id
     */
    public int getId()
    {
        return m_id;
    }

    /**
     * Sets the unique identifier of the product.
     *
     * @param id the product's id
     * @return this instance for method chaining
     */
    public ProductInfo setId(int id)
    {
        m_id = id;

        return this;
    }

    /**
     * Returns the name of the product.
     *
     * @return the product name
     */
    public String getName()
    {
        return m_name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the product name
     * @return this instance for method chaining
     */
    public ProductInfo setName(String name)
    {
        m_name = name;

        return this;
    }

    /**
     * Returns the current stock quantity of the product.
     *
     * @return the stock quantity
     */
    public int getStock()
    {
        return m_stock;
    }

    /**
     * Sets the stock quantity of the product.
     *
     * @param stock the stock quantity
     * @return this instance for method chaining
     */
    public ProductInfo setStock(int stock)
    {
        m_stock = stock;

        return this;
    }

    /**
     * Returns the cost (purchase price) of the product.
     *
     * @return the cost
     */
    public BigDecimal getCost()
    {
        return m_cost;
    }

    /**
     * Sets the cost (purchase price) of the product.
     *
     * @param cost the cost
     * @return this instance for method chaining
     */
    public ProductInfo setCost(BigDecimal cost)
    {
        m_cost = cost;

        return this;
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
     * @return this instance for method chaining
     */
    public ProductInfo setPrice(BigDecimal price)
    {
        m_price = price;

        return this;
    }

    /**
     * Calculates and returns the total profit for current stock: {@code (price - cost) * stock}.
     *
     * @return the total profit as a {@link BigDecimal}
     */
    public BigDecimal getTotal()
    {
        return m_price.subtract(m_cost).multiply(BigDecimal.valueOf(m_stock));
    }


    @Override
    public int hashCode()
    {
        return m_id;
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof ProductInfo pi && m_id == pi.m_id;
    }


    @Override
    public String toString()
    {
        return String.format("[%d]%s(%d)-%s * %s = %s", m_id, m_name, m_stock, m_cost, m_price, this.getTotal());
    }

    @Override
    public int compareTo(ProductInfo other)
    {
        return m_price.compareTo(other.m_price);
    }
}
