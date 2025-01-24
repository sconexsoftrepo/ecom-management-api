package com.sconexsoft.ecom.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sconexsoft.ecom.entity.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Integer> {
}
