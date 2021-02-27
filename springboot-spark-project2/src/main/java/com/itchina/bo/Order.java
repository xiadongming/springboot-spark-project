package com.itchina.bo;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @Date: 2021/2/27 8:58
 * @描述:
 */
public class Order implements Serializable {

    @Id
    private Long orderId;

    private Integer userId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                '}';
    }
}
