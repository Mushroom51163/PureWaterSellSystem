package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.mapper.ServiceMapper;
import com.purewatersellsystem.mapper.UserMapper;
import com.purewatersellsystem.service.ServiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ServiceServiceImpl implements ServiceService{
    @Resource
    private ServiceMapper serviceMapper;
    @Resource
    private UserMapper userMapper;
    @Override
    public Result newService(String userNick, String advice, String complain) {
        String userId = userMapper.findUserByNick(userNick).getUserId();
        serviceMapper.newService(userId,advice,complain);
        Result r = new Result();
        r.setMsg("感谢您提出的宝贵意见和建议，我们会不断改进我们的服务，谢谢！");
        r.setStatus(1);
        return r;
    }
}
