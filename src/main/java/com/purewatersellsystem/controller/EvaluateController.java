package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Deliver;
import com.purewatersellsystem.entity.Evaluate;
import com.purewatersellsystem.entity.ProductEvaluate;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.service.EvaluateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
//评价
@Controller
public class EvaluateController {

    @Resource
    private EvaluateService evaluateService;
    //跳转到总站查看投诉页
    @RequestMapping("/goToFindEvaluate")
    public String goToFindEvaluate(){
        return "evaluate";
    }
    //总站查看所有建议和意见
    @RequestMapping("/findAllEvaluate")
    @ResponseBody
    public Result<List<Evaluate>> findAll(String page){
        return evaluateService.findAllEvaluate(page);
    }
    @RequestMapping("/getTotalPageFindAll")
    @ResponseBody
    public Result<String> getTotalPageFindAll() {
        return evaluateService.getTotalPageFindAll();
    }
    //新增产品评价
    @RequestMapping("/newEvaluate")
    @ResponseBody
    public Result newEvaluate(String orderId, String chanpin, String peisong){
        return evaluateService.newEvaluate(orderId,chanpin,peisong);
    }
    //回复产品评价
    @RequestMapping("/replyEvaluate")
    @ResponseBody
    public Result replyEvaluate(String orderId, String chanpin, String peisong){
        return evaluateService.replyEvaluate(chanpin,peisong,orderId);
    }
    @RequestMapping("/findEvaluate")
    @ResponseBody
    //列出评价
    public Result<List<ProductEvaluate>> findEvaluateByProduct(String productName) {
        return evaluateService.findEvaluateByProduct(productName);
    }
    //查派送员工作量
    @RequestMapping("/findDeliverByExpName")
    @ResponseBody
    public Result<List<Deliver>> findDeliverByExpName(String expresserName, String start, String end,String page) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df1 = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        try {
            start = df1.format(df.parse(start).getTime());
            end = df1.format(df.parse(end).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return evaluateService.findDeliverByExpName(expresserName, start, end,page);
    }

    @RequestMapping("/getPageForFindDeliverByExpName")
    @ResponseBody
    public Result<String> getPageForFindDeliverByExpName(String expresserName, String start, String end) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df1 = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        try {
            start = df1.format(df.parse(start).getTime());
            end = df1.format(df.parse(end).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return evaluateService.getPageForFindDeliverByExpName(expresserName, start, end);
    }
}
