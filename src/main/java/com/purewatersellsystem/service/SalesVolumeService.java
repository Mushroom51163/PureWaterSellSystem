package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.SalesVolumeInfo;

import java.util.List;

public interface SalesVolumeService {
    Result<String> findAllSalesVolume(String stationName,String data,String productName);
    Result<List> findSalesVolumeByData(String data,String productName);
    Result<List<SalesVolumeInfo>> findAllSalesVolumeForBranch(String stationName, String year, String month, String productName,String page);
    Result<List<SalesVolumeInfo>> findBetweenDate(String stationName, String start, String end,String productName,String page);

    Result<String> getTotalPageForFindBetweenDate(String stationName,String start, String end,String productName);
}
