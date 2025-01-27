package com.sconexsoft.ecom.repo;


import com.sconexsoft.ecom.entity.PriceLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PriceLogRepository extends JpaRepository<PriceLog, Long> {
}
