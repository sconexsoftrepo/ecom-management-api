package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.PriceLog;
import com.sconexsoft.ecom.repo.PriceLogRepository;

@Service
public class PriceLogServiceImpl implements PriceLogService {

    @Autowired
    private PriceLogRepository priceLogRepository;

    @Override
    public List<PriceLog> getAllPriceLogs() {
        return priceLogRepository.findAll();
    }

    @Override
    public Optional<PriceLog> getPriceLogById(Long id) {
        return priceLogRepository.findById(id);
    }

    @Override
    public PriceLog addPriceLog(PriceLog priceLog) {
        return priceLogRepository.save(priceLog);
    }

    @Override
    public PriceLog updatePriceLog(PriceLog priceLog) {
        if (!priceLogRepository.existsById(priceLog.getLogId())) {
            throw new RuntimeException("PriceLog not found with ID: " + priceLog.getLogId());
        }
        return priceLogRepository.save(priceLog);
    }

    @Override
    public boolean deletePriceLog(Long id) {
        if (!priceLogRepository.existsById(id)) {
            throw new RuntimeException("PriceLog not found with ID: " + id);
        }
        priceLogRepository.deleteById(id);
        return true;
    }
}