package com.nd.zsp.bootmybatisdemo;

import com.nd.zsp.bootmybatisdemo.Module.Domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRedisTests {

    public static final Logger log = LoggerFactory.getLogger(DepartmentRedisTests.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Test
    public void get(){
        // TODO 测试线程安全
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i ->
                executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kkk", 1))
        );
        stringRedisTemplate.opsForValue().set("kk1", "v1");
        final String k1 = stringRedisTemplate.opsForValue().get("kk1");
        log.info("[字符缓存结果] - [{}]", k1);
        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
        String key = "demo:department:1";
        redisCacheTemplate.opsForValue().set(key, new Department("pa"));
        // TODO 对应 String（字符串）
        final Department department = (Department) redisCacheTemplate.opsForValue().get(key);
        log.info("[对象缓存结果] - [{}]", department);
    }

}
