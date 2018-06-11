package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Expresser;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.service.ExpresserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ExpresserController {
    @Resource
    private ExpresserService expresserService;
    //通过名字查找派送员
    @RequestMapping("/findExpresserByName")
    @ResponseBody
    public Result<Expresser> findExpresserByName(String expNick){
        return expresserService.findExpresserByNick(expNick);
    }
    //查找水站所属派送员
    @RequestMapping("/findExpressersByStation")
    @ResponseBody
    public Result<List<Expresser>> findExpressersByStation(String expresserStation) {
        return expresserService.findExpressersByStation(expresserStation);
    }
    //通过ID删除派送员
    @RequestMapping("/delExpById")
    @ResponseBody
    public Result delExpById(String expId) {
        return expresserService.delExpById(expId);
    }
    //添加派送员
    @RequestMapping("/addExp")
    @ResponseBody
    public Result addExp(String name, String tel, String pwd,String station){
        return expresserService.addExpresser(name,tel,pwd,station);
    }
    //通过id查找派送员
    @RequestMapping("/findExpById")
    @ResponseBody
    public Result findExpById(String id){
        return expresserService.findExpById(id);
    }
    //修改派送员
    @RequestMapping("/modExpById")
    @ResponseBody
    public Result modExp(String expresserName, String expresserTel, String expresserPwd, String expresserId) {
        return expresserService.modExp(expresserName,expresserTel,expresserPwd,expresserId);
    }
    //查找空闲派送员
    @RequestMapping("/getFreeExpresserByStationName")
    @ResponseBody
    public Result<List<Expresser>> getFreeExpresserByStationName(String stationName) {
        return expresserService.getFreeExpresserByStationName(stationName);
    }
    //派送员取消订单
    @RequestMapping("/delOrderByExp")
    @ResponseBody
    public Result deleteDeliverByOrderId(String orderId,String userNick) {
        return expresserService.deleteDeliverByOrderId(orderId,userNick);
    }
    //查找所有派送员
    @RequestMapping("/expresserNameList")
    @ResponseBody
    public Result<List<Expresser>> expresserNameList(String expresserStation) {
        return expresserService.expresserNameList(expresserStation);
    }
}
