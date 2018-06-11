package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.Deliver;
import com.purewatersellsystem.entity.Evaluate;
import com.purewatersellsystem.entity.ProductEvaluate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EvaluateMapper {
    @Select("select * from evaluate limit ${page},15")
    List<Evaluate> findAll(@Param("page") Integer page);

    @Select("select ceil(count(*)/15) from evaluate")
    String getTotalPageForFindAll();

    @Insert("insert into evaluate values(#{evaluateId},#{orderId},#{deliverId},#{orderEvaluate},#{deliverEvaluate})")
    Integer newEvaluate(@Param("evaluateId") String evaluateId,@Param("orderId") String orderId,@Param("deliverId") String deliverId,@Param("orderEvaluate") String orderEvaluate,@Param("deliverEvaluate") String deliverEvaluate);

    @Update("update evaluate set orderEvaluate = concat(orderEvaluate,#{orderEvaluate}) ,deliverEvaluate = concat(deliverEvaluate,#{deliverEvaluate}) where orderId = #{orderId}")
    Integer replyEvaluate(@Param("orderEvaluate") String orderEvaluate,@Param("deliverEvaluate") String deliverEvaluate,@Param("orderId") String orderId);

    @Select("select o.userId,e.orderEvaluate,e.deliverEvaluate from evaluate e ,`order` o where e.orderId in (select orderId from `order` where productid=#{productid}) and e.orderId=o.orderId")
    List<ProductEvaluate> findEvaluateByProduct(@Param("productid") String productid);

    @Select("select * from deliver where orderId in (select orderId from `order` where stationName=(select expresserStation from expresser where expresserName = #{expresserName}) and orderTime between #{start} and #{end}) and expresserId=#{expresserId} limit #{page},15")
    List<Deliver> findDeliverByExpName(@Param("expresserName") String expresserName,@Param("start") String start,@Param("end") String end,@Param("expresserId") String expresserId,@Param("page") Integer page);

    @Select("select ceil(count(*)/15) from deliver where orderId in (select orderId from `order` where stationName=(select expresserStation from expresser where expresserName = #{expresserName}) and orderTime between #{start} and #{end}) and expresserId=#{expresserId}")
    String getPageForFindDeliverByExpName(@Param("expresserName") String expresserName,@Param("start") String start,@Param("end") String end,@Param("expresserId") String expresserId);
}
