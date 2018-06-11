package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.Administrator;
import com.purewatersellsystem.entity.Expresser;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.User;
import com.purewatersellsystem.mapper.AdministratorMapper;
import com.purewatersellsystem.mapper.ExpresserMapper;
import com.purewatersellsystem.mapper.UserMapper;
import com.purewatersellsystem.service.UserService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.text.AbstractDocument;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private ExpresserMapper expresserMapper;

    @Resource
    private AdministratorMapper administratorMapper;

    //修改密码
    @Override
    public Result changePwd(String userNick, String userPwd) {
        int tmp = userMapper.changePassword(userNick, MyUtil.md5(userPwd));
        Result r = new Result();
        if (tmp == 1) {
            r.setStatus(1);
            r.setMsg("修改成功");
        } else {
            r.setStatus(0);
            r.setMsg("修改失败");
        }
        return r;
    }

    //检查登录
    public Result<Object> checkLogin(String nickName, String userPwd, String userType) {


        if(userType.equals("用户")){
            User u = userMapper.findUserByNick(nickName);
            Result<Object> result = new Result();
            if (u != null) {
                if (MyUtil.md5(userPwd).equals(u.getUserPwd())) {
                    result.setData(u);
                    result.setStatus(1);
                    result.setMsg("登陆成功");
                } else {
                    result.setStatus(0);
                    result.setMsg("密码错误");
                }
            } else {
                result.setStatus(0);
                result.setMsg("用户不存在");
            }
            return result;
        }else if(userType.equals("派送员")){
            Expresser e = expresserMapper.findExpresserByNick(nickName);
            Result<Object> result = new Result();
            if (e != null) {
                if (MyUtil.md5(userPwd).equals(e.getExpresserPwd())) {
                    result.setData(e);
                    result.setStatus(1);
                    result.setMsg("登陆成功");
                } else {
                    result.setStatus(0);
                    result.setMsg("密码错误");
                }
            } else {
                result.setStatus(0);
                result.setMsg("用户不存在");
            }
            return result;
        }else{
            Administrator a = administratorMapper.findAdminByNick(nickName);
            Result<Object> result = new Result();
            if (a != null) {
                if (MyUtil.md5(userPwd).equals(a.getAdminPwd())) {
                    result.setData(a);
                    result.setStatus(1);
                    result.setMsg("登陆成功");
                } else {
                    result.setStatus(0);
                    result.setMsg("密码错误");
                }
            } else {
                result.setStatus(0);
                result.setMsg("用户不存在");
            }
            return result;
        }

    }

    //用户注册
    @Override
    public Result register(String userId, String userNick, String userPwd) {
        int re = userMapper.userRegister(userId, userNick, MyUtil.md5(userPwd));
        Result result = new Result();
        if (re == 1) {
            result.setStatus(1);
            result.setMsg("注册成功");
        } else {
            result.setStatus(0);
            result.setMsg("注册失败");
        }
        return result;
    }

    @Override
    public Result<List<User>> findAllUser() {
        Result<List<User>> r = new Result<>();
        r.setMsg("查找用户成功");
        r.setStatus(1);
        r.setData(userMapper.findAllUser());
        return r;
    }

    @Override
    public Result delUserById(String userId) {
        Result r = new Result();
        r.setStatus(1);
        r.setMsg("删除用户成功");
        userMapper.delUserById(userId);
        return r;
    }
}
