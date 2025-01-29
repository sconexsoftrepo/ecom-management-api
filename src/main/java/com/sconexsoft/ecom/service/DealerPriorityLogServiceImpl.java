package com.sconexsoft.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.Dealer;
import com.sconexsoft.ecom.entity.DealerPriorityLog;
import com.sconexsoft.ecom.repo.DealerPriorityLogRepository;
import com.sconexsoft.ecom.repo.DealerRepository;

import jakarta.transaction.Transactional;

@Service
public class DealerPriorityLogServiceImpl implements DealerPriorityLogService {

    @Autowired
    private DealerPriorityLogRepository dealerPriorityLogRepository;

    @Autowired
    private DealerRepository dealerRepository;

    @Override
    @Transactional
    public DealerPriorityLog addPriorityLog(DealerPriorityLog dealerPriorityLog) {
        // Fetch the Dealer using the dealer from DealerPriorityLog
        Dealer dealer = dealerPriorityLog.getDealer();
        if (dealer == null || dealerRepository.findById(dealer.getUserId()).isEmpty()) {
            throw new RuntimeException("Dealer not found with ID: " + dealer.getUserId());
        }
        
        // Save the log in the repository
        return dealerPriorityLogRepository.save(dealerPriorityLog);
    }

    @Override
    public DealerPriorityLog getPriorityLogById(Long logId) {
        // Fetch the DealerPriorityLog by logId
        return dealerPriorityLogRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Priority Log not found with ID: " + logId));
    }

    @Override
    public List<DealerPriorityLog> getPriorityLogsByDealerId(Long dealerId) {
        // Fetch all priority logs for a dealer using the dealerId
        return dealerPriorityLogRepository.findByDealer_UserId(dealerId);
    }

    @Override
    public List<DealerPriorityLog> getAllPriorityLogs() {
        // Fetch all priority logs
        return dealerPriorityLogRepository.findAll();
    }

    @Override
    public void deletePriorityLog(Long logId) {
        // Check if the log exists before attempting to delete
        if (!dealerPriorityLogRepository.existsById(logId)) {
            throw new RuntimeException("Priority Log not found with ID: " + logId);
        }
        // Delete the log by its ID
        dealerPriorityLogRepository.deleteById(logId);
    }
}