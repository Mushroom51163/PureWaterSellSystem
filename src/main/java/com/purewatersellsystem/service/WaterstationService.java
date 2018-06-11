package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.WaterStation;

import java.util.List;

public interface WaterstationService {
    Result newWaterStation(String stationName,String stationAddr,String stationTel,String stationMangr);

    Result<List<WaterStation>> findAllWaterStation();

    Result deleteWaterStation(String stationId);

    Result<WaterStation> findWaterStationById(String stationId);

    Result modWaterStationById(String stationId,String stationName,String stationAddr,String stationTel,String stationMangr);
}
