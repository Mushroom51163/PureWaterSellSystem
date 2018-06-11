package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {
    @Insert("insert into `order` values(#{orderId},#{userId},#{orderAddr},#{orderTime},#{appointmentTime},#{productId},#{productCount},#{orderTotalPay},#{isPaied},#{stationName},#{payMethod},#{doneTime},#{orderStatus})")
    Integer addOrder(@Param("orderId") String orderId,
                     @Param("userId") String userId,
                     @Param("orderAddr") String orderAddr,
                     @Param("orderTime") String orderTime,
                     @Param("appointmentTime") String appointmentTime,
                     @Param("productId") String productId,
                     @Param("productCount") String productCount,
                     @Param("orderTotalPay") String orderTotalPay,
                     @Param("isPaied") Integer isPaied,
                     @Param("stationName") String stationName,
                     @Param("payMethod") String payMethod,
                     @Param("doneTime") String doneTime,
                     @Param("orderStatus") String orderStatus
    );

    @Select("select * from `order` where orderId = #{orderId}")
    Order findOrderById(@Param("orderId") String orderId);

    @Select("select o.orderId,o.userId,o.orderAddr,o.orderTime,o.appointmentTime,m.productName productId,o.productCount,o.orderTotalPay,o.isPaied,o.stationName,o.payMethod,o.doneTime,o.orderStatus from `order` o,`market` m where userId = #{userId} and m.productId=o.productId order by o.orderTime desc limit #{page},15")
    List<Order> findAllByUserId(@Param("userId") String userId,@Param("page") Integer page);

    @Select("select ceil(count(*)/15) from `order` where userId = #{userId}")
    String getTotalPageForFindAllByUserId(@Param("userId") String userId);


    @Update("update `order` set doneTime=#{doneTime},orderStatus=#{orderStatus} where orderId=#{orderId}")
    Integer goToDoneOrder(@Param("doneTime") String doneTime,@Param("orderStatus") String orderStatus,@Param("orderId") String orderId);

    @Update("update `order` set orderStatus='2' where orderId=#{orderId}")
    Integer evaluatedOrder(String orderId);
    @Update("update `order` set isPaied=1 where orderId=#{orderId}")
    Integer pay(String orderId);

    @Update("update `order` set orderStatus='3' where orderId = #{orderId}")
    Integer DeleteOrderById(@Param("orderId") String orderId);
    @Select("select count(*) from `order` o where o.orderId = #{orderId} and o.orderStatus='0' and o.orderId not in (select orderid from deliver)")
    String OrdercanBeDeleted(@Param("orderId") String orderId);

    @Update("update `order` set orderStatus='3' where orderId=#{orderId}")
    Integer delingOrder(String orderId);

    @Select("select o.orderId,o.userId,o.orderAddr,o.orderTime,o.appointmentTime,m.productName productId,o.productCount,o.orderTotalPay,o.isPaied,o.stationName,o.payMethod,o.doneTime,o.orderStatus  from `order` o,`market` m  where userId = #{userId} and m.productId=o.productId and m.productName like #{productName} and o.orderTime between #{start} and #{end} order by o.orderTime desc limit #{page},15")
    List<Order> findOrderByUserIdAndTime(@Param("userId") String userId,@Param("productName") String productName,@Param("start") String start,@Param("end") String end,@Param("page") Integer page);

    @Select("select ceil(count(*)/15) from `order` o,`market` m  where userId = #{userId} and m.productId=o.productId and m.productName like #{productName} and o.orderTime between #{start} and #{end} order by o.orderTime desc")
    String getTotalPageForFindOrderByUserIdAndTime(@Param("userId") String userId,@Param("productName") String productName,@Param("start") String start,@Param("end") String end);

}
