package com.nd.zsp.cacheredisdemo.service.impl;

import com.nd.zsp.cacheredisdemo.domain.User;
import com.nd.zsp.cacheredisdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    public static final Map<Long, User> DATABASES = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    static {
        DATABASES.put(1111L, new User(1111L, "u1-1111L", "p11111L"));
        DATABASES.put(2222L, new User(2222L, "u2-1111L", "p22222L"));
        DATABASES.put(3333L, new User(3333L, "u3-1111L", "p33333L"));
    }

    @CachePut(value = "user", key = "#user.id")
    @Override
    public User saveOrUpdate(User user) {
        DATABASES.put(user.getId(), user);
        log.info("进入 saveOrUpdate 方法");
        return user;
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Long id) {

        // TODO 我们就假设它是从数据库读取出来的
        log.info("进入 get 方法");
        return DATABASES.get(id);
    }

    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(Long id) {
        DATABASES.remove(id);
        log.info("进入 delete 方法");
    }
}
