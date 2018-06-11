package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.*;
import com.purewatersellsystem.mapper.*;
import com.purewatersellsystem.service.EvaluateService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Resource
    private EvaluateMapper evaluateMapper;
    @Resource
    private DeliverMapper deliverMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ExpresserMapper expresserMapper;
    @Override
    public Result newEvaluate(String orderId, String orderEvaluate, String deliverEvaluate) {
        evaluateMapper.newEvaluate(MyUtil.createId(),orderId,deliverMapper.findDeliverByOrderId(orderId).getDeliverId(),orderEvaluate,deliverEvaluate);
        orderMapper.evaluatedOrder(orderId);
        Result r = new Result();
        r.setMsg("感谢您的评价");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result<List<Evaluate>> findAllEvaluate(String page) {
        Result<List<Evaluate>> r = new Result<>();
        r.setData(evaluateMapper.findAll((Integer.parseInt(page)-1)*15));
        r.setMsg("查找成功");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result<String> getTotalPageFindAll() {
        Result<String> r = new Result<>();
        r.setMsg("查找成功");
        r.setStatus(1);
        r.setData(evaluateMapper.getTotalPageForFindAll());
        return r;
    }

    @Override
    public Result replyEvaluate(String orderEvaluate, String deliverEvaluate, String orderId) {
        orderEvaluate = "-"+orderEvaluate;
        deliverEvaluate = "-"+deliverEvaluate;
        evaluateMapper.replyEvaluate(orderEvaluate,deliverEvaluate,orderId);
        Result r = new Result();
        r.setMsg("回复成功");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result<List<ProductEvaluate>> findEvaluateByProduct(String productName) {
        List<ProductEvaluate> l = evaluateMapper.findEvaluateByProduct(productMapper.findProductByName(productName).getProductId());
        for (int i = 0; i < l.size(); i++) {
            ProductEvaluate p = l.get(i);
            String userName = userMapper.findUserById(p.getUserId()).getUserNick();
            p.setUserId(userName);
        }
        Result<List<ProductEvaluate>> r = new Result<>();
        r.setStatus(1);
        r.setMsg("查找成功");
        r.setData(l);
        return r;
    }

    @Override
    public Result<List<Deliver>> findDeliverByExpName(String expresserName, String start, String end,String page) {
        Expresser e = expresserMapper.findExpresserByNick(expresserName);
        Result<List<Deliver>> r = new Result<>();
        r.setMsg("查找成功");
        r.setStatus(1);
        r.setData(evaluateMapper.findDeliverByExpName(e.getExpresserName(),start,end,e.getExpresserId(),(Integer.parseInt(page)-1)*15));
        return r;
    }

    @Override
    public Result<String> getPageForFindDeliverByExpName(String expresserName, String start, String end) {
        Expresser e = expresserMapper.findExpresserByNick(expresserName);
        Result<String> r = new Result<>();
        r.setMsg("查找成功");
        r.setStatus(1);
        r.setData(evaluateMapper.getPageForFindDeliverByExpName(e.getExpresserName(),start,end,e.getExpresserId()));
        return r;
    }
}
