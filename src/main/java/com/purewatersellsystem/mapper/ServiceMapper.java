package com.purewatersellsystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ServiceMapper {
    @Insert("insert into `service` values (#{userId},#{Advice},#{Complain})")
    Integer newService(@Param("userId") String userId, @Param("Advice") String Advice, @Param("Complain") String Complain);
}
