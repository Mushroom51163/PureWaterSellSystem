package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Expresser;
import com.purewatersellsystem.entity.Order;
import com.purewatersellsystem.entity.Result;

import java.util.List;

public interface OrderService {
    Result addOrder(String userNick, String itemName, String count,String total,String userAddr, Integer isPaied, String stationName, String appTime, String payMethod);

    Result<String[]> getAppTime();

    Result<List<Order>> findAllOrderForUser(String userNick,String page);

    Result<Expresser> findExpByCurrentOrderId(String orderId);

    Result<Order> findOrderById(String orderId);

    Result deleteOrder(String orderId);

    Result<List<Order>> findOrderByUserIdAndTime(String userNick,String productName,String start,String end,String page);

    Result<String> getTotalPageForFindAllByUserId(String userId);

    Result<String> getTotalPageForFindOrderByUserIdAndTime(String userId,String productName,String start,String end);
}