package com.fang.springboot_demo.Demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsynTaskDemo {

    @Async    //注解表示时一个异步任务方法，也可作用于类上，表示该类所有的方法都是一步方法
    public void AsynTask1() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread.sleep(1000);
        long end =System.currentTimeMillis();
        System.out.println("任务1耗时："+(start-end));
    }


    @Async
    public void AsynTask2() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread.sleep(2000);
        long end =System.currentTimeMillis();
        System.out.println("任务2耗时："+(start-end));
    }


    @Async
    public void AsynTas3() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread.sleep(3000);
        long end =System.currentTimeMillis();
        System.out.println("任务3耗时："+(start-end));
    }
}
