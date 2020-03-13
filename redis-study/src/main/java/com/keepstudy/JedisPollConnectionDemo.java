package com.keepstudy;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: JedisPool连接
 */
public class JedisPollConnectionDemo {
    public static void main(String[] args) {
        JedisPool jedisPool = null;
        Jedis jedis = null;
        try {
            String host = "192.168.1.4";
            int port = Protocol.DEFAULT_PORT;
            jedisPool = new JedisPool(host,port);
            jedis = jedisPool.getResource();
            jedis.select(2);
            jedis.append("age","12");
            jedis.expire("age",5);
            //测试ping命令
            String pong = jedis.ping();
            System.out.println(pong);
            System.out.println(jedis.get("age"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            jedisPool.close();
            jedis.close();
        }
    }
}
