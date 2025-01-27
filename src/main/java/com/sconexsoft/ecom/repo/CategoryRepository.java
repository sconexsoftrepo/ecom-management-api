package com.sconexsoft.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sconexsoft.ecom.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}	