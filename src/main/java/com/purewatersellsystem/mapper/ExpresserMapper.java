package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.Expresser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ExpresserMapper {
    //通过userNick查找派送员
    @Select("select * from expresser where expresserName = #{expresserName}")
    Expresser findExpresserByNick(@Param("expresserName") String userNick);

    @Update("update expresser set expresserStatus=1,orderId='',count=CONVERT(count,SIGNED)+1 where  expresserName = #{expresserName}")
    Integer changeToFree(@Param("expresserName") String userNick);

    @Update("update expresser set count=CONVERT(count,SIGNED)+1,orderId=#{orderId} where expresserName = #{expresserName}")
    Integer updateOrderId(@Param("expresserName") String userNick,@Param("orderId") String orderId);

    @Update("update expresser set expresserStatus=0,orderId=concat(orderId,#{orderId}) where  expresserName = #{expresserName}")
    Integer changeToBusy(@Param("expresserName") String userNick,@Param("orderId") String orderId);

    @Select("select * from expresser where expresserStation=#{expresserStation}")
    List<Expresser> findExpressersByStation(@Param("expresserStation") String expresserStation);

    @Delete("delete from expresser where expresserId = #{expresserId}")
    Integer delExpById(@Param("expresserId") String expresserId);

    @Insert("insert into expresser values(#{expresserId},#{expresserName},#{expresserStation},#{expresserTel},#{expresserStatus},#{orderId},#{count},#{expresserPwd})")
    Integer addExpresser(Expresser expresser) throws Exception;

    @Select("select * from expresser where expresserId = #{expresserId}")
    Expresser findExpById(@Param("expresserId") String expresserId);

    @Update("update expresser set expresserName=#{expresserName},expresserTel=#{expresserTel},expresserPwd=#{expresserPwd} where expresserId = #{expresserId}")
    Integer modExp(@Param("expresserName") String expresserName,@Param("expresserTel") String expresserTel,@Param("expresserPwd") String expresserPwd,@Param("expresserId") String expresserId);

    @Select("select * from expresser where expresserStatus='1' and expresserStation=#{stationName}")
    List<Expresser> getFreeExpresserByStationName(@Param("stationName") String stationName);

    @Delete("delete from deliver where orderId = #{orderId}")
    Integer deleteDeliverByOrderId(@Param("orderId") String orderId);

    @Select("select * from expresser where expresserStation=#{expresserStation}")
    List<Expresser> expresserNameList(@Param("expresserStation") String expresserStation);

    @Update("update expresser set expresserStatus=1,orderId='' where  expresserName = #{expresserName}")
    Integer changeToFreeForDel(@Param("expresserName") String userNick);

    @Update("update expresser set orderId=#{orderId} where expresserName = #{expresserName}")
    Integer updateOrderIdForDel(@Param("expresserName") String userNick,@Param("orderId") String orderId);
}
