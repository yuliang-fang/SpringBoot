package com.fang.springboot_demo.concurrency.atomic;

import com.fang.springboot_demo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;


/**
 * 使用Atomic类，保证原子性
 * 演示java8中的LongAdder。  与 AtomicLog 都是原子性的，性能比AtomicLong高，
 * 但可能数据有误差，要求绝对准确时还是用AtomicLong
 */
@Slf4j
@ThreadSafe
public class AtomicTest3 {
    //请求总数
    public static int clientTotal = 50000;
    //同时并发执行的线程数
    public static int threadTotal = 200;
    //计数器
    public static LongAdder count = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal;i++ ){
            executorService.execute(()->{
                try{
                    //判断当前线程是否可以被执行
                    semaphore.acquire();
                    //执行方法
                    add();
                    //释放进程
                    semaphore.release();
                }catch(Exception e){
                    log.error("Exception",e);
                }
                countDownLatch.countDown();
            });
        }
        //全部执行完
        countDownLatch.await();
        executorService.shutdown();//关闭线程池
        log.info("count:{}",count);
    }

    private static void add(){
        count.increment();
    }
}
