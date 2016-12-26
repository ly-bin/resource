package com.file;

import org.junit.Test;
import redis.clients.jedis.*;


/**
 * @author <a href="qiaotaosheng@163.com">TaoSheng.Qiao</a>
 * @version 1.0.0
 * @description:
 * @date 2016-8-24 17:37
 */
public class RedisTest {
    private String redisHost  = "127.0.0.1";
    private int redisPort = 6379;
    private JedisPool jedisPool = new JedisPool(redisHost, redisPort);

    public static void main(String[] args) {
        new RedisTest().testJedis();
    }

    public void testJedis(){
        Jedis jedis = jedisPool.getResource();
	// 选择redis库号
        jedis.select(3);
        jedis.sadd("ss1", "111");
        jedis.sadd("ss1", "222");
        jedis.sadd("ss1", "333");
        jedis.sadd("ss1", "444");
        jedis.sadd("ss1", "444");
        jedis.sadd("ss2", "44411");
        jedis.sadd("ss2", "44422");
	// 主动触发保存镜像
        // jedis.save();
	// 主动触发后台保存镜像
        // jedis.bgrewriteaof();
        jedis.set("w","www");
        System.out.println(jedis.smembers("ss1") + "====="+jedis.get("w"));

    }
}
