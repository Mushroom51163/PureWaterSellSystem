package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.ServiceInfo;

import java.util.List;

public interface ServiceInfoService {
    Result<List<ServiceInfo>> findAllService(String page);

    Result<String> getTotalPageForFindAll();
}
