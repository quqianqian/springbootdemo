package com.nd.zsp.bootmybatisdemo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nd.zsp.bootmybatisdemo.Module.Domain.User;
import com.nd.zsp.bootmybatisdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    public static final Logger log = LoggerFactory.getLogger(UserMapperTests.class);

    @Autowired
    private UserMapper userMapper;

    /*@Test
    public void test1() throws Exception {
        final int row1 = userMapper.insert(new User("u1", "p1"));
        log.info("[添加结果] - [{}]", row1);
        final int row2 = userMapper.insert(new User("u2", "p2"));
        log.info("[添加结果] - [{}]", row2);
        final int row3 = userMapper.insert(new User("u1", "p3"));
        log.info("[添加结果] - [{}]", row3);
        final List<User> u1 = userMapper.findByUsername("u1");
        log.info("[根据用户名查询] - [{}]", u1);
    }*/

    @Test
    public void test2() throws Exception {
        final int row1 = userMapper.insertSelective(new User("u11", "p11"));
        log.info("[添加结果] - [{}]", row1);
        final int row2 = userMapper.insertSelective(new User("u12", "p12"));
        log.info("[添加结果] - [{}]", row2);
        final int row3 = userMapper.insertSelective(new User("u11", "p13"));
        log.info("[添加结果] - [{}]", row3);
        final int count = userMapper.countByUsername("u11");
        log.info("[调用自己写的SQL结果] - [{}]", count);
//        final List<User> u1 = userMapper.findByUsername("u1");
//        log.info("[根据用户名查询] - [{}]", u1);
        userMapper.insertSelective(new User("u11", "p13"));
        userMapper.insertSelective(new User("u11", "p12"));
        userMapper.insertSelective(new User("u11", "p14"));
        userMapper.insertSelective(new User("u11", "p15"));
        userMapper.insertSelective(new User("u11", "p16"));
        userMapper.insertSelective(new User("u11", "p18"));
        userMapper.insertSelective(new User("u11", "p19"));
        userMapper.insertSelective(new User("u11", "p1277"));
        userMapper.insertSelective(new User("u11", "p1267"));
        userMapper.insertSelective(new User("u11", "p1221"));
        userMapper.insertSelective(new User("u11", "p1200"));
// TODO 分页 + 排序 this.userMapper.selectAll() 这一句就是我们需要写的查询，有了这两款插件无缝切换各种数据库
        final PageInfo<Object> pageInfo = PageHelper.startPage(1,5)
                .setOrderBy("id desc")
                .doSelectPageInfo(()->this.userMapper.selectAll());
        log.info("[lambda写法] - [分页信息] - [{}]", pageInfo.toString());

        PageHelper.startPage(2,3).setOrderBy("id desc");
        final PageInfo<User> userPageInfo = new PageInfo<>(this.userMapper.selectAll());
        log.info("[普通写法] - [{}]", userPageInfo);


    }
}
