package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.OrderInfoForExp;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.mapper.ExpresserMapper;
import com.purewatersellsystem.mapper.OrderInfoForExpMapper;
import com.purewatersellsystem.service.OrderInfoForExpService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
@Controller
public class OrderInfoForExpServiceimpl implements OrderInfoForExpService {

    @Resource
    private OrderInfoForExpMapper orderInfoForExpMapper;

    @Resource
    private ExpresserMapper expresserMapper;

    @Override
    public Result<List<OrderInfoForExp>> findCurrentOrderForExpByExpId(String expName) {
        Result<List<OrderInfoForExp>> r = new Result<>();
        String expId = expresserMapper.findExpresserByNick(expName).getExpresserId();
        List<OrderInfoForExp> o = orderInfoForExpMapper.findOrderInfoForExpById(expId);
        if(o == null){
            r.setMsg("当前暂无订单");
            r.setStatus(0);
        }else{
            r.setData(o);
            r.setStatus(1);
            r.setMsg("查找成功");
        }
        return r;
    }

    @Override
    public Result<List<OrderInfoForExp>> findOrderInfoForExpByExpName(String expName) {
        String stationName = expresserMapper.findExpresserByNick(expName).getExpresserStation();
        Result<List<OrderInfoForExp>> r = new Result<>();
        r.setData(orderInfoForExpMapper.findAll(stationName));
        r.setMsg("查找订单成功");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result<List<OrderInfoForExp>> findOrderInfoForStationByStationName(String stationName) {
        Result<List<OrderInfoForExp>> r = new Result<>();
        r.setData(orderInfoForExpMapper.findOrderInfoForStationByStationName(stationName));
        r.setStatus(1);
        r.setMsg("查找成功");
        return r;
    }
}