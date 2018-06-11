package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Deliver;
import com.purewatersellsystem.entity.Evaluate;
import com.purewatersellsystem.entity.ProductEvaluate;
import com.purewatersellsystem.entity.Result;

import java.util.List;

public interface EvaluateService {
    Result<List<Evaluate>> findAllEvaluate(String page);
    Result newEvaluate(String orderId,String orderEvaluate,String deliverEvaluate);
    Result replyEvaluate(String orderEvaluate, String deliverEvaluate,String orderId);
    Result<List<ProductEvaluate>> findEvaluateByProduct(String productName);
    Result<List<Deliver>> findDeliverByExpName(String expresserName,String start,String end,String page);
    Result<String> getPageForFindDeliverByExpName(String expresserName,String start,String end);

    Result<String> getTotalPageFindAll();
}
