package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Expresser;
import com.purewatersellsystem.entity.Result;

import java.util.List;

public interface ExpresserService {
    Result<Expresser> findExpresserByNick(String expNick);
    Result<List<Expresser>> findExpressersByStation(String expresserStation);
    Result delExpById(String expId);
    Result addExpresser(String name,String tel,String pwd,String station);
    Result<Expresser> findExpById(String id);
    Result modExp(String expresserName,String expresserTel,String expresserPwd,String expresserId);

    Result<List<Expresser>> getFreeExpresserByStationName(String stationName);

    Result deleteDeliverByOrderId(String orderId,String userNick);

    Result<List<Expresser>> expresserNameList(String expresserStation);
}
