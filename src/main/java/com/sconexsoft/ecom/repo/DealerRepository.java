package com.sconexsoft.ecom.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sconexsoft.ecom.entity.Dealer;


public interface DealerRepository extends JpaRepository<Dealer, Integer> {
}
