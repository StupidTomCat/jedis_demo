package com.yyh.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtils {
    private static JedisPool jp = null;
    private static String host;
    private static int port;
    private static int maxTotal;
    private static int maxIdle;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("redis");//redis配置文件名
        host = rb.getString("redis.host");
        port = Integer.parseInt(rb.getString("redis.port"));
        maxTotal = Integer.parseInt(rb.getString("redis.maxTotal"));
        maxIdle = Integer.parseInt(rb.getString("redis.maxIdle"));
        //JedisPool类是jedis提供的连接池，构造方法的参数有：GenericObjectPoolConfig poolConfig,String host,int port
        //poolConfig：连接池配置对象，host：redis地址，port：redis端口
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxTotal(maxTotal);//按照连接池思想，设置连接池最大连接数
        jpc.setMaxIdle(maxIdle);//设置活动连接数
        jp = new JedisPool(jpc,host,port);
    }

    public static Jedis getJedis(){
        return jp.getResource();
    }
}
