package com.fang.springboot_demo.dao;

import com.fang.springboot_demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户Dao
 */

//@Mapper
public interface UserDao extends Mapper<User> {

    @Select("select id,name,age from demo_user where id=#{id}")
    User getUserById(@Param("id") Integer id);

    @Insert("insert into demo_user (name,age) values(#{name},#{age})")
    Boolean addUser(@Param("name") String name, @Param("age") Integer age);

}
