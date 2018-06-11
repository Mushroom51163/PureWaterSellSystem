package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.WaterStation;
import com.purewatersellsystem.service.WaterstationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class WaterstationController {
    @Resource
    private WaterstationService waterstationService;
    //添加水站
    @RequestMapping("/addWaterStation")
    @ResponseBody
    public Result addWaterStation(String name,String addr,String tel,String mgr){
        return waterstationService.newWaterStation(name,addr,tel,mgr);
    }
    //查找所有水站
    @ResponseBody
    @RequestMapping("/findAllWaterStation")
    public Result<List<WaterStation>> findAllWaterStation(){
        return waterstationService.findAllWaterStation();
    }
    //通过ID删除水站
    @RequestMapping("/deleteWaterStation")
    @ResponseBody
    public Result deleteWaterStationById(String stationId){
        return waterstationService.deleteWaterStation(stationId);
    }
    //通过ID查找水站
    @RequestMapping("/findStationById")
    @ResponseBody
    public Result<WaterStation> findStationById(String stationId){
        return waterstationService.findWaterStationById(stationId);
    }
    //通过ID修改水站
    @RequestMapping("/modStationById")
    @ResponseBody
    public Result<WaterStation> modStationById(String stationId, String stationName, String stationAddr, String stationTel, String stationMangr){
        return waterstationService.modWaterStationById(stationId,stationName,stationAddr, stationTel, stationMangr);
    }
}
