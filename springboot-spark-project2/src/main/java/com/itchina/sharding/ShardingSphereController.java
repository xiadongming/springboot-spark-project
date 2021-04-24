package com.itchina.sharding;

import com.itchina.bo.Order;
import com.itchina.mapper.OrderMapper;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Date: 2021/2/27 9:07
 * @描述:
 */
@RestController
@RequestMapping("/dev")
public class ShardingSphereController {

    @Autowired
    SnowflakeShardingKeyGenerator userKeyGenerator;

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询全部
     */
    @RequestMapping(value = "/jdbc", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Order> selectAll() {
        List<Order> orders = orderMapper.queryList();

        System.out.println("orders= " + orders);

        return orders;
    }

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
     * 单条查询
     * 根据分片键查询
     */
    @RequestMapping(value = "/queryByOrderId", method = {RequestMethod.GET, RequestMethod.POST})
    public Order selectByOrderId(String orderId) {
        Order order = new Order();
        order.setOrderId(Long.valueOf(orderId));
        Order result = orderMapper.selectByOrderId(order);
        return result;
    }

    /**
     * 批量查询
     */
    @RequestMapping(value = "/queryByBatch", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Order> selectByBatch(String orderId1, String orderId2) {
        List<Long> orderIds = new ArrayList<>();
        orderIds.add(Long.valueOf(orderId1));
        orderIds.add(Long.valueOf(orderId2));
        List<Order> resultList = orderMapper.selectByBatchOrderIds(orderIds);
        System.out.println("resultList= " + resultList);
        return resultList;
    }

    /**
     * 根据非主键查询
     */
    @RequestMapping(value = "/queryByUserId", method = {RequestMethod.GET, RequestMethod.POST})
    public Order selectByUserId(String userId) {

        Order order = new Order();
        order.setUserId(Long.parseLong(userId));
        Order result = orderMapper.selectByUserId(order);
        System.out.println("result= " + result);
        return result;
    }

}
