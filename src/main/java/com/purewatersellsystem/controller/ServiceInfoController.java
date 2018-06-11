package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.ServiceInfo;
import com.purewatersellsystem.service.ServiceInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ServiceInfoController {

    @Resource
    private ServiceInfoService serviceInfoService;

    @RequestMapping("/goToService")
    public String goToService(){
        return "service";
    }

    @RequestMapping("/findAllService")
    @ResponseBody
    public Result<List<ServiceInfo>> findAllService(String page){
        return serviceInfoService.findAllService(page);
    }
    @RequestMapping("/getTotalPageForFindAll")
    @ResponseBody
    public Result<String> getTotalPageForFindAll() {
        return serviceInfoService.getTotalPageForFindAll();
    }
}
