package com.yyh.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
    private static JedisPool jp = null;
    static {
        //JedisPool类是jedis提供的连接池，构造方法的参数有：GenericObjectPoolConfig poolConfig,String host,int port
        //poolConfig：连接池配置对象，host：redis地址，port：redis端口
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxTotal(30);//按照连接池思想，设置连接池最大连接数
        jpc.setMaxIdle(10);//设置活动连接数
        String host = "127.0.0.1";
        int port = 6379;
        jp = new JedisPool(jpc,host,port);
    }

    public static Jedis getJedis(){

        return jp.getResource();
    }
}
