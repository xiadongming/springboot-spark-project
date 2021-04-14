package com.itchina.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @Date: 2021/4/14 15:03
 * @Desc: 布隆过滤器
 *        特性：1-如果布隆过滤器认为值不存在，那么值一定是不存在的，无需查询缓存也无需查询数据库
 *             2-过滤器判断值存在而实际并不存在的概率，极小概率的误判请求，才会最终让非法 Key 的请求走到缓存或数据库
 */
public class BloomFilterDemo {
    public static void main(String[] args) {

        //创建布隆过滤器，元素数量10000，期望误判率1%
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 10000, 0.01);

        //通过布隆过滤器先判断,判断在布隆中是否存在，如果判断存在有可能会误判，但是概率很小
        if(bloomFilter.mightContain(1)){

        }
    }
}
