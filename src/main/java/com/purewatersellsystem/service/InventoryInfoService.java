package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.InventoryInfo;
import com.purewatersellsystem.entity.Result;

import java.util.List;

public interface InventoryInfoService {
    Result<List<InventoryInfo>> findAll();
    Result<List<InventoryInfo>> findInvByStationName(String stationName);
}
