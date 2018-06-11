package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    Result<List<UserInfo>> getUserInfo(String userId);

    // 改地址
    Result changeAddr(String userInfoId, String userTel, String userAddr);

    //添加地址
    Result addAddr(String userId, String userAddr, String userTel, String status);

    Result<UserInfo> findByUserInfoId(String userInfoId);

    Result deleteUserInfoById(String userInfoId);

    Result setAsDefaultAddr(String userName,String userInfoId);
}
