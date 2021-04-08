package com.itchina.seckill;

import com.itchina.mapper.GoodsSeckillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Date: 2021/3/28 17:24
 * @Desc:
 */
@Service
public class SeckillServiceImple implements SeckillService {

    @Autowired
    private GoodsSeckillMapper goodsSeckillMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 秒杀的逻辑
     */
    @Override
    public GoodsSeckillBO processSeckill(Integer id, String userId, Integer num) throws Exception {
        GoodsSeckillBO goodsSeckillBO = goodsSeckillMapper.queryById(id);
        if (null == goodsSeckillBO) {
            throw new Exception("秒杀活动不存在");
        }
        if (goodsSeckillBO.getStatus() == 0) {
            throw new Exception("秒杀活动未开始");
        }
        if (goodsSeckillBO.getStatus() == 2) {
            throw new Exception("秒杀活动已结束");
        }
        Integer goodsId = (Integer) redisTemplate.opsForList().leftPop("seckill_count_" + goodsSeckillBO.getId());
        /**
         * 将成功的用户添加到缓存中去
         * */
        if (null != goodsId) {
            /** isMember 判断是否已经存在 */
            Boolean member = redisTemplate.opsForSet().isMember("seckill_user_" + goodsSeckillBO.getId(), userId);
            if (!member) {
                System.out.println("恭喜，用户 " + userId + " 抢购成功");
                redisTemplate.opsForSet().add("seckill_user_" + goodsSeckillBO.getId(), userId);
            } else {
                /** 已经抢购够了，需要将商品还回去 */
                redisTemplate.opsForList().rightPush("seckill_count_" + goodsSeckillBO.getId(), goodsSeckillBO.getGoodsId());
                throw new Exception("已经参与此活动，不能重复抢购");
            }
        } else {
            throw new Exception("该商品已被抢光");
        }
        return null;
    }
}
