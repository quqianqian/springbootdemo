package com.nd.zsp.bootmybatisdemo.Module.Domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
//实体类
// 通用Mapper采用了JPA规范包中的注解，这种的设计避免了重复造轮子，更是让Spring Data Jpa的应用可以轻松切换到Mybatis
@Table(name = "t_user")
public class User implements Serializable {
/*表结构创建一张 t_user 的表
        CREATE TABLE `t_user` (
        `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
        `username` varchar(50) NOT NULL COMMENT '用户名',
        `password` varchar(50) NOT NULL COMMENT '密码',
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
        */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
