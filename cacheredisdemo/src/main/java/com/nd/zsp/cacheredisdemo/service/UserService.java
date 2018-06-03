package com.nd.zsp.cacheredisdemo.service;

import com.nd.zsp.cacheredisdemo.domain.User;

public interface UserService {

    User saveOrUpdate(User user);

    User get(Long id);

    void delete(Long id);
}
