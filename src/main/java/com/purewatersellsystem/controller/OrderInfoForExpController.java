package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.OrderInfoForExp;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.service.OrderInfoForExpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
//派送员的订单信息
@Controller
public class OrderInfoForExpController {
    @Resource
    private OrderInfoForExpService orderInfoForExpService;
    //跳转到接单页面
    @RequestMapping("/goToListOrder4Exp")
    public String goToListOrder4Exp(){
        return "listorder4exp";
    }
    //跳转到当前订单
    @RequestMapping("/goToCurrentOrder4Exp")
    public String goToCurrentOrder4Exp(){
        return "currentOrder";
    }
    //我完成的订单
    @RequestMapping("orderIDone")
    public String orderIDone(){
        return "orderidone";
    }
    //查找派送员可接订单
    @RequestMapping("/ListOrder4Exp")
    @ResponseBody
    public Result<List<OrderInfoForExp>> ListOrder4Exp(String ExpName){
        return orderInfoForExpService.findOrderInfoForExpByExpName(ExpName);
    }
    //查找派送员当前订单
    @RequestMapping("/findCurrentOrder")
    @ResponseBody
    public Result<List<OrderInfoForExp>> findCurrentOrder(String ExpName){
        return orderInfoForExpService.findCurrentOrderForExpByExpId(ExpName);
    }
    @RequestMapping("/findOrderInfoForStationByStationName")
    @ResponseBody
    public Result<List<OrderInfoForExp>> findOrderInfoForStationByStationName(String stationName) {
        return orderInfoForExpService.findOrderInfoForStationByStationName(stationName);
    }
}
