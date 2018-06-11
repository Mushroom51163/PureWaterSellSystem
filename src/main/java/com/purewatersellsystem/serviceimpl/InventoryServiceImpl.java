package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.mapper.InventoryMapper;
import com.purewatersellsystem.mapper.ProductMapper;
import com.purewatersellsystem.mapper.WaterStationMapper;
import com.purewatersellsystem.service.InventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Resource
    private InventoryMapper inventoryMapper;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private WaterStationMapper waterStationMapper;
    @Override
    public Result add(String stationName, String productName, String quantity) {
        String stationId = waterStationMapper.findStationByName(stationName).getStationId();
        String productId = productMapper.findProductByName(productName).getProductId();
        inventoryMapper.add(stationId,productId,Integer.parseInt(quantity));
        Result r = new Result();
        r.setStatus(1);
        r.setMsg("补货成功");
        return r;
    }

    @Override
    public Result<String> findInventory(String stationName, String productName) {
        Result<String> r = new Result<>();
        r.setMsg("查找成功");
        r.setStatus(1);
        r.setData(inventoryMapper.findInventory(stationName,productName));
        return r;
    }
}
