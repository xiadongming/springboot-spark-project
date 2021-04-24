package com.itchina.sharding;

import com.itchina.ftp.FTPUtils2;
import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Date: 2021/4/24 9:23
 * @Desc: sharding 相关配置
 */
@Service
public class ShardingConfigAlgorithm implements PreciseShardingAlgorithm<String> {
    static final Logger logger = LoggerFactory.getLogger(ShardingConfigAlgorithm.class);
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        logger.info("分表逻辑入参：collection={},preciseShardingValue={}",collection,preciseShardingValue);
        //preciseShardingValue就是当前插入的字段值
        //collection 内就是所有的逻辑表
        String provinceCode = preciseShardingValue.getColumnName();
        String value = preciseShardingValue.getValue();
        if (StringUtils.isBlank(provinceCode) || StringUtils.isBlank(value)) {
            throw new UnsupportedOperationException("provinceCode或者value不能为空");
        }
        for (String tableName : collection) {//循环表名已确定使用哪张表
            String inComingTableName = "t_order" + value;
            if (tableName.equals(inComingTableName)) {
                return tableName;
            }
        }
        return null;
    }
}
