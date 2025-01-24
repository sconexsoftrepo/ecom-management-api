package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import com.sconexsoft.ecom.entity.Offer;

public interface OfferService {
    List<Offer> getAllOffers();
    Optional<Offer> getOfferById(Long id);
    Offer addOffer(Offer offer);
    Offer updateOffer(Offer offer);
    boolean deleteOffer(Long id);
}
