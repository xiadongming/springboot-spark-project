package com.itchina.mapper;

import com.itchina.bo.LoggerBO;
import com.itchina.bo.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Date: 2021/3/12 15:52
 * @Desc:
 */
@Mapper
public interface LoggerMapper {

    void insertDB2(LoggerBO logger);

}
