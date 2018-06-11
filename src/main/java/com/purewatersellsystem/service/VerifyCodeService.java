package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Result;

public interface VerifyCodeService {
    Result<String> sendVerifyCode(String email, String msg);
}
