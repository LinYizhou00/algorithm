package com.b面试.多线程;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author Lin Yizhou
 * @Date 2023/3/24 23:56
 */
public class DemoA {
    public static void main(String[] args) {
        //ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        //ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        //ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, queue);
        //for (int i = 0; i < 15; i++) {
        //    fixedThreadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " " + fixedThreadPool));
        //}
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(3);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3,
                6, TimeUnit.SECONDS, queue, Executors.defaultThreadFactory(),
                (r, executor1) -> {
                    System.out.println(Thread.currentThread());
                    System.out.println(r);
                    System.out.println(executor1);
                }
        );

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            executor.execute(() -> System.out.println(Thread.currentThread().getName() + " " + finalI));

        }
        executor.shutdown();


    }
}
