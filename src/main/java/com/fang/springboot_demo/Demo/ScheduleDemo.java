package com.fang.springboot_demo.Demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务demo
 */


@Component    //让这个类可以被Springboot扫描到
public class ScheduleDemo {

   // @Scheduled(fixedRate = 2000)
    public void test(){
        System.out.println("当前时间："+new Date());
    }
}
