package com.sconexsoft.ecom.service;

import com.sconexsoft.ecom.entity.Dealer;
import java.util.List;

public interface DealerService {

    Dealer addDealer(Dealer dealer);
    
    Dealer getDealerById(int dealerId);
    
    List<Dealer> getAllDealers();
    
    Dealer updateDealer(int dealerId, Dealer dealer);
    
    void deleteDealer(int dealerId);
}