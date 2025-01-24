package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import com.sconexsoft.ecom.entity.PriceLog;

public interface PriceLogService {

    // Fetch all price logs
    List<PriceLog> getAllPriceLogs();

    // Fetch a price log by ID
    Optional<PriceLog> getPriceLogById(Long id);

    // Add a new price log
    PriceLog addPriceLog(PriceLog priceLog);

    // Update an existing price log
    PriceLog updatePriceLog(PriceLog priceLog);

    // Delete a price log by ID
    boolean deletePriceLog(Long id);
}