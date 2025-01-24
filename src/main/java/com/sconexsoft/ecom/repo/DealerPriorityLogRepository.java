package com.sconexsoft.ecom.repo;

import com.sconexsoft.ecom.entity.DealerPriorityLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealerPriorityLogRepository extends JpaRepository<DealerPriorityLog, Long> {
    List<DealerPriorityLog> findByDealer_UserId(Long userId); // Use 'UserId' instead of 'DealerId'
}
