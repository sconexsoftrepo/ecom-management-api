package com.sconexsoft.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sconexsoft.ecom.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
