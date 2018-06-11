package com.purewatersellsystem.test;

import com.purewatersellsystem.controller.UserController;
import com.purewatersellsystem.entity.*;
import com.purewatersellsystem.mapper.*;
import com.purewatersellsystem.service.DeliverService;
import com.purewatersellsystem.service.OrderInfoForExpService;
import com.purewatersellsystem.service.SalesVolumeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private DeliverService deliverService;
    @Resource
    private ExpresserMapper expresserMapper;
    //03973924
    @Test
    public void test1(){
        Expresser e = expresserMapper.findExpresserByNick("zhl");
        String orders = e.getOrderId();
        if(orders.contains("test1,")){
            orders = orders.replaceAll("test1,","");
            orders = orders.replaceAll("test2,","");
            orders = orders.replaceAll("test3,","");
        }
        System.out.println(orders);
    }
}
