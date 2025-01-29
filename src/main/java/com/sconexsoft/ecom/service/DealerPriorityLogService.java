package com.sconexsoft.ecom.service;

import java.util.List;
import com.sconexsoft.ecom.entity.DealerPriorityLog;

public interface DealerPriorityLogService {

    public DealerPriorityLog addPriorityLog(DealerPriorityLog dealerPriorityLog);
    public DealerPriorityLog getPriorityLogById(Long logId);
    public List<DealerPriorityLog> getPriorityLogsByDealerId(Long dealerId);
    public List<DealerPriorityLog> getAllPriorityLogs();
    public void deletePriorityLog(Long logId);
}