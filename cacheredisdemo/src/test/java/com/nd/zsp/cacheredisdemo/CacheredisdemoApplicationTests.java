package com.nd.zsp.cacheredisdemo;

import com.nd.zsp.cacheredisdemo.domain.User;
import com.nd.zsp.cacheredisdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheredisdemoApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(CacheredisdemoApplicationTests.class);

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        final User user = userService.saveOrUpdate(new User(5555L, "user-555", "pppppp-5555"));

        log.info("[saveOrUpdate] - [{}]", user);
        final User user1 = userService.get(5555L);
        log.info("[get] - [{}]", user1);
        userService.delete(5555L);
    }

}
