package com.nd.zsp.bootdemo.module.demo.controller;

import com.nd.zsp.bootdemo.module.demo.Service.UserService;
import com.nd.zsp.bootdemo.module.demo.model.Deparment;
import com.nd.zsp.bootdemo.module.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public Object findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Object findDepartmentBy(@PathVariable(name = "id") String id) {
        Optional<User> userOptional = userService.findUserById(Long.valueOf(id));
        User user = userOptional.get();
        if (user != null){
            Deparment deparment = user.getDeparment();
            return deparment;
        }
        return "not found";
    }

}
