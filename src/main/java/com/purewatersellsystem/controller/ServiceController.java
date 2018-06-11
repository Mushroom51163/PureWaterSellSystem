package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.service.ServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
//用户提意见和建议
@Controller
public class ServiceController {
    @Resource
    private ServiceService serviceService;
    //提意见和建议
    @RequestMapping("/newService")
    @ResponseBody
    public Result newService(String userNick, String advice, String complain){
        return serviceService.newService(userNick,advice,complain);
    }
}
