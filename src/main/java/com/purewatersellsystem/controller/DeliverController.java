package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Deliver;
import com.purewatersellsystem.entity.DeliverInfo;
import com.purewatersellsystem.entity.Order;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.service.DeliverService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
//配送员
@Controller
public class DeliverController {
    @Resource
    private DeliverService deliverService;

    //接单
    @RequestMapping("/goToGetDeliverForExpresser")
    @ResponseBody
    public Result execute(String expNick, String orderId) {
        return deliverService.newDeliver(expNick, orderId);
    }

    //获取派送员可接订单
    @RequestMapping("/getDeliverOrderStat")
    @ResponseBody
    public Result<List<List<DeliverInfo>>> getDeliverInfo(String expName) {
        return deliverService.getDeliverInfo(expName);
    }
    //更新派送状态
    @RequestMapping("/updateStatAndTime")
    @ResponseBody
    public Result updateStatAndTime(String exp,String stat, String orderId) {
        return deliverService.updateStat(exp,stat, orderId);
    }
    //查找所有已完成订单
    @RequestMapping("/findAllOrderForExp")
    @ResponseBody
    public Result<List<Order>> findAllOrderForExp(String expName,String page) {
        return deliverService.findAllOrderForExp(expName,page);
    }
    @RequestMapping("/getTotalPageFindAllOrderByExpId")
    @ResponseBody
    public Result<String> getTotalPageFindAllOrderByExpId(String userNick) {
        return deliverService.getTotalPageFindAllOrderByExpId(userNick);
    }
    //给用户查物流
    @RequestMapping("/getOrderStat")
    @ResponseBody
    public Result<List<DeliverInfo>> findDeliverInfoForUserByOrderId(String orderId) {
        return deliverService.findDeliverInfoByOrderId(orderId);
    }
    //通过ID查询配送信息
    @RequestMapping("/findDeliverById")
    @ResponseBody
    public Result<Deliver> findDeliverById(String deliverId) {
        return deliverService.findDeliverById(deliverId);
    }
    //查询未完成订单
    @RequestMapping("/findUndoneOrderByStationName")
    @ResponseBody
    public Result<List<Deliver>> findUndoneDeliver(String stationName) {
        return deliverService.findUndoneDeliver(stationName);
    }
}
