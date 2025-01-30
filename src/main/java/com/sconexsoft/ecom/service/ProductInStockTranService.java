package com.sconexsoft.ecom.service;

import com.sconexsoft.ecom.entity.ProductInStockTran;
import java.util.List;

public interface ProductInStockTranService {

    // Create a new product stock transaction
    ProductInStockTran addProductInStockTran(ProductInStockTran productInStockTran);

    // Get a product stock transaction by its ID
    ProductInStockTran getProductInStockTranById(Long tranId);

    // Get all product stock transactions
    List<ProductInStockTran> getAllProductInStockTrans();

    // Update an existing product stock transaction
    ProductInStockTran updateProductInStockTran(ProductInStockTran productInStockTran);

    // Delete a product stock transaction by ID
    void deleteProductInStockTran(Long tranId);

    // Get all product stock transactions for a specific product
    List<ProductInStockTran> getProductInStockTransByProductId(Long productId);

    // Get all product stock transactions for a specific dealer
    List<ProductInStockTran> getProductInStockTransByDealerId(Long dealerId);
}