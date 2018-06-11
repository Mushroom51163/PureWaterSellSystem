package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.Administrator;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdministratorMapper {
    //通过userNick查找管理员
    @Select("select * from administrator where adminName = #{adminName}")
    Administrator findAdminByNick(@Param("adminName") String userNick);
}
