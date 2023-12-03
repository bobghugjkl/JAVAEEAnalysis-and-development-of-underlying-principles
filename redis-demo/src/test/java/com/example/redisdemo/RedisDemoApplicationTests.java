package com.example.redisdemo;

import com.example.entity.User;
import com.example.util.SerializeUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.params.SetParams;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class RedisDemoApplicationTests {
//    @Test
//    public void initConnt02(){
////        初始化连接池对象
//        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(),"127.0.0.1",6379,10000,"123456");
////        从连接池获取到对象
//        Jedis jedis = jedisPool.getResource();
//        jedis.select(1);
////        测试连接
//        String result = jedis.ping();
//        System.out.println(result);
//        jedis.set("name","zhangsan");
//        String name = jedis.get("name");
//        System.out.println(name);
//        if(jedis!=null){
//            jedis.close();
//        }
//    }
    @Autowired
    private JedisPool jedisPool;//注入线程池

//    放到全局，可能会释放资源

     private Jedis jedis = null;
      //jedis.auth("yourpassword");

    //每次初始化前先获取一次redis对象
    @BeforeEach
    public void initConnt(){
        jedis = jedisPool.getResource();//拿到jedis
        System.out.println(jedis);

    }
//    操作string
//    添加一条数据，添加多条数据，删除数据
    @Test
    public void textString(){
        System.out.println(jedis);
        jedis.set("name", "liming");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.mset("age","12","arrange","lalala");
        List<String>list = jedis.mget("name","arrange","age");
        list.forEach(System.out::println);
        jedis.del("name");
    }

//    操作哈希，添加数据，获取数据
    @Test
    public void testHash(){
        jedis.hset("userInfo","name","list");
        Map<String,String>map = new HashMap<>();
        map.put("age","20");
        map.put("sex","1");
        jedis.hmset("userInfo",map);

        String name = jedis.hget("userInfo", "name");
        System.out.println(name);

        List<String>list = jedis.hmget("userInfo","age","sex");
        for (String str :
                list) {
            System.out.println(str);
        }
        Map<String,String>userMap = jedis.hgetAll("userInfo");
        for (Map.Entry<String, String> userInfo :
                userMap.entrySet()) {
            System.out.println(userInfo.getKey()+"--"+userInfo.getValue());
        }

    }

//    操作list
    @Test
    public void testList(){
        System.out.println(jedis);
        jedis.lpush("students","Wang Wu","Li Si");
        jedis.rpush("students","Zhao Liu");

        List<String>students = jedis.lrange("students",0,2);
        students.forEach(System.out::println);
        Long total = jedis.llen("students");
        System.out.println("总条数：" + total);
        jedis.lrem("students",1,"Li Si");
        //jedis.del("students");
    }
    @Test
    public void testSet(){
        jedis.sadd("letters","aaa","bbb","ccc","ddd","eee");
        Set<String>letters = jedis.smembers("letters");
        for (String letter :
                letters) {
            System.out.println(letter);
        }
        Long total = jedis.scard("letters");
        System.out.println(total);
    }
//    操作sorted-set有序
    @Test
    public void testSortedSet(){
        Map<String,Double>scoreMembers = new HashMap<>();
        scoreMembers.put("zhangsan",7D);
        scoreMembers.put("lisi",3D);
        scoreMembers.put("wangwu",5D);
        scoreMembers.put("zhaoliu",6D);
        scoreMembers.put("tianqi",2D);

        jedis.zadd("score",scoreMembers);

        Set<String>scores = jedis.zrange("score",0,4);
        for (String score :
                scores) {
            System.out.println(score);
        }

        Long total = jedis.zcard("score");
        System.out.println("总条数"+total);
    }
//    设置层级目录
    @Test
    public void testdir(){
        jedis.set("user:01","user_zhangsan");
        System.out.println(jedis.get("user:01"));

    }
//    设置失效时间
    @Test
    public void testExpire(){
        jedis.set("code","test");
        jedis.expire("code",180);
        //jedis.pexpire("code",180000L);
        jedis.ttl("code");
        jedis.setex("code",180,"test");
        jedis.psetex("code",180000L,"test");
        jedis.pttl("code");

        SetParams setParams = new SetParams();
        setParams.nx();
        setParams.xx();
        setParams.ex(30);
        setParams.px(300000);
        jedis.set("code","test",setParams);

    }


    @Test
    public void testAllKeys(){
        System.out.println(jedis.dbSize());
        Set<String>keys = jedis.keys("*");
        for (String key :
                keys) {
            System.out.println(key);
        }
    }
    @Test
    public void testMulti(){
        Transaction tx = jedis.multi();
        tx.set("tel","10010");
        tx.exec();
        //tx.discard();
    }
    @Test
    public void testDelete(){
        jedis.del("score");
    }

    @Test
    public void testByte(){
        User user = new User();
        user.setId(2);
        user.setUsername("zhangsan");
        user.setPassword("123");
//        序列化
        byte[] userKey = SerializeUtil.serialize("user:"+user.getId());
        byte[] userValue = SerializeUtil.serialize(user);
        jedis.set(userKey,userValue);
        //获取数据
        byte[] userResult = jedis.get(userKey);
        //反序列化
        User u = (User) SerializeUtil.unserialize(userResult);
        System.out.println(u);
    }
    @AfterEach
    public void closeCount(){
        if(null!=jedis)
            jedis.close();
    }


}
