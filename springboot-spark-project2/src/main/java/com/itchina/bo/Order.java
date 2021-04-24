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

    private Long userId;

    private String provinceCode;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", provinceCode='" + provinceCode + '\'' +
                '}';
    }
}
