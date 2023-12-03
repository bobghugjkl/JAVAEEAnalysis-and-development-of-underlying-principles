package com.xxxx.springdataredisdemo;

import com.xxxx.springdataredisdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import javax.jws.Oneway;
import java.security.KeyStore;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringdataredisDemoApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void initConn() {
//        ValueOperations ops = redisTemplate.opsForValue();
//        ops.set("name","zhangsan");
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("age","20");
        String age = stringStringValueOperations.get("age");
        System.out.println(age);

    }


//    测试序列化
    @Test
    public void testSerial(){
        User user = new User();
        user.setId(1);
        user.setAge(11);
        user.setName("zhangsan");
        ValueOperations<String, Object> value = redisTemplate.opsForValue();
        value.set("userInfo",user);
        System.out.println(value.get("userInfo"));
    }
//    操作String
    @Test
    public void testString(){
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("username","zhangsan");
        valueOperations.set("age","18");

        valueOperations.set("user:01","list");
        valueOperations.set("user:02","wangwu");

        HashMap<String,String> userMap = new HashMap<>();
        userMap.put("address","bj");
        userMap.put("sex","1");
        valueOperations.multiSet(userMap);

        Object username = valueOperations.get("username");
        System.out.println(username);

        List<String> keys = new ArrayList<>();
        keys.add("username");
        keys.add("age");
        keys.add("address");
        keys.add("sex");
        List<Object> resultList = valueOperations.multiGet(keys);
        for (Object str :
                resultList) {
            System.out.println(str);
        }
        redisTemplate.delete("username");
    }

    @Test
    public void testHash() {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();

        /*
         * 添加一条数据
         *     参数一：redis的key
         *     参数二：hash的key
         *     参数三：hash的value
         */
        hashOperations.put("userInfo","name2","lisi");
        String type = String.valueOf(redisTemplate.type("userInfo"));
        System.out.println(type);
        // 添加多条数据
        Map<String, String> map = new HashMap();
        map.put("age", "20");
        map.put("sex", "1");
        hashOperations.putAll("userInfo", map);

        // 获取一条数据
        String name = hashOperations.get("userInfo", "name2");
        System.out.println(name);

        // 获取多条数据
        List<String> keys = new ArrayList<>();
        keys.add("age");
        keys.add("sex");
        List<String> resultlist =hashOperations.multiGet("userInfo", keys);
        for (String str : resultlist) {
            System.out.println(str);
        }

        // 获取Hash类型所有的数据
        Map<String, String> userMap = hashOperations.entries("userInfo");
        userMap.entrySet().forEach(e->{
            System.out.println(e.getKey()+"-->"+e.getValue());
        });

        // 删除 用于删除hash类型数据
        hashOperations.delete("userInfo", "name2");

    }

    @Test
    public void testList(){
        ListOperations<String,Object> listOperations = redisTemplate.opsForList();


        listOperations.leftPush("students","wangwu");
        listOperations.leftPush("studebts","Lisi");
        listOperations.rightPush("students","zhaoliu");
        List<Object>students = listOperations.range("students",0,2);
        for (Object stu :
                students) {
            System.out.println(stu);
        }

        Object stu = listOperations.index("students", -1);
        System.out.println(stu);

        Long total = listOperations.size("students");
        System.out.println(total);

        listOperations.remove("students",1,"LiSi");

        redisTemplate.delete("students");
    }

    @Test
    public void testSet()
    {
        SetOperations setOperations = redisTemplate.opsForSet();
        String[] letters = {"aaa", "bbb", "ccc", "ddd", "eee"};
        setOperations.add("letters",letters);

        Set<Object> let = setOperations.members("letters");
        for (Object letter:
             let) {
            System.out.println(letter);
        }
        setOperations.remove("letters","aaa","bbb");




    }
    @Test
    public void testSortedSet() {
        ZSetOperations<String,Object> zSetOperations = redisTemplate.opsForZSet();
        ZSetOperations.TypedTuple<Object>objectTypedTuple1 = new DefaultTypedTuple<Object>("zhangsan",7D);
        ZSetOperations.TypedTuple<Object>objectTypedTuple2 = new DefaultTypedTuple<Object>("lisi",6D);
        ZSetOperations.TypedTuple<Object>objectTypedTuple3 = new DefaultTypedTuple<Object>("wangwu",10D);
        ZSetOperations.TypedTuple<Object>objectTypedTuple4 = new DefaultTypedTuple<Object>("zhaoliu",3D);
        ZSetOperations.TypedTuple<Object>objectTypedTuple5 = new DefaultTypedTuple<Object>("tianqi",4D);

        Set<ZSetOperations.TypedTuple<Object>>tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        tuples.add(objectTypedTuple3);
        tuples.add(objectTypedTuple4);
        tuples.add(objectTypedTuple5);
        zSetOperations.add("score",tuples);

        Set<Object> scores = zSetOperations.range("score", 0, 4);
        for (Object score:
             scores) {
            System.out.println(score);
        }

        Long total = zSetOperations.size("score");
        System.out.println(total);
        zSetOperations.remove("score","zhangsan","lisi");
    }


    @Test
    public void testAllkeys(){
        Set<String>keys = redisTemplate.keys("*");
        for (String key :
                keys) {
            System.out.println(key);
        }
    }
    @Test
    public void testDelete(){
        redisTemplate.delete("score");
    }

    @Test
    public void testEx(){
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("code","abcd",180, TimeUnit.SECONDS);

        Boolean flag = redisTemplate.expire("code", 180, TimeUnit.SECONDS);
        Long l = redisTemplate.getExpire("code");
        System.out.println(l);
    }

}
