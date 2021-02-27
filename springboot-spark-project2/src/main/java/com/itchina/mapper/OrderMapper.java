package com.itchina.mapper;

import com.itchina.bo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Date: 2021/2/27 9:00
 * @描述:
 */
@Mapper
public interface OrderMapper {

    List<Order> queryList();

    void insertDB2(Order order);

    Order selectByOrderId(Order order);

    List<Order> selectByBatchOrderIds(@Param("orderIds") List<Long> orderIds);

    Order selectByUserId(Order order);
}
