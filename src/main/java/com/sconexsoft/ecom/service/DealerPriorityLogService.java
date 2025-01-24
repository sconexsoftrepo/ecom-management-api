package com.sconexsoft.ecom.service;

import java.util.List;
import com.sconexsoft.ecom.entity.DealerPriorityLog;

public interface DealerPriorityLogService {

    // Method to create a new DealerPriorityLog
    public DealerPriorityLog createPriorityLog(DealerPriorityLog dealerPriorityLog);

    // Method to get a DealerPriorityLog by its ID
    public DealerPriorityLog getPriorityLogById(Long logId);

    // Method to get all DealerPriorityLogs by a specific dealer's ID
    public List<DealerPriorityLog> getPriorityLogsByDealerId(Long dealerId);

    // Method to get all DealerPriorityLogs
    public List<DealerPriorityLog> getAllPriorityLogs();

    // Method to delete a DealerPriorityLog by its ID
    public void deletePriorityLog(Long logId);
}