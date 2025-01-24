package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import com.sconexsoft.ecom.entity.Product;

public interface ProductService {
	
	Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProduct(Product product);
    boolean deleteProduct(Long id);
}