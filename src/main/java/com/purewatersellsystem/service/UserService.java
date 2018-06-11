package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.User;

import java.util.List;

public interface UserService {


    Result changePwd(String userNick, String userPwd);

    Result<Object> checkLogin(String nickName, String userPwd, String userType);

    Result register(String userId, String userNick, String userPwd);

    Result<List<User>> findAllUser();

    Result delUserById(String userId);
}
