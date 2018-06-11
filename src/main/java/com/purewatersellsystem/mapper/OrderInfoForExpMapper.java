package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.OrderInfoForExp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderInfoForExpMapper {
    @Select("select o.orderId,u.userNick,o.orderAddr,o.orderTime,o.appointmentTime,m.productName,o.isPaied,o.stationName,o.payMethod from `order` o ,  `market` m,`user` u where o.stationName=#{expStation} and o.orderStatus='0' and m.productId=o.productId and u.userId=o.userId and o.orderId not in (select orderid from deliver)")
    List<OrderInfoForExp> findAll(@Param("expStation") String expStation);

    @Select("select o.orderId,u.userNick,o.orderAddr,o.orderTime,o.appointmentTime,m.productName,o.productCount,o.orderTotalPay,o.isPaied,o.stationName,o.payMethod from `order` o ,  `market` m,`user` u ,`deliver` d where m.productId=o.productId and u.userId=o.userId and o.orderId=d.orderId and isDone='0' and d.expresserId=#{expId}")
    List<OrderInfoForExp> findOrderInfoForExpById(@Param("expId")String expId);

    @Select("select o.orderId,u.userNick,O.orderAddr,o.orderTime,o.appointmentTime,m.productName,o.productCount,o.orderTotalPay,o.isPaied,o.stationName,o.payMethod from `order` o ,`user` u,`market` m where o.orderStatus='0' and o.stationName=#{stationName} and u.userId=o.userId and m.productId=o.productId  and o.orderId not in (select orderid from deliver) order by o.ordertime desc")
    List<OrderInfoForExp> findOrderInfoForStationByStationName(@Param("stationName") String stationName);
}
