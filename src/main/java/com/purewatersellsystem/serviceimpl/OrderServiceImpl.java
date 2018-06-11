package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.Expresser;
import com.purewatersellsystem.entity.Order;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.mapper.*;
import com.purewatersellsystem.service.OrderService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private UserMapper usermapper;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ExpresserMapper expresserMapper;

    @Resource
    private DeliverMapper deliverMapper;

    @Override
    public Result<List<Order>> findAllOrderForUser(String userNick,String page) {
        String userId = usermapper.findUserByNick(userNick).getUserId();
        Result<List<Order>> r = new Result<>();
        r.setStatus(1);
        r.setMsg("查找成功");
        r.setData(orderMapper.findAllByUserId(userId,(Integer.parseInt(page)-1)*15));
        return r;
    }

    @Override
    public Result<String> getTotalPageForFindAllByUserId(String userNick) {
        String userId = usermapper.findUserByNick(userNick).getUserId();
        Result<String> r = new Result<>();
        r.setStatus(1);
        r.setMsg("查找成功");
        r.setData(orderMapper.getTotalPageForFindAllByUserId(userId));
        return r;
    }

    @Override
    public Result addOrder(String userNick, String itemName,String count,String total, String userAddr, Integer isPaied, String stationName, String appTime, String payMethod) {
        String orderId = MyUtil.createId();
        String userId = usermapper.findUserByNick(userNick).getUserId();
        String orderTime = MyUtil.getDate();
        String productId = productMapper.findProductByName(itemName).getProductId();
        System.out.println("Service的total："+total);
        Integer i = orderMapper.addOrder(orderId, userId, userAddr, orderTime, appTime, productId, count,total,isPaied, stationName, payMethod, null, "0");
        Result r = new Result();
        if (i == 1) {
            r.setStatus(1);
            r.setMsg("订单添加成功");
        } else {
            r.setStatus(0);
            r.setMsg("订单添加失败");
        }
        return r;
    }

    @Override
    public Result<String[]> getAppTime() {
        Result<String[]> r = new Result<>();
        r.setMsg("获取预约时间成功");
        r.setStatus(1);
        r.setData(MyUtil.getAppDate());
        return r;
    }

    @Override
    public Result<Expresser> findExpByCurrentOrderId(String orderId) {
        Result<Expresser> r = new Result<>();
        r.setData(expresserMapper.findExpById(deliverMapper.findDeliverByOrderId(orderId).getExpresserId()));
        r.setStatus(1);
        r.setMsg("查找成功");
        return r;
    }

    @Override
    public Result<Order> findOrderById(String orderId) {
        Order o = orderMapper.findOrderById(orderId);
        o.setUserId(usermapper.findUserById(o.getUserId()).getUserNick());
        o.setProductId(productMapper.findProductById(o.getProductId()).getProductName());
        Result<Order> r = new Result<>();
        r.setStatus(1);
        r.setMsg("查找成功");
        r.setData(o);
        return r;
    }
    @Override
    public Result deleteOrder(String orderId) {
        String canOrNot = orderMapper.OrdercanBeDeleted(orderId);
        Result r = new Result();
        if(canOrNot.equals("0")){
            r.setStatus(0);
            r.setMsg("该订单已经被接单，无法取消，如果确实不需要，请拨打派送员电话人工取消订单。");
        }else{
            orderMapper.DeleteOrderById(orderId);
            r.setStatus(1);
            r.setMsg("取消成功");
        }
        return r;
    }

    @Override
    public Result<List<Order>> findOrderByUserIdAndTime(String userNick, String productName, String start, String end,String page) {
        if(productName.equals("请选择产品类型")){
            productName = "%";
        }
        String userId = usermapper.findUserByNick(userNick).getUserId();
        Result<List<Order>> r = new Result<>();
        r.setMsg("查找成功");
        r.setStatus(1);
        r.setData(orderMapper.findOrderByUserIdAndTime(userId,productName,start,end,(Integer.parseInt(page)-1)*15));
        return r;
    }

    @Override
    public Result<String> getTotalPageForFindOrderByUserIdAndTime(String userNick, String productName, String start, String end) {
        if(productName.equals("请选择产品类型")){
            productName = "%";
        }
        String userId = usermapper.findUserByNick(userNick).getUserId();
        Result<String> r = new Result<>();
        r.setStatus(1);
        r.setMsg("查找成功");
        r.setData(orderMapper.getTotalPageForFindOrderByUserIdAndTime(userId,productName,start,end));
        return r;
    }
}
