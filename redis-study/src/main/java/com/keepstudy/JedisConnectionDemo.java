package com.keepstudy;

import redis.clients.jedis.Jedis;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: 连接Jedis
 */
public class JedisConnectionDemo {
    public static void main(String[] args) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("192.168.1.4", 6379);
            //执行ping命令，测试
            String pong = jedis.ping();
            System.out.println(pong);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            jedis.close();
        }
    }
}
