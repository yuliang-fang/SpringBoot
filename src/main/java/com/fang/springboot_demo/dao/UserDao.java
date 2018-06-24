package com.fang.springboot_demo.dao;

import com.fang.springboot_demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 用户Dao
 */

@Mapper
public interface UserDao {

    @Select("select id,name,age from demo_user where id=#{id}")
    User getUserById(@Param("id") Integer id);

}
