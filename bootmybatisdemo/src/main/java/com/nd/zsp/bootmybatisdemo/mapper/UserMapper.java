package com.nd.zsp.bootmybatisdemo.mapper;

import com.nd.zsp.bootmybatisdemo.Module.Domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * t_user 操作：演示两种方式
 * <p>第一种是基于mybatis3.x版本后提供的注解方式<p/>
 * <p>第二种是早期写法，将SQL写在 XML 中<p/>
 */

/*持久层
        为了更好的让熟悉它，此处模拟了一个自定义的SQL，可以发现使用
        通用Mapper 后并不会破坏原有代码结构
        UserMapper
        继承 BaseMapper<T> 就可以了，这点是不是有点类似 JpaRepository，
        同时也可以根据自己需要扩展出更适合自己项目的BaseMapper，它的灵活也是众多开发者喜爱的因素之一*/

@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user where username = #{username}")
    List<User> findByUsername(@Param("username") String username);

    int insertUser(User user);

    int countByUsername(String username);
}
