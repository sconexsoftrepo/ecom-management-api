package com.sconexsoft.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sconexsoft.ecom.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}	