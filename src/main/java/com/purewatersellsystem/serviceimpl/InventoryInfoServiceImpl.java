package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.InventoryInfo;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.mapper.InventoryInfoMapper;
import com.purewatersellsystem.service.InventoryInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InventoryInfoServiceImpl implements InventoryInfoService {
    @Resource
    private InventoryInfoMapper inventoryInfoMapper;

    @Override
    public Result<List<InventoryInfo>> findAll() {
        Result<List<InventoryInfo>> r = new Result<>();
        List<InventoryInfo> l = inventoryInfoMapper.findAllInv();
        r.setData(l);
        r.setMsg("查找库存信息成功");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result<List<InventoryInfo>> findInvByStationName(String stationName) {
        Result<List<InventoryInfo>> r = new Result<>();
        List<InventoryInfo> l = inventoryInfoMapper.findInvByStationName(stationName);
        r.setData(l);
        r.setMsg("查找库存信息成功");
        r.setStatus(1);
        return r;
    }
}
