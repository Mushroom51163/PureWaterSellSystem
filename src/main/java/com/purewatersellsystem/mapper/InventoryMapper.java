package com.purewatersellsystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface InventoryMapper {
    @Update("update inventory set quantity=CONVERT(quantity,SIGNED)-1 where stationId=#{stationId} and productId=#{productId}")
    Integer sell(@Param("stationId") String stationId, @Param("productId") String productId);

    @Update("update inventory set quantity=CONVERT(quantity,SIGNED)+#{quantity} where stationId=#{stationId} and productId=#{productId}")
    Integer add(@Param("stationId") String stationId, @Param("productId") String productId,@Param("quantity") Integer quantity);

    @Insert("insert into inventory values (#{stationId},#{productId},#{quantity})")
    Integer newProductAdded(@Param("stationId") String stationId,@Param("productId") String productId,@Param("quantity") String quantity);

    @Select("select quantity from inventory where stationId=(select stationId from waterstation where stationName=#{stationName}) and productId=(select productId from market where productName=#{productName})")
    String findInventory(@Param("stationName") String stationName,@Param("productName") String productName);
}
