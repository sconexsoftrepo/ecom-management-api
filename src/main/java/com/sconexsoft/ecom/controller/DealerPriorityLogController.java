package com.sconexsoft.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sconexsoft.ecom.entity.DealerPriorityLog;
import com.sconexsoft.ecom.service.DealerPriorityLogService;

@RestController
@RequestMapping("/dealerPriorityLogs")
public class DealerPriorityLogController {

    @Autowired
    private DealerPriorityLogService dealerPriorityServiceLog;

    // Endpoint to create a new priority log
    @PostMapping
    public ResponseEntity<DealerPriorityLog> createPriorityLog(@RequestBody DealerPriorityLog dealerPriorityLog) {
        DealerPriorityLog createdLog = dealerPriorityServiceLog.createPriorityLog(dealerPriorityLog);
        return new ResponseEntity<>(createdLog, HttpStatus.CREATED);
    }

    // Endpoint to get a priority log by log ID
    @GetMapping("/{logId}")
    public ResponseEntity<DealerPriorityLog> getPriorityLogById(@PathVariable Long logId) {
        DealerPriorityLog log = dealerPriorityServiceLog.getPriorityLogById(logId);
        return new ResponseEntity<>(log, HttpStatus.OK);
    }

    // Endpoint to get all priority logs for a specific dealer ID
    @GetMapping("/dealer/{dealerId}")
    public ResponseEntity<List<DealerPriorityLog>> getPriorityLogsByDealerId(@PathVariable Long dealerId) {
        List<DealerPriorityLog> logs = dealerPriorityServiceLog.getPriorityLogsByDealerId(dealerId);
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    // Endpoint to get all priority logs
    @GetMapping
    public ResponseEntity<List<DealerPriorityLog>> getAllPriorityLogs() {
        List<DealerPriorityLog> logs = dealerPriorityServiceLog.getAllPriorityLogs();
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    // Endpoint to delete a priority log by log ID
    @DeleteMapping("/{logId}")
    public ResponseEntity<Void> deletePriorityLog(@PathVariable Long logId) {
        dealerPriorityServiceLog.deletePriorityLog(logId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}