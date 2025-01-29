package com.sconexsoft.ecom.service;

import com.sconexsoft.ecom.entity.ProductOutStockTran;
import java.util.List;

public interface ProductOutStockTranService {

    // Create a new product out-stock transaction
    ProductOutStockTran addProductOutStockTran(ProductOutStockTran productOutStockTran);

    // Get a product out-stock transaction by its ID
    ProductOutStockTran getProductOutStockTranById(Long tranId);

    // Get all product out-stock transactions
    List<ProductOutStockTran> getAllProductOutStockTrans();

    // Update an existing product out-stock transaction
    ProductOutStockTran updateProductOutStockTran(ProductOutStockTran productOutStockTran);

    // Delete a product out-stock transaction by ID
    void deleteProductOutStockTran(Long tranId);

    // Get all product out-stock transactions for a specific product
//    List<ProductOutStockTran> getProductOutStockTransByProductId(Long productId);
//
//    // Get all product out-stock transactions for a specific dealer
//    List<ProductOutStockTran> getProductOutStockTransByDealerId(Long dealerId);
}