package com.nd.zsp.bootdemo.module.demo.Service;

import com.nd.zsp.bootdemo.module.demo.Repository.UserRepository;
import com.nd.zsp.bootdemo.module.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Object findAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }

}
