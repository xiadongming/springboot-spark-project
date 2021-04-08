package com.itchina.seckill;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date: 2021/3/28 17:13
 * @Desc:
 */
public class GoodsSeckillBO implements Serializable {
    private Long id;
    private Integer goodsId;
    private Integer goodsCount;
    private Date startTime;
    private Date endTime;
    private Integer status;
    private Float currentPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Float currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "goodsSeckill{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", goodsCount=" + goodsCount +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
