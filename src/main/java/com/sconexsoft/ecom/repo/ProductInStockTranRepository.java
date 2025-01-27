package com.sconexsoft.ecom.repo;

import com.sconexsoft.ecom.entity.ProductInStockTran;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductInStockTranRepository extends JpaRepository<ProductInStockTran, Long> {

    List<ProductInStockTran> findByProductId_ProductId(Long productId);

    List<ProductInStockTran> findByDealerId_UserId(Long userId);
}
