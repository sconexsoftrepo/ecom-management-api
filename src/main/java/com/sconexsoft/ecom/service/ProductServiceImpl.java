package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.Product;
import com.sconexsoft.ecom.repo.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    @Transactional
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        if (!productRepo.existsById(product.getProductId())) {
            throw new RuntimeException("Product not found with ID: " + product.getProductId());
        }
        return productRepo.save(product);
    }

    @Override
    @Transactional
    public boolean deleteProduct(Long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return true;
        }
        return false;
    }
}