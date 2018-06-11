package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.*;
import com.purewatersellsystem.mapper.*;
import com.purewatersellsystem.service.DeliverService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeliverServiceImpl implements DeliverService {
    @Resource
    private DeliverMapper deliverMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private ExpresserMapper expresserMapper;
    @Resource
    private InventoryMapper inventoryMapper;
    @Resource
    private WaterStationMapper waterStationMapper;

    @Override
    public Result<List<List<DeliverInfo>>> getDeliverInfo(String expName) {
        Result<List<List<DeliverInfo>>> r = new Result<>();
        List<Deliver> d = deliverMapper.findDeliverByExpId(expresserMapper.findExpresserByNick(expName).getExpresserId());
        List<DeliverInfo> l = new ArrayList<>();
        List<List<DeliverInfo>> result = new ArrayList<>();
        for(int i = 0;i<d.size();i++){
            l.clear();
            String[] stat = d.get(i).getDelivereStatus().split("-");
            String[] time = d.get(i).getAcceptTime().split("=");
            for (int j = 0; j < stat.length; j++) {
                l.add(new DeliverInfo(stat[j],time[j]));
            }
            result.add(l);
        }
        r.setMsg("查找成功");
        r.setStatus(1);
        r.setData(result);
        return r;
    }

    @Override
    public Result updateStat(String exp,String stat, String orderId) {
        deliverMapper.updateDeliverStatus(stat+"-",MyUtil.getDate()+"=",orderId);
        Result r = new Result();
        r.setStatus(1);
        r.setMsg("更新状态成功");
        if(stat.equals("用户已签收")){
            deliverMapper.deliverDone(orderId);
            orderMapper.goToDoneOrder(MyUtil.getDate(),"1",orderId);
            Order o = orderMapper.findOrderById(orderId);
            inventoryMapper.sell(waterStationMapper.findStationByName(o.getStationName()).getStationId(),o.getProductId());
            Expresser e = expresserMapper.findExpresserByNick(exp);
            String orders = e.getOrderId();
            if(orders.contains(orderId+",")){
                orders = orders.replaceAll(orderId+",","");
            }
            if(orders.trim().equals("")){
                expresserMapper.changeToFree(exp);
            }else{
                expresserMapper.updateOrderId(exp,orders);
            }
            orderMapper.pay(orderId);
        }
        return r;
    }

    @Override
    public Result newDeliver(String expNick, String orderId) {
        String deliverId = MyUtil.createId();
        String status = "派送员已接单，正在配货-";
        String payMethod = orderMapper.findOrderById(orderId).getPayMethod();
        String expId = expresserMapper.findExpresserByNick(expNick).getExpresserId();
        String time = MyUtil.getDate()+"=";
        String isDone = "0";
        Integer i = deliverMapper.newDeliver(deliverId, orderId, status, payMethod, expId, time, isDone);
        Result r = new Result();
        if (i == 1) {
            r.setStatus(1);
            r.setMsg("接单成功，快去配送吧！");
        }
        expresserMapper.changeToBusy(expNick,orderId+",");
        return r;
    }

    @Override
    public Result<List<Order>> findAllOrderForExp(String expName,String page) {
        String expId = expresserMapper.findExpresserByNick(expName).getExpresserId();
        List<String> l = deliverMapper.findAllOrderByExpId(expId,(Integer.parseInt(page)-1)*15);
        List<Order> o = new ArrayList<>();
        for(int i = 0;i<l.size();i++){
            o.add(orderMapper.findOrderById(l.get(i)));
        }
        Result<List<Order>> r = new Result<>();
        r.setData(o);
        r.setMsg("查找成功");
        r.setStatus(1);
        if(o.size()==0){
            r.setMsg("未找到已完成订单");
        }
        return r;
    }

    @Override
    public Result<String> getTotalPageFindAllOrderByExpId(String expName) {
        String expId = expresserMapper.findExpresserByNick(expName).getExpresserId();
        Result<String> r = new Result<>();
        r.setData(deliverMapper.getTotalPageFindAllOrderByExpId(expId));
        r.setStatus(1);
        r.setMsg("查找成功");
        return r;
    }

    @Override
    public Result<List<DeliverInfo>> findDeliverInfoByOrderId(String orderId) {
        Result<List<DeliverInfo>> r = new Result<>();
        Deliver d = deliverMapper.findDeliverByOrderId(orderId);
        if(d==null){
            r.setMsg("查找失败");
            r.setStatus(0);
            r.setData(null);
        }else{
            String[] stat = d.getDelivereStatus().split("-");
            String[] time = d.getAcceptTime().split("=");
            List<DeliverInfo> l = new ArrayList<>();
            for (int i = 0; i < stat.length; i++) {
                l.add(new DeliverInfo(stat[i],time[i]));
            }
            r.setMsg("查找成功");
            r.setStatus(1);
            r.setData(l);
        }

        return r;
    }

    @Override
    public Result<Deliver> findDeliverById(String deliverId) {
        Deliver d = deliverMapper.findDeliverById(deliverId);
        d.setExpresserId(expresserMapper.findExpById(d.getExpresserId()).getExpresserName());
        Result<Deliver> r = new Result<>();
        r.setData(d);
        r.setMsg("查找成功");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result<List<Deliver>> findUndoneDeliver(String stationName) {
        Result<List<Deliver>> r = new Result<>();
        r.setData(deliverMapper.findUndoneDeliver(stationName));
        r.setMsg("查找成功");
        r.setStatus(1);
        return r;
    }
}
