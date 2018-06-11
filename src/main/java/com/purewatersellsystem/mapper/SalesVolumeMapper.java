package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.SalesVolumeInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SalesVolumeMapper {
    @SelectProvider(type = SalesVolumeMapperProvider.class, method = "findAll")
    List<SalesVolumeInfo> findAll(@Param("stationName") String stationName, @Param("date") String date, @Param("productName") String productName,@Param("page") Integer page);

    class SalesVolumeMapperProvider {
        public String findAll(@Param("stationName") String stationName, @Param("date") String date, @Param("productName") String productName,@Param("page") Integer page) {
            String sql = "SELECT o.orderStatus,o.orderId,u.userNick,o.orderAddr,o.orderTime,o.appointmentTime,m.productName,o.productCount,o.stationName,o.payMethod " + "FROM `order` o,`user` u ,`market` m " +
                    "where o.isPaied='1'";
            if(!stationName.equals("总站")){
                sql +=  " and o.stationName= '" + stationName + "'  and o.userId=u.userId and m.productId=o.productId and o.orderTime like '" + date +"'";
            }else{
                sql +=  " and o.userId=u.userId and m.productId=o.productId and o.orderTime like '" + date +"'";
            }
            if (!productName.equals("请选择产品类型")) {
                sql += " and m.productName = '" + productName+"'";
            }
            sql += " order by o.ordertime desc limit "+page+",15";
            return sql;
        }

    }
    @SelectProvider(type = Provider.class, method = "findSal")
    String findByData(@Param("stationName") String stationName,@Param("data") String data,@Param("productId") String productId);
    class Provider{
        public String findSal(@Param("stationName") String stationName,@Param("data") String data,@Param("productId") String productId){
            String sql = "select sum(productCount) from (SELECT * FROM `order` o where ";
            if(data.equals("第一季度")){
                sql += " o.doneTime like '%-1-%' or o.doneTime like '%-2-%' or o.doneTime like '%-3-%'";
            }else if(data.equals("第二季度")){
                sql += " o.doneTime like '%-4-%' or o.doneTime like '%-5-%' or o.doneTime like '%-6-%'";
            }
            else if(data.equals("第三季度")){
                sql += " o.doneTime like '%-7-%' or o.doneTime like '%-8-%' or o.doneTime like '%-9-%'";
            }
            else if(data.equals("第四季度")){
                sql += " o.doneTime like '%-10-%' or o.doneTime like '%-11-%' or o.doneTime like '%-12-%'";
            }else{
                sql +=" o.doneTime like '"+data+"'";
            }

            if(!stationName.equals("总站")){
                sql+=") a where a.stationName='";
                sql += stationName+"' and a.isPaied='1'";
            }else{
                sql += ") a where a.isPaied='1'";
            }
            if(!productId.equals("-1")){
                sql += " and a.productId = '"+productId+"'";
            }
            return sql;
        }
    }
    @SelectProvider(type = findBetweenDate.class, method = "findAll")
    List<SalesVolumeInfo> findBetweenDate(@Param("stationName") String stationName, @Param("start") String start, @Param("end") String end,@Param("productName") String productName,@Param("page") Integer page);

    class findBetweenDate {
        public String findAll(@Param("stationName") String stationName, @Param("start") String start, @Param("end") String end, @Param("productName") String productName,@Param("page") Integer page) {
            String sql = "SELECT o.orderStatus,o.orderId,u.userNick,o.orderAddr,o.orderTime,o.appointmentTime,m.productName,o.productCount,o.stationName,o.payMethod " + "FROM `order` o,`user` u ,`market` m " +
                    "where o.isPaied='1'";
            if(!stationName.equals("总站")){
                sql +=  " and o.stationName= '" + stationName + "'  and o.userId=u.userId and m.productId=o.productId and o.orderTime between '"+start+"' and '"+end+"'";
            }else{
                sql +=  " and o.userId=u.userId and m.productId=o.productId and o.orderTime between '"+start+"' and '"+end+"'";
            }
            if (!productName.equals("请选择产品类型")) {
                sql += " and m.productName = '" + productName+"'";
            }
            sql += " order by o.ordertime desc limit "+page+",15";
            return sql;
        }

    }

    @SelectProvider(type = getTotalPageForFindBetweenDate.class, method = "findAll")
    String getTotalPageForFindBetweenDate(@Param("stationName") String stationName, @Param("start") String start, @Param("end") String end,@Param("productName") String productName);

    class getTotalPageForFindBetweenDate {
        public String findAll(@Param("stationName") String stationName, @Param("start") String start, @Param("end") String end, @Param("productName") String productName) {
            String sql = "SELECT ceil(count(*)/15) " + "FROM `order` o,`user` u ,`market` m " +
                    "where o.isPaied='1'";
            if(!stationName.equals("总站")){
                sql +=  " and o.stationName= '" + stationName + "'  and o.userId=u.userId and m.productId=o.productId and o.orderTime between '"+start+"' and '"+end+"'";
            }else{
                sql +=  " and o.userId=u.userId and m.productId=o.productId and o.orderTime between '"+start+"' and '"+end+"'";
            }
            if (!productName.equals("请选择产品类型")) {
                sql += " and m.productName = '" + productName+"'";
            }
            sql += " order by o.ordertime desc";
            return sql;
        }

    }

}
