package com.sconexsoft.ecom.repo;

import com.sconexsoft.ecom.entity.ProductInStockTran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInStockTranRepository extends JpaRepository<ProductInStockTran, Long> {

    List<ProductInStockTran> findByProduct_ProductId(Long productId);

    List<ProductInStockTran> findByDealer_UserId(Long userId);
}