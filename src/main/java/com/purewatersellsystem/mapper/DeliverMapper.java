package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.Deliver;
import com.purewatersellsystem.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DeliverMapper {
    @Insert("insert into deliver values (#{deliverId},#{orderId},#{delivereStatus},#{payMethod},#{expresserId},#{acceptTime},#{isDone})")
    Integer newDeliver(@Param("deliverId") String deliverId, @Param("orderId") String orderId, @Param("delivereStatus") String delivereStatus, @Param("payMethod") String payMethod, @Param("expresserId") String expresserId, @Param("acceptTime") String acceptTime, @Param("isDone") String isDone);

    @Select("select * from deliver where expresserId = #{ExpId} and isDone='0'")
    List<Deliver> findDeliverByExpId(@Param("ExpId") String ExpId);

    @Update("update deliver set delivereStatus = concat(delivereStatus,#{stat}) ,acceptTime = concat(acceptTime,#{statTime}) where orderId = #{orderId}")
    Integer updateDeliverStatus(@Param("stat") String stat, @Param("statTime") String statTime,@Param("orderId") String orderId);

    @Update("update deliver set isDone='1' where orderId = #{orderId}")
    Integer deliverDone(@Param("orderId") String orderId);

    @Select("select orderid from `deliver` where expresserId = #{expresserId} and isDone='1' order by acceptTime desc limit #{page},15")
    List<String> findAllOrderByExpId(@Param("expresserId") String expresserId,@Param("page") Integer page);

    @Select("select ceil(count(orderid)/15) from `deliver` where expresserId = #{expresserId} and isDone='1' order by acceptTime desc")
    String getTotalPageFindAllOrderByExpId(@Param("expresserId") String expresserId);

    @Select("select * from `deliver` where orderId = #{orderId}")
    Deliver findDeliverByOrderId(@Param("orderId") String orderId);

    @Select("select * from `deliver` where deliverId = #{deliverId}")
    Deliver findDeliverById(@Param("deliverId") String deliverId);

    @Select("select * from deliver where orderId in (select orderId from `order` where stationName=#{stationName}) and isDone='0' order by acceptTime desc")
    List<Deliver> findUndoneDeliver(@Param("stationName") String stationName);

}
