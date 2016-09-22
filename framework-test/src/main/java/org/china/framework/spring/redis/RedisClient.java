package org.china.framework.spring.redis;

import redis.clients.jedis.*;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/18 11:53.
 */
public class RedisClient {

    private static final String IP="192.168.6.130";
    private static final int PORT=6379;
    private static Jedis jedis;
    private static JedisPool jedisPool;
    private static ShardedJedis shardedJedis;
    private static ShardedJedisPool shardedJedisPool;

    public RedisClient() {
        initialPool();
        initialShardedPool();
    }

    private void initialPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setMaxTotal(20);
        config.setMaxWaitMillis(10000l);
        config.setTestOnBorrow(false);

        jedisPool = new JedisPool(config,IP,PORT);

    }

    /**
     * 初始化切片池
     */
    private void initialShardedPool()
    {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000l);
        config.setTestOnBorrow(false);
        // slave链接
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo(IP, PORT, "master"));

        // 构造池
        shardedJedisPool = new ShardedJedisPool(config, shards);
    }

    public static void main(String[] args){
        RedisClient redisClient = new RedisClient();
        redisClient.initialPool();
        redisClient.initialShardedPool();
        System.out.println("redis操作:");
        //清空数据库
        redisClient.jedis.flushDB();
        //判断键值是否存在
        System.out.println("判断键值key999是否存在:" + shardedJedis.exists("key999"));
        System.out.println("增加键值key001,value001："+shardedJedis.set("key001","value001"));
        System.out.println("判断key001是否存在:" + shardedJedis.echo("key001"));
        //输出系统中所有的key
        Set<String> keys = jedis.keys("*");
        for (String str : keys){
            System.out.println("key:" + str + ",value：" + shardedJedis.get(str));
        }
    }
}
