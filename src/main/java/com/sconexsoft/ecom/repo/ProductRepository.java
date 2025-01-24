package com.sconexsoft.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sconexsoft.ecom.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
