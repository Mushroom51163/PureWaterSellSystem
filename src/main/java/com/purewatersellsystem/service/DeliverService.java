package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Deliver;
import com.purewatersellsystem.entity.DeliverInfo;
import com.purewatersellsystem.entity.Order;
import com.purewatersellsystem.entity.Result;

import java.util.List;

public interface DeliverService {
    Result newDeliver(String expNick, String orderId);

    Result<List<List<DeliverInfo>>> getDeliverInfo(String expName);

    Result updateStat(String exp,String stat,String orderId);

    Result<List<Order>> findAllOrderForExp(String expName,String page);

    Result<List<DeliverInfo>> findDeliverInfoByOrderId(String orderId);

    Result<Deliver> findDeliverById(String deliverId);

    Result<List<Deliver>> findUndoneDeliver(String stationName);

    Result<String> getTotalPageFindAllOrderByExpId(String expName);
}
