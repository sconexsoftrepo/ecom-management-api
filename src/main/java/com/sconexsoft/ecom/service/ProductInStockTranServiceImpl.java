package com.sconexsoft.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.ProductInStockTran;
import com.sconexsoft.ecom.repo.ProductInStockTranRepository;

@Service
public class ProductInStockTranServiceImpl implements ProductInStockTranService {

    @Autowired
    private ProductInStockTranRepository productInStockTranRepository;

    @Override
    public ProductInStockTran createProductInStockTran(ProductInStockTran productInStockTran) {
        return productInStockTranRepository.save(productInStockTran);
    }

    @Override
    public ProductInStockTran getProductInStockTranById(Long tranId) {
        return productInStockTranRepository.findById(tranId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + tranId));
    }

    @Override
    public List<ProductInStockTran> getAllProductInStockTrans() {
        return productInStockTranRepository.findAll();
    }

    @Override
    public ProductInStockTran updateProductInStockTran(ProductInStockTran productInStockTran) {
        if (!productInStockTranRepository.existsById(productInStockTran.getTranId())) {
            throw new RuntimeException("Transaction not found with ID: " + productInStockTran.getTranId());
        }
        return productInStockTranRepository.save(productInStockTran);
    }

    @Override
    public void deleteProductInStockTran(Long tranId) {
        if (!productInStockTranRepository.existsById(tranId)) {
            throw new RuntimeException("Transaction not found with ID: " + tranId);
        }
        productInStockTranRepository.deleteById(tranId);
    }

    @Override
    public List<ProductInStockTran> getProductInStockTransByProductId(Long productId) {
        return productInStockTranRepository.findByProductId_ProductId(productId);
    }

    @Override
    public List<ProductInStockTran> getProductInStockTransByDealerId(Long dealerId) {
        return productInStockTranRepository.findByDealerId_UserId(dealerId);
    }
}