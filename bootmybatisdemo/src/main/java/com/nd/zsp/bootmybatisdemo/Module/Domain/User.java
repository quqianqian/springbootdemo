package com.nd.zsp.bootmybatisdemo.Module.Domain;

import java.io.Serializable;

public class User implements Serializable {



/*表结构创建一张 t_user 的表
        CREATE TABLE `t_user` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
        `username` varchar(50) NOT NULL COMMENT '用户名',
        `password` varchar(50) NOT NULL COMMENT '密码',
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
        */


    private Long id;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
