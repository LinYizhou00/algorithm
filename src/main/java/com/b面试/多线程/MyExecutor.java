package com.b面试.多线程;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author Lin Yizhou
 * @Date 2023/3/25 23:19
 */
public class MyExecutor {
    private List<WorkerThread> workerThreadList;
    private BlockingDeque<Runnable> runnables;
    private static boolean isRunning = true;

    public static void main(String[] args) {
        MyExecutor executor = new MyExecutor(6, 20);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        isRunning = false;

    }

    public MyExecutor(int maxThreadCount, int dequeSize) {
        runnables = new LinkedBlockingDeque<>(dequeSize);
        workerThreadList = new ArrayList<>(maxThreadCount);
        for (int i = 0; i < maxThreadCount; i++) {
            new WorkerThread().start();
        }
    }

    public boolean execute(Runnable command) {
        return runnables.offer(command);
    }

    class WorkerThread extends Thread {
        @Override
        public void run() {
            while (isRunning || runnables.size() > 0) {
                Runnable poll = runnables.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        }
    }
}
