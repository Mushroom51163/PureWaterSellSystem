package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Result;

public interface InventoryService {
    Result add(String stationName, String productName,String quantity);
    Result<String> findInventory(String stationName,String productName);
}
