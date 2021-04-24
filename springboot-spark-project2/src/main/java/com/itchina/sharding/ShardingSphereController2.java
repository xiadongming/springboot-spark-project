package com.itchina.sharding;

import com.itchina.bo.Order;
import com.itchina.mapper.OrderMapper;
import com.itchina.page.logic.LogicPage;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @Date: 2021/4/24 11:04
 * @Desc: 按照省份分表的测试
 */
@RestController
@RequestMapping("/dev2")
public class ShardingSphereController2 {
    @Autowired
    SnowflakeShardingKeyGenerator userKeyGenerator;

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 数据新增
     */
    @RequestMapping(value = "/insert", method = {RequestMethod.GET, RequestMethod.POST})
    public String insertDB2() {
        Order order = new Order();
        order.setOrderId((Long) userKeyGenerator.generateKey());
        order.setUserId(Long.parseLong(String.valueOf(new Random().nextInt(10))));
        order.setProvinceCode("180000");
        orderMapper.insertDB2(order);
        return "successful";
    }

    /**
     * 数据新增
     */
    @RequestMapping(value = "/insert2", method = {RequestMethod.GET, RequestMethod.POST})
    public String insertDB22() {
        Order order = new Order();
        order.setOrderId((Long) userKeyGenerator.generateKey());
        order.setUserId(Long.parseLong(String.valueOf(new Random().nextInt(10))));
        order.setProvinceCode("190000");
        orderMapper.insertDB2(order);
        return "successful";
    }
    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public Object queryDB22(String provinceCode) {
        Order order = new Order();
        order.setProvinceCode(provinceCode);
        LogicPage<Order> objectLogicPage = new LogicPage<Order>(1, 5);
        List<Order> orders = orderMapper.selectByCondition(order, objectLogicPage);
        return orders;
    }
}
