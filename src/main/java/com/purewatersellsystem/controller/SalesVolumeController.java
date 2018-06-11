package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.SalesVolumeInfo;
import com.purewatersellsystem.service.SalesVolumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
//销量
@Controller
public class SalesVolumeController {

    @Resource
    private SalesVolumeService salesVolumeService;
    //跳转到销量页面
    @RequestMapping("/goToSalesVolume")
    public String goToSalesVolume(){
        return "salesvolume";
    }
    //查找所有水站销量
    @RequestMapping("/findAllSalesVolume")
    @ResponseBody
    public Result<String> findAllSalesVolume(String stationName, String data, String productName){
        return salesVolumeService.findAllSalesVolume(stationName, data, productName);
    }
    //查找特定时间段的销量
    @RequestMapping("/findSalesVolumeByData")
    @ResponseBody
    public Result<List> findSalesVolumeByData(String data, String productName) {
        return salesVolumeService.findSalesVolumeByData(data,productName);
    }
    //查找分站水站销量
    @RequestMapping("/findAllSalesVolumeForBranch")
    @ResponseBody
    public Result<List<SalesVolumeInfo>> findAllSalesVolume(String stationName, String year, String month, String productName,String page){
        return salesVolumeService.findAllSalesVolumeForBranch(stationName, year, month, productName,page);
    }
    @RequestMapping("/findBetweenDate")
    @ResponseBody
    public Result<List<SalesVolumeInfo>> findBetweenDate(String stationName, String start, String end, String productName,String page) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df1 = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        try {
            start = df1.format(df.parse(start).getTime());
            end = df1.format(df.parse(end).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return salesVolumeService.findBetweenDate(stationName,start,end,productName,page);
    }
    @RequestMapping("/getTotalPageForFindBetweenDate")
    @ResponseBody
    public Result<String> getTotalPageForFindBetweenDate(String stationName, String start, String end, String productName) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df1 = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        try {
            start = df1.format(df.parse(start).getTime());
            end = df1.format(df.parse(end).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return salesVolumeService.getTotalPageForFindBetweenDate(stationName,start,end,productName);
    }

}
