package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.Expresser;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.mapper.ExpresserMapper;
import com.purewatersellsystem.mapper.OrderMapper;
import com.purewatersellsystem.service.ExpresserService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExpresserServiceImpl implements ExpresserService {
    @Resource
    private ExpresserMapper expresserMapper;
    @Resource
    private OrderMapper orderMapper;
    @Override
    public Result<Expresser> findExpresserByNick(String expNick) {
        Expresser e = expresserMapper.findExpresserByNick(expNick);
        Result<Expresser> r = new Result<>();
        r.setStatus(1);
        r.setMsg("查找成功");
        r.setData(e);
        return r;
    }

    @Override
    public Result<List<Expresser>> findExpressersByStation(String expresserStation) {
        Result<List<Expresser>> r = new Result<>();
        r.setMsg("查找成功");
        r.setStatus(1);
        r.setData(expresserMapper.findExpressersByStation(expresserStation));
        return r;
    }

    @Override
    public Result delExpById(String expId) {
        expresserMapper.delExpById(expId);
        Result r = new Result();
        r.setStatus(1);
        r.setMsg("删除成功");
        return r;
    }

    @Override
    public Result addExpresser(String name, String tel, String pwd,String station) {
        Integer i = null;
        try{
            i = expresserMapper.addExpresser(new Expresser(MyUtil.createId(),name,station,tel,1,"",0,MyUtil.md5(pwd)));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Result r = new Result();
            if(i!=null){
                r.setMsg("添加成功");
                r.setStatus(1);
            }else{
                r.setMsg("该派送员已存在");
                r.setStatus(2);
            }
            return r;
        }


    }

    @Override
    public Result<Expresser> findExpById(String id) {
        Result<Expresser> r = new Result<>();
        r.setStatus(1);
        r.setMsg("查找成功");
        r.setData(expresserMapper.findExpById(id));
        return r;
    }

    @Override
    public Result modExp(String expresserName, String expresserTel, String expresserPwd, String expresserId) {
        Result<Expresser> r = new Result<>();
        r.setStatus(1);
        r.setMsg("修改成功");
        expresserMapper.modExp(expresserName,expresserTel,MyUtil.md5(expresserPwd),expresserId);
        return r;
    }

    @Override
    public Result<List<Expresser>> getFreeExpresserByStationName(String stationName) {
        Result<List<Expresser>> r = new Result<>();
        r.setData(expresserMapper.getFreeExpresserByStationName(stationName));
        r.setMsg("查找成功");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result deleteDeliverByOrderId(String orderId,String userNick) {
        //expresserMapper.changeToFree(userNick);
        Expresser e = expresserMapper.findExpresserByNick(userNick);
        String orders = e.getOrderId();
        if(orders.contains(orderId+",")){
            orders = orders.replaceAll(orderId+",","");
        }
        if(orders.trim().equals("")){
            expresserMapper.changeToFreeForDel(userNick);
        }else{
            expresserMapper.updateOrderIdForDel(userNick,orders);
        }
        expresserMapper.deleteDeliverByOrderId(orderId);
        orderMapper.delingOrder(orderId);
        Result r = new Result();
        r.setMsg("取消订单成功，现在可以去接新的订单了！");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result<List<Expresser>> expresserNameList(String expresserStation) {
        Result<List<Expresser>> r = new Result<>();
        r.setData(expresserMapper.expresserNameList(expresserStation));
        r.setStatus(1);
        r.setMsg("查找成功");
        return r;
    }
}
