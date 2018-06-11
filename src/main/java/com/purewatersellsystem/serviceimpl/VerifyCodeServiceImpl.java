package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.service.VerifyCodeService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Controller;

@Controller
public class VerifyCodeServiceImpl implements VerifyCodeService {
    @Override
    public Result<String> sendVerifyCode(String email, String msg) {
        Result r = new Result();
        try {
            String code = MyUtil.sendVerifyCode(email, msg);
            System.out.println(code);
            r.setStatus(1);
            r.setData(code);
            r.setMsg("发送验证码成功");
        } catch (Exception e) {
            r.setStatus(0);
            r.setMsg("发送验证码失败");
            r.setData(null);
            e.printStackTrace();
        }
        return r;
    }
}
