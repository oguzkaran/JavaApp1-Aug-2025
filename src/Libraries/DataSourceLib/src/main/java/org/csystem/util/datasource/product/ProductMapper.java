package org.csystem.util.datasource.product;

import org.csystem.util.datasource.product.dto.ProductNameStockDTO;

/**
 * Mapper class for converting {@link ProductInfo} objects to various DTOs.
 */
public class ProductMapper {
    /**
     * Converts a {@link ProductInfo} to a {@link ProductNameStockDTO}.
     *
     * @param productInfo the product to convert
     * @return a {@link ProductNameStockDTO} containing the product's name and stock
     */
    public ProductNameStockDTO toProductStockDTO(ProductInfo productInfo)
    {
        return new ProductNameStockDTO(productInfo.getName(), productInfo.getStock());
    }
}
