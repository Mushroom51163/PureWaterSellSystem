package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.InventoryInfo;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.service.InventoryInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
//库存信息
@Controller
public class InventoryInfoController {
    @Resource
    private InventoryInfoService inventoryInfoService;
    //跳转到总站库存页
    @RequestMapping("/goToFindInv")
    public String goToFindInv(){
        return "inventory";
    }
    //总站查看所有分站库存
    @RequestMapping("/findAllInventory")
    @ResponseBody
    public Result<List<InventoryInfo>> findAllInventory() {
        return inventoryInfoService.findAll();
    }

    //总站筛选分站库存
    @RequestMapping("/findInvByStationName")
    @ResponseBody
    public Result<List<InventoryInfo>> findInvByStationName(String stationName) {
        return inventoryInfoService.findInvByStationName(stationName);
    }
}
