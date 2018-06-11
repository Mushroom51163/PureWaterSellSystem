package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.WaterStation;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WaterStationMapper {
    @Select("select * from waterstation where stationName=#{stationName}")
    WaterStation findStationByName(@Param("stationName") String stationName);

    @Insert("Insert into waterstation values(#{stationId},#{stationName},#{stationAddr},#{stationTel},#{stationMangr})")
    Integer newWaterStation(WaterStation waterStation);

    @Select("select * from waterstation")
    List<WaterStation> findAllWaterStation();

    @Delete("delete from waterstation where stationId=#{stationId}")
    Integer deleteWaterStation(@Param("stationId") String stationId);

    @Select("select * from waterstation where stationId=#{stationId}")
    WaterStation findStationById(@Param("stationId") String stationId);

    @Update("update waterstation set stationName=#{stationName},stationAddr=#{stationAddr},stationTel=#{stationTel},stationMangr=#{stationMangr} where stationId=#{stationId}")
    Integer modWaterStation(WaterStation waterStation);

    @Select("select stationName from waterstation")
    List<String> findAllWaterStationName();

}
