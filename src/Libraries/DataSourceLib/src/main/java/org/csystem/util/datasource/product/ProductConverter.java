package org.csystem.util.datasource.product;

import org.csystem.util.datasource.product.dto.ProductNameStockDTO;

/**
 * Converter class that wraps a single {@link ProductInfo} and provides conversion methods to various DTOs.
 */
public class ProductConverter {
    private final ProductInfo m_productInfo;

    /**
     * Constructs a {@code ProductConverter} for the given product.
     *
     * @param productInfo the product to convert
     */
    public ProductConverter(ProductInfo productInfo)
    {
        m_productInfo = productInfo;
    }

    /**
     * Converts the wrapped {@link ProductInfo} to a {@link ProductNameStockDTO}.
     *
     * @return a {@link ProductNameStockDTO} containing the product's name and stock
     */
    public ProductNameStockDTO toProductNameStockDTO()
    {
        return new ProductNameStockDTO(m_productInfo.getName(), m_productInfo.getStock());
    }
}
