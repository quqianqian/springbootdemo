package com.nd.zsp.bootdemo.module.demo.controller;

import com.nd.zsp.bootdemo.module.demo.Repository.DeparmentRepository;
import com.nd.zsp.bootdemo.module.demo.Repository.RoleRepository;
import com.nd.zsp.bootdemo.module.demo.Repository.UserRepository;
import com.nd.zsp.bootdemo.module.demo.model.Deparment;
import com.nd.zsp.bootdemo.module.demo.model.Role;
import com.nd.zsp.bootdemo.module.demo.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MySqlTests {

    public static final Logger log = LoggerFactory.getLogger(MySqlTests.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeparmentRepository deparmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void initData(){
        userRepository.deleteAll();
        roleRepository.deleteAll();
        deparmentRepository.deleteAll();

        Deparment deparment = new Deparment();
        deparment.setName("develop");
        deparmentRepository.save(deparment);
        Assert.notNull(deparment.getId(),"没有获取到数据");

        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.notNull(role.getId(),"没有获取到数据");

        User user = new User();
        user.setName("user");
        user.setCreatedate(new Date());
        user.setDeparment(deparment);
        List<Role> roles = roleRepository.findAll();
        Assert.notNull(roles,"没有获取到数据");
        user.setRoles(roles);

        userRepository.save(user);
        Assert.notNull(user.getId(),"没有获取到数据");
    }

    @Test
    public void findPage(){
        Pageable pageable = PageRequest.of(0,10, new Sort(Sort.Direction.ASC, "id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.notNull(page, "没有获取到数据");

        for (User user: page.getContent()) {
            log.info("====User==== user name:{}, department name:{}, role name:{}", user.getName(),user.getDeparment().getName(),user.getRoles().get(0).getName());
        }
    }
}
