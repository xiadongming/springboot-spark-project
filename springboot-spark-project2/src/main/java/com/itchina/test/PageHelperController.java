package com.itchina.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itchina.bo.Order;
import com.itchina.mapper.OrderMapper;
import com.itchina.page.logic.LogicPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date: 2021/3/3 15:25
 * @Desc:
 */
@RestController
@RequestMapping("/page")
public class PageHelperController {

    @Autowired
    private OrderMapper orderMapper;
    /**
     * PageHelper
     * 物理分页,较好
     * */
    @RequestMapping(value = "/db", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getPagePhy(int pageNum) {

        PageHelper.startPage(pageNum, 5);
        List<Order> orders = orderMapper.queryList();
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);

        return orderPageInfo;
    }

    /**
     * RowBounds
     * 逻辑分页，不好：一下查询出所有的数据到内存，
     * */
    @RequestMapping(value = "/logic", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getPageLogic(int pageNum) {
        Order order = new Order();
        order.setOrderId(57L);
        LogicPage<Order> objectLogicPage = new LogicPage<Order>(pageNum,5);
        List<Order> orders = orderMapper.selectByCondition(order, objectLogicPage);

        return orders;
    }


}
