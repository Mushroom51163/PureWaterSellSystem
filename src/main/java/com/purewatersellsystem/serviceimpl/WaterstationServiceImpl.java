package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.WaterStation;
import com.purewatersellsystem.mapper.WaterStationMapper;
import com.purewatersellsystem.service.WaterstationService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WaterstationServiceImpl implements WaterstationService{
    @Resource
    private WaterStationMapper waterStationMapper;
    @Override
    public Result newWaterStation(String stationName, String stationAddr, String stationTel, String stationMangr) {
        waterStationMapper.newWaterStation(new WaterStation(MyUtil.createId(),stationName,stationAddr,stationTel,stationMangr));
        Result r = new Result();
        r.setMsg("添加成功");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result<List<WaterStation>> findAllWaterStation() {
        Result<List<WaterStation>> r=  new Result<>();
        r.setStatus(1);
        r.setMsg("查找水站成功");
        r.setData(waterStationMapper.findAllWaterStation());
        return r;
    }

    @Override
    public Result<WaterStation> findWaterStationById(String stationId) {
        WaterStation ws = waterStationMapper.findStationById(stationId);
        Result<WaterStation> r = new Result<>();
        r.setStatus(1);
        r.setMsg("查找成功");
        r.setData(ws);
        return r;
    }

    @Override
    public Result deleteWaterStation(String stationId) {
        waterStationMapper.deleteWaterStation(stationId);
        Result r = new Result();
        r.setMsg("删除成功");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result modWaterStationById(String stationId, String stationName, String stationAddr, String stationTel, String stationMangr) {
        waterStationMapper.modWaterStation(new WaterStation(stationId,stationName,stationAddr, stationTel, stationMangr));
        Result r = new Result();
        r.setMsg("修改成功");
        r.setStatus(1);
        return r;
    }
}
