package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.OrderInfoForExp;
import com.purewatersellsystem.entity.Result;

import java.util.List;

public interface OrderInfoForExpService {
    Result<List<OrderInfoForExp>> findOrderInfoForExpByExpName(String expName);
    Result<List<OrderInfoForExp>> findCurrentOrderForExpByExpId(String expName);
    Result<List<OrderInfoForExp>> findOrderInfoForStationByStationName(String stationName);


}
