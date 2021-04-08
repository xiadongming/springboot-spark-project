package com.itchina.mapper;

import com.itchina.seckill.GoodsSeckillBO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Date: 2021/3/24 18:24
 * @Desc:
 */
@Mapper
public interface GoodsSeckillMapper {

    GoodsSeckillBO queryByGoodsId(Integer goodsId);

    GoodsSeckillBO queryById(Integer id);

    List<GoodsSeckillBO> findUnStartSeckillGoods();
    List<GoodsSeckillBO> findExpireSeckillGoods();

    void updateStatus(GoodsSeckillBO goodsSeckillBO);
}
