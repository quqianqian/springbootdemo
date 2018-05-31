package com.nd.zsp.bootmybatisdemo.mapper;

import com.nd.zsp.bootmybatisdemo.Module.Domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * t_user 操作：演示两种方式
 * <p>第一种是基于mybatis3.x版本后提供的注解方式<p/>
 * <p>第二种是早期写法，将SQL写在 XML 中<p/>
 */
@Component
@Mapper
public interface UserMapper {

    @Select("select * from t_user where username = #{username}")
    List<User> findByUsername(@Param("username") String username);

    int insert(User user);
}
