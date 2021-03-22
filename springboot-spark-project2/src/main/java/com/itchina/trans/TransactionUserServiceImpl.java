package com.itchina.trans;

import com.itchina.api.TransactionUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date: 2021/3/22 19:14
 * @Desc:  spring的事务隔离级别和mysql的隔离级别不一致的情况
 *         (1)spring的事务是DEFAULT级别，此时spring的事务和mysql的事务级别一致，
 *             mysql的级别是什么级别，spring的级别就是什么
 *         (2)spring的事务是其他的隔离级别，则已spring的事务为准，
 *             因为spring开启事务时，拿到的当前连接，会对当前会话设置事务隔离级别。
 *             当前会话的隔离级别和spring的隔离级别一致，和mysql的隔离级别不一致
 */
@Service
public class TransactionUserServiceImpl implements TransactionUserService {

    /**
     *     DEFAULT(-1),
     *     READ_UNCOMMITTED(1),
     *     READ_COMMITTED(2),
     *     REPEATABLE_READ(4),
     *     SERIALIZABLE(8);
     * */
    @Transactional(isolation = Isolation.DEFAULT)
    @Override
    public Object updateUser() {

        return null;
    }
}
