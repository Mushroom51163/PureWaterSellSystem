package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.Administrator;
import com.purewatersellsystem.entity.Expresser;
import com.purewatersellsystem.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserMapper {
    //通过userNick查找用户
    @Select("select * from user where userNick = #{userNick}")
    User findUserByNick(@Param("userNick") String userNick);

    //permission  1=管理员  2=用户  3=派送员
    //添加用户
    @Insert("insert into user values(#{userId},#{userNick},#{userPwd})")
    Integer userRegister(@Param("userId") String userId, @Param("userNick") String userNick, @Param("userPwd") String userPwd);

    //修改密码
    @Update("update user set userPwd = #{userPwd} where userNick = #{userNick}")
    Integer changePassword(@Param("userNick") String userNick, @Param("userPwd") String userPwd);

    //查找所有用户
    @Select("select * from user")
    List<User> findAllUser();

    @Delete("delete from user where userId = #{userId}")
    Integer delUserById(@Param("userId") String userId);

    @Select("select * from user where userId = #{userId}")
    User findUserById(@Param("userId") String userid);


}