package com.itchina.zklock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Date: 2021/3/6 23:15
 * @Desc:
 */
public class ZookeeperLock {


    /*
     * 创建8个线程模拟8个客户端并发访问
     *
     */

    public static void main(String[] args) {

        /*
         * 定义重试策略：等待2秒,重试10次
         * 第一个参数：等待时间
         * 第二个参数：重试次数
         */
        RetryPolicy policy = new ExponentialBackoffRetry(2000, 10);
        /*
         * 创建客户端向zookeeper请求锁
         * connectString() : zookeeper地址
         * retryPolicy() : 重试策略
         */
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString("192.168.1.124:2181").retryPolicy(policy).build();
        //启用
        curatorFramework.start();
        //获取zookeeper锁的信息
        final InterProcessMutex mutex = new InterProcessMutex(curatorFramework, "/myMutex");

        for (int i = 0; i < 8; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        /**请求锁资源，
                         * 如果没有得到锁资源，就会执行重试策略
                         * 获取锁之后才向下走
                         * */
                        mutex.acquire();
                        //开始访问共享资源，这里是访问商品信息
                        ByProduct.buy();

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            //将锁归还
                            mutex.release();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}


