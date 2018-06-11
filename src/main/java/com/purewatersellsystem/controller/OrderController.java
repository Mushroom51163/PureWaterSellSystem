package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Expresser;
import com.purewatersellsystem.entity.Order;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
//订单
@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    //添加新订单
    @RequestMapping("/addOrder")
    @ResponseBody
    public Result addOrder(String userNick, String itemName, String count,String total,String userAddr, Integer isPaied, String stationName, String appTime, String payMethod) {
        System.out.println("controller的total："+total);
        return orderService.addOrder(userNick, itemName, count,total,userAddr, isPaied, stationName, appTime, payMethod);
    }

    //获取可用预约时间
    @RequestMapping("/getAppTime")
    @ResponseBody
    public Result<String[]> getAppTime() {
        return orderService.getAppTime();
    }
    //查找用户的所有订单
    @RequestMapping("/getAllOrder")
    @ResponseBody
    public Result<List<Order>> findAllOrder(String userNick,String page){
        return orderService.findAllOrderForUser(userNick,page);
    }
    @RequestMapping("/getTotalPageForFindAllByUserId")
    @ResponseBody
    public Result<String> getTotalPageForFindAllByUserId(String userNick) {
        return orderService.getTotalPageForFindAllByUserId(userNick);
    }
    //跳转到用户的我的订单页面
    @RequestMapping("/goToMyOrder")
    public String goToMyOrder(){
        return "myorder";
    }
    //查找派送中订单的派送员信息
    @RequestMapping("/findExpInfoForUser")
    @ResponseBody
    public Result<Expresser> findExpByCurrentOrderId(String orderId) {
        return orderService.findExpByCurrentOrderId(orderId);
    }
    @RequestMapping("/findOrderById")
    @ResponseBody
    public Result<Order> findOrderById(String orderId){
        return orderService.findOrderById(orderId);
    }

    @RequestMapping("/deleteOrderById")
    @ResponseBody
    public Result deleteOrder(String orderId){
        return orderService.deleteOrder(orderId);
    }

    @RequestMapping("/findOrderByUserNameAndTime")
    @ResponseBody
    public Result<List<Order>> findOrderByUserIdAndTime(String userNick, String productName, String start, String end,String page) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df1 = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        try {
            start = df1.format(df.parse(start).getTime());
            end = df1.format(df.parse(end).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return orderService.findOrderByUserIdAndTime(userNick,productName,start,end,page);
    }
    @RequestMapping("/getTotalPageForFindOrderByUserIdAndTime")
    @ResponseBody
    public Result<String> getTotalPageForFindOrderByUserIdAndTime(String userNick, String productName, String start, String end) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df1 = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        try {
            start = df1.format(df.parse(start).getTime());
            end = df1.format(df.parse(end).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return orderService.getTotalPageForFindOrderByUserIdAndTime(userNick,productName,start,end);
    }
}
