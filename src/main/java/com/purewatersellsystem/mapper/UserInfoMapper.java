package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserInfoMapper {
    @Select("select * from userinfo where userId = #{userId}")
    List<UserInfo> findUserInfoById(@Param("userId") String id);

    //添加收货地址
    @Insert("insert into userinfo values(#{userInfoId},#{userId},#{userAddr},#{userTel},#{status})")
    Integer addAddr(@Param("userInfoId") String userInfoId, @Param("userId") String userId, @Param("userAddr") String userAddr, @Param("userTel") String userTel, @Param("status") String status);

    //修改收货地址
    @Update("update userinfo set userAddr = #{userAddr} , userTel = #{userTel} where userInfoId = #{userInfoId}")
    Integer updateAddr(@Param("userInfoId") String userInfoId, @Param("userTel") String userTel, @Param("userAddr") String userAddr);

    //通过userinfo查找信息
    @Select("select * from userinfo where userinfoid = #{userInfoId}")
    UserInfo findByUserInfoId(@Param("userInfoId") String userInfoId);

    //收货地址的删除
    @Delete("delete from userinfo where userinfoid = #{userInfoId}")
    Integer deleteUserInfo(@Param("userInfoId") String userInfoId);

    //取消默认
    @Update("update userinfo set status = 0 where userid=#{userId} and status = 1")
    Integer calcelDefault(@Param("userId") String userId);
    //设为默认
    @Update("update userinfo set status = 1 where userinfoid=#{userInfoId}")
    Integer setDefault(@Param("userInfoId") String userInfoId);
}
