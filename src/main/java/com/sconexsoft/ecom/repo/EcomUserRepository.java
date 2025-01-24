package com.sconexsoft.ecom.repo;

import com.sconexsoft.ecom.entity.EcomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcomUserRepository extends JpaRepository<EcomUser, Integer> {
}
