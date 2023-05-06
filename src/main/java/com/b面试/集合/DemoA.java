package com.b面试.集合;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/2 15:30
 */

public class DemoA {
    static class Money {
        private int value = 11;

        void reduce() {
            value -= 10;
        }


    }

    public static void main(String[] args) throws InterruptedException {

        Money money = new Money();
        ReentrantReadWriteLock.ReadLock readLock = new ReentrantReadWriteLock().readLock();
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        Runnable readRunnable = () -> {
            readLock.lock();
            System.out.println(money.value);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readLock.unlock();
        }; Runnable writeRunnable = () -> {
            readLock.lock();
            System.out.println(money.value);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readLock.unlock();
        };



        ReentrantLock reentrantLock = new ReentrantLock();
        System.out.println("start :" + money.value);
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3,
                60, TimeUnit.SECONDS, blockingQueue);
        Runnable reduceLockMoney = () -> {
            reentrantLock.lock();
            if (money.value >= 10) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                money.reduce();

                System.out.println(reentrantLock.getQueueLength() + " " + Thread.currentThread().getName() + " success");
            } else {
                System.out.println("余额不足");
            }

            reentrantLock.unlock();
        };
        Runnable reduceSynMoney = () -> {
            synchronized (money) {
                if (money.value >= 10) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    money.reduce();

                    System.out.println(Thread.currentThread().getName() + " success");
                } else {
                    System.out.println("余额不足");
                }
            }
        };


        for (int i = 0; i < 3; i++) {
            executor.execute(readRunnable);
        }


        Thread.sleep(1000);
        System.out.println("end :" + money.value);
        executor.shutdown();

    }
}
