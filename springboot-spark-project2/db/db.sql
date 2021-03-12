-- 操作日志
CREATE TABLE `logger_busi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `module` varchar(60) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `createAt` datetime(6) DEFAULT NULL,
  `updateAt` datetime(6) DEFAULT NULL,
  `able` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- 订单分库分表0-2
CREATE TABLE `t_order0` (
  `order_id` bigint(20) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;











