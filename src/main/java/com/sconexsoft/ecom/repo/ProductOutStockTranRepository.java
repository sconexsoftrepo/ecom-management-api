package com.sconexsoft.ecom.repo;

import com.sconexsoft.ecom.entity.ProductInStockTran;
import com.sconexsoft.ecom.entity.ProductOutStockTran;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductOutStockTranRepository extends JpaRepository<ProductOutStockTran, Long> {

    List<ProductOutStockTran> findByProduct_ProductId(Long productId);
    
    List<ProductOutStockTran> findByDealer_UserId(Long userId);
}
