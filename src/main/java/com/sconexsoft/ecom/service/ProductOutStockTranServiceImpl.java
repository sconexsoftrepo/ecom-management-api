package com.sconexsoft.ecom.service;

import com.sconexsoft.ecom.entity.ProductOutStockTran;
import com.sconexsoft.ecom.repo.ProductOutStockTranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOutStockTranServiceImpl implements ProductOutStockTranService {

    @Autowired
    private ProductOutStockTranRepository productOutStockTranRepository;

    @Override
    public ProductOutStockTran createProductOutStockTran(ProductOutStockTran productOutStockTran) {
        return productOutStockTranRepository.save(productOutStockTran);
    }

    @Override
    public ProductOutStockTran getProductOutStockTranById(Long tranId) {
        return productOutStockTranRepository.findById(tranId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + tranId));
    }

    @Override
    public List<ProductOutStockTran> getAllProductOutStockTrans() {
        return productOutStockTranRepository.findAll();
    }

    @Override
    public ProductOutStockTran updateProductOutStockTran(ProductOutStockTran productOutStockTran) {
        if (!productOutStockTranRepository.existsById(productOutStockTran.getTranId())) {
            throw new RuntimeException("Transaction not found with ID: " + productOutStockTran.getTranId());
        }
        return productOutStockTranRepository.save(productOutStockTran);
    }

    @Override
    public void deleteProductOutStockTran(Long tranId) {
        if (!productOutStockTranRepository.existsById(tranId)) {
            throw new RuntimeException("Transaction not found with ID: " + tranId);
        }
        productOutStockTranRepository.deleteById(tranId);
    }

//    @Override
//    public List<ProductOutStockTran> getProductOutStockTransByProductId(Long productId) {
//        return productOutStockTranRepository.findByProductId(productId);
//    }
//
//    @Override
//    public List<ProductOutStockTran> getProductOutStockTransByDealerId(Long dealerId) {
//        return productOutStockTranRepository.findByDealerId(dealerId);
//    }
}