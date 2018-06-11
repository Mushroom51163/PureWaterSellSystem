package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.InventoryInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InventoryInfoMapper {
    //查找所有水站的库存信息
    @Select("select ws.stationName,mak.productName,inv.quantity from waterstation ws , inventory inv,market mak where ws.stationId=inv.stationId and inv.productId = mak.productId")
    List<InventoryInfo> findAllInv();

    @Select("select ws.stationName,mak.productName,inv.quantity from waterstation ws , inventory inv,market mak where ws.stationId=inv.stationId and inv.productId = mak.productId and ws.stationName=#{stationName}")
    List<InventoryInfo> findInvByStationName(@Param("stationName") String stationName);
}