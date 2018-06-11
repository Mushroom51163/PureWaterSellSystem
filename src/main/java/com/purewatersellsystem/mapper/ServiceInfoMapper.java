package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.ServiceInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ServiceInfoMapper {
    @Select("select u.userNick,s.Advice,s.Complain from user u ,service s where u.userId = s.userId limit #{page},15")
    List<ServiceInfo> findAll(@Param("page") Integer page);
    @Select("select ceil(count(*)/15) from user u ,service s where u.userId = s.userId")
    String getTotalPageForFindAll();

}
