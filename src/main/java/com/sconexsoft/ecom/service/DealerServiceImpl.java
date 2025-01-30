package com.sconexsoft.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.Dealer;
import com.sconexsoft.ecom.repo.DealerRepository;

import jakarta.transaction.Transactional;

@Service
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerRepository dealerRepository;

    @Override
    @Transactional
    public Dealer addDealer(Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    @Override
    public Dealer getDealerById(int dealerId) {
        return dealerRepository.findById(dealerId)
                .orElseThrow(() -> new RuntimeException("Dealer not found with ID: " + dealerId));
    }

    @Override
    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    @Override
    @Transactional
    public Dealer updateDealer(int dealerId, Dealer dealer) {
        Dealer existingDealer = dealerRepository.findById(dealerId)
                .orElseThrow(() -> new RuntimeException("Dealer not found with ID: " + dealerId));

        // Update the existing dealer's fields
        existingDealer.setTitle(dealer.getTitle());
        existingDealer.setPriority(dealer.getPriority());
        // Update other fields as necessary

        return dealerRepository.save(existingDealer);
    }

    @Override
    @Transactional
    public void deleteDealer(int dealerId) {
        if (!dealerRepository.existsById(dealerId)) {
            throw new RuntimeException("Dealer not found with ID: " + dealerId);
        }
        dealerRepository.deleteById(dealerId);
    }
}