package com.fang.springboot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@ServletComponentScan
@MapperScan("com.fang.springboot_demo.dao")
@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }
}
