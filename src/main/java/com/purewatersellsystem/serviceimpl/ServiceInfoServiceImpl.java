package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.ServiceInfo;
import com.purewatersellsystem.mapper.ServiceInfoMapper;
import com.purewatersellsystem.service.ServiceInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ServiceInfoServiceImpl implements ServiceInfoService {

    @Resource
    private ServiceInfoMapper serviceInfoMapper;
    @Override
    public Result<List<ServiceInfo>> findAllService(String page) {
        Result<List<ServiceInfo>> r = new Result<>();
        r.setStatus(1);
        r.setData(serviceInfoMapper.findAll((Integer.parseInt(page)-1)*15));
        r.setMsg("查找信息成功");
        return r;
    }

    @Override
    public Result<String> getTotalPageForFindAll() {
        Result<String> r = new Result<>();
        r.setData(serviceInfoMapper.getTotalPageForFindAll());
        r.setStatus(1);
        r.setMsg("done");
        return r;
    }
}
