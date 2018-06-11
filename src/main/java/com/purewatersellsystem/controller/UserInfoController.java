package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.UserInfo;
import com.purewatersellsystem.service.UserInfoService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    //通过用户名获取用户所有收货地址
    @RequestMapping("/findUserInfoByNick")
    @ResponseBody
    public Result<List<UserInfo>> getUserInfoByid(String userNick) {
        return userInfoService.getUserInfo(userNick);
    }

    //跳转到增加地址页面
    @RequestMapping("/goToAddAddr")
    public String goToAddAddr() {
        return "addAddr";
    }


    //跳转到管理地址页面
    @RequestMapping("/listaddr")
    public String goToListAddr() {
        return "listaddr";
    }

    //跳转到修改地址页面
    @RequestMapping("/changeaddr")
    public String goToChangeAddr() {
        return "changeaddr";
    }


    // 修改地址
    @RequestMapping("/chgAddr")
    @ResponseBody
    public Result chgAddr(String userInfoId, String userTel, String userAddr) {
        return userInfoService.changeAddr(userInfoId, userTel, userAddr);
    }

    //添加地址
    @RequestMapping("/addAddress")
    @ResponseBody
    public Result addAddr(String userNick, String userAddr, String userTel, String status) {
        return userInfoService.addAddr(userNick, userAddr, userTel, status);
    }

    //通过UserInfoId查找信息
    @ResponseBody
    @RequestMapping("/findUserInfoById")
    public Result<UserInfo> findUserInfo(String userInfoId) {
        return userInfoService.findByUserInfoId(userInfoId);
    }

    //通过UserInfoId删除信息
    @RequestMapping("/deleteUserInfoById")
    @ResponseBody
    public Result deleteUserInfoById(String userInfoId) {
        return userInfoService.deleteUserInfoById(userInfoId);
    }

    //通过UserInfoId将地址设为默认
    @RequestMapping("/setAsDefaultAddr")
    @ResponseBody
    public Result setAsDefaultAddr(String userName, String userInfoId) {
        return userInfoService.setAsDefaultAddr(userName,userInfoId);
    }
}
