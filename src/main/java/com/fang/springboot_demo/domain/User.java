package com.fang.springboot_demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 用户实体
 */

@Data
public class User {
    @JsonIgnore  //当某个字段不能暴露给前端的时候，可以用这个，比如密码
    private Integer id;
    private String name;
    private Integer age;

}
