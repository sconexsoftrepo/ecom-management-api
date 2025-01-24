package com.sconexsoft.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sconexsoft.ecom.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
