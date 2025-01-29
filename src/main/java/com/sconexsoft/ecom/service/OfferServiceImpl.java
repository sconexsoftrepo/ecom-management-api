package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.Offer;
import com.sconexsoft.ecom.repo.OfferRepository;

import jakarta.transaction.Transactional;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepo;

    @Override
    public List<Offer> getAllOffers() {
        return offerRepo.findAll();
    }

    @Override
    public Optional<Offer> getOfferById(Long id) {
        return offerRepo.findById(id);
    }

    @Override
    @Transactional
    public Offer addOffer(Offer offer) {
        return offerRepo.save(offer);
    }

    @Override
    @Transactional
    public Offer updateOffer(Offer offer) {
        return offerRepo.save(offer);
    }

    @Override
    @Transactional
    public boolean deleteOffer(Long id) {
        if (offerRepo.existsById(id)) {
            offerRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
