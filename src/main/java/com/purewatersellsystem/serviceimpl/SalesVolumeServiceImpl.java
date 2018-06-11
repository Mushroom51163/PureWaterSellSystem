package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.SalesVolumeInfo;
import com.purewatersellsystem.mapper.ProductMapper;
import com.purewatersellsystem.mapper.SalesVolumeMapper;
import com.purewatersellsystem.mapper.WaterStationMapper;
import com.purewatersellsystem.service.SalesVolumeService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class SalesVolumeServiceImpl implements SalesVolumeService{

    @Resource
    private SalesVolumeMapper salesVolumeMapper;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private WaterStationMapper waterStationMapper;

    @Override
    public Result<String> findAllSalesVolume(String stationName, String data, String productName) {
        String productId = "";
        if(!productName.equals("请选择")){
            productId = productMapper.findProductByName(productName).getProductId();
        }else{
            productId = "-1";
        }
        if(data.equals("当日")){
            data = "%-%-"+MyUtil.getDate().split("-")[2].split(" ")[0]+"%";
        }
        if(data.equals("当月")){
            data = "%-"+MyUtil.getDate().split("-")[1]+"-%";
        }
        if(data.equals("当年")){
            data = MyUtil.getDate().split("-")[0]+"-%";
        }
        Result<String> r = new Result<>();
        r.setStatus(1);
        r.setMsg("查找成功");
        r.setData(salesVolumeMapper.findByData(stationName,data,productId));
        return r;
    }

    @Override
    public Result<List> findSalesVolumeByData(String data, String productName) {

        String productId = "";
        if(!productName.equals("请选择")){
            productId = productMapper.findProductByName(productName).getProductId();
        }else{
            productId = "-1";
        }
        List<String> sn = waterStationMapper.findAllWaterStationName();
        String[] stationNames = sn.toArray(new String[sn.size()]);
        StringBuffer sb = new StringBuffer();
        if(data.equals("当天")){
            data = "%-%-"+MyUtil.getDate().split("-")[2].split(" ")[0]+"%";
        }
        if(data.equals("当月")){
            data = "%-"+MyUtil.getDate().split("-")[1]+"-%";
        }
        if(data.equals("当年")){
            data = MyUtil.getDate().split("-")[0]+"-%";
        }
        for(int i = 0;i<stationNames.length;i++){
            String s = salesVolumeMapper.findByData(stationNames[i],data,productId);
            if(s==null){
                sb.append(0);
            }else{
                sb.append(s);
            }
            if(i!=stationNames.length-1){
                sb.append(",");
            }
        }
        //System.out.println(Arrays.toString(stationNames));
        //System.out.println(sb.toString());
        String[] arr = sb.toString().split(",");
        Integer[] i = new Integer[arr.length];
        for(int j = 0;j<arr.length;j++){
            i[j] = Integer.parseInt(arr[j]);
        }
        List l = new ArrayList();
        l.add(stationNames);
        l.add(i);
        Result<List> r= new Result<>();
        r.setStatus(1);
        r.setData(l);
        r.setMsg("查找成功");
        return r;
    }

    @Override
    public Result<List<SalesVolumeInfo>> findAllSalesVolumeForBranch(String stationName, String year, String month, String productName,String page) {
        String productId;
        if(!productName.equals("请选择产品类型")){
            productId = productMapper.findProductByName(productName).getProductId();
        }else{
            productId = "-1";
        }
        Result<List<SalesVolumeInfo>> r = new Result<>();
        String date = year+"-"+month+"%";
        r.setStatus(1);
        r.setMsg(salesVolumeMapper.findByData(stationName,date,productId));
        r.setData(salesVolumeMapper.findAll(stationName,date,productName,(Integer.parseInt(page)-1)*15));
        return r;
    }

    @Override
    public Result<List<SalesVolumeInfo>> findBetweenDate(String stationName, String start, String end, String productName,String page) {
        Result<List<SalesVolumeInfo>> r = new Result<>();
        r.setStatus(1);
        r.setMsg("查找成功");
        r.setData(salesVolumeMapper.findBetweenDate(stationName,start,end,productName,(Integer.parseInt(page)-1)*15));
        return r;
    }

    @Override
    public Result<String> getTotalPageForFindBetweenDate(String stationName, String start, String end, String productName) {
        Result<String> r = new Result<>();
        r.setStatus(1);
        r.setMsg("查找成功");
        r.setData(salesVolumeMapper.getTotalPageForFindBetweenDate(stationName,start,end,productName));
        return r;
    }
}
