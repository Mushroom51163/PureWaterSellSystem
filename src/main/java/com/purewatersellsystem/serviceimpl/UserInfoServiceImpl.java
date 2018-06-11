package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.User;
import com.purewatersellsystem.entity.UserInfo;
import com.purewatersellsystem.mapper.UserInfoMapper;
import com.purewatersellsystem.mapper.UserMapper;
import com.purewatersellsystem.service.UserInfoService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public Result<List<UserInfo>> getUserInfo(String userNick) {
        User u = userMapper.findUserByNick(userNick);
        String userId = u.getUserId();
        Result<List<UserInfo>> r = new Result<>();
        List<UserInfo> ui = userInfoMapper.findUserInfoById(userId);
        if (ui != null) {
            r.setStatus(1);
            r.setMsg("查找用户信息成功");
            r.setData(ui);
        } else {
            r.setStatus(0);
            r.setMsg("用户信息不存在");
            r.setData(null);
        }
        return r;
    }

    @Override
    public Result changeAddr(String userInfoId, String userTel, String userAddr) {
        Result r = new Result();
        Integer i = userInfoMapper.updateAddr(userInfoId, userTel, userAddr);
        if (i == 1) {
            r.setMsg("修改地址成功");
            r.setStatus(1);
        } else {
            r.setMsg("修改地址失败");
            r.setStatus(0);
        }
        return r;
    }

    @Override
    public Result addAddr(String userNick, String userAddr, String userTel, String status) {
        status = "0";
        String userId = userMapper.findUserByNick(userNick).getUserId();
        Result r = new Result();
        Integer i = userInfoMapper.addAddr(MyUtil.createId(), userId, userAddr, userTel, status);
        if (i == 1) {
            r.setStatus(1);
            r.setMsg("添加地址成功");
        } else {
            r.setStatus(0);
            r.setMsg("添加地址失败");
        }
        return r;
    }

    @Override
    public Result<UserInfo> findByUserInfoId(String userInfoId) {
        Result<UserInfo> r = new Result<>();
        UserInfo ui = userInfoMapper.findByUserInfoId(userInfoId);
        if(ui!=null){
            r.setMsg("查找用户信息成功");
            r.setStatus(1);
            r.setData(ui);
        }else{
            r.setStatus(0);
            r.setMsg("查找用户信息失败");
        }
        return r;
    }

    @Override
    public Result deleteUserInfoById(String userInfoId) {
        Result r = new Result();
        Integer i = userInfoMapper.deleteUserInfo(userInfoId);
        if(i == 1){
            r.setMsg("删除收货地址成功");
            r.setStatus(1);
        }else{
            r.setMsg("删除收货地址失败");
            r.setStatus(0);
        }
        return r;
    }

    @Override
    public Result setAsDefaultAddr(String userName, String userInfoId) {
        userInfoMapper.calcelDefault(userMapper.findUserByNick(userName).getUserId());
        userInfoMapper.setDefault(userInfoId);
        Result r = new Result();
        r.setStatus(1);
        r.setMsg("设置成功");
        return r;
    }
}
