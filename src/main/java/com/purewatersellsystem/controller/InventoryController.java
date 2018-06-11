package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
//库存
@Controller
public class InventoryController {

    @Resource
    private InventoryService inventoryService;
    //补货
    @RequestMapping("/addInventory")
    @ResponseBody
    public Result addInventory(String stationName, String productName, String number){
        return inventoryService.add(stationName,productName,number);
    }
    @RequestMapping("/findInventory")
    @ResponseBody
    public Result<String> findInventory(String stationName, String productName) {
        return inventoryService.findInventory(stationName,productName);
    }

    @RequestMapping("/findInventoryForBranch")
    public String findInventoryForBranch(){
        return "inventoryForBranch";
    }
}
