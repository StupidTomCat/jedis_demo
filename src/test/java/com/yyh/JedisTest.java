package com.yyh;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    @Test
    public void helloJedis(){
        //连接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //操作redis
        jedis.set("message","helloJedis");
        String message = jedis.get("message");
        System.out.println(message);
        //关闭连接
        jedis.close();
    }
}
