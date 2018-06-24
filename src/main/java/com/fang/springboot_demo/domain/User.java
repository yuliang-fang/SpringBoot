package com.fang.springboot_demo.domain;


import lombok.Data;

/**
 *  用户实体
 */

@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;

}
