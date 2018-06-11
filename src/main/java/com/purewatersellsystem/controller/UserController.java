package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.User;
import com.purewatersellsystem.service.UserService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/services")
    public String services(){
        return "services";
    }

    //跳转到修改密码页面
    @RequestMapping("/pwd")
    public String goToChangePwd() {
        return "changepwd";
    }

    //修改密码
    @RequestMapping("/changePwd")
    @ResponseBody
    public Result changePwd(String userNick, String userPwd) {
        return userService.changePwd(userNick, userPwd);
    }

    //登录检查
    @RequestMapping("/checkLogin")
    @ResponseBody
    public Result<Object> userLogin(String userNick, String userPwd, String userType) {
        return userService.checkLogin(userNick, userPwd, userType);
    }

    //跳转到登录页面
    @RequestMapping("/login")
    public String goToLoginPage() {
        return "login";
    }

    //跳转到注册页面
    @RequestMapping("/register")
    public String goToRegister() {
        return "register";
    }

    //用户注册
    @RequestMapping("/userRegister")
    @ResponseBody
    public Result executeRegister(String userNick, String userPwd) {
        return userService.register(MyUtil.createId(), userNick, userPwd);
    }
    //查找所有用户
    @RequestMapping("/findAllUser")
    @ResponseBody
    public Result<List<User>> findAllUser(){
        return userService.findAllUser();
    }
    //通过ID删除用户
    @ResponseBody
    @RequestMapping("/delUserById")
    public Result delUserById(String userId){
        return userService.delUserById(userId);
    }
}
