package com.a练习测试;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/28 13:08
 */
public class Demo_ThreadLocalTest {
    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + local.get());
                local.set("122");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " " + local.get());
                local.remove();
                System.out.println(Thread.currentThread().getName() + " " + local.get());
            }
        }).start();
        Thread.sleep(1000);
        //System.out.println(ClassLoader.getSystemClassLoader());
        //new Thread(new Runnable() {
        //    @Override
        //    public void run() {
        //        local.set("122");
        System.out.println(Thread.currentThread().getName() + " " + local.get());
        //        System.out.println(local.get());
        //    }
        //}).start();
        //System.out.println("=============================================================");
        //Thread.sleep(1000);
        //System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        //new Thread(new Runnable() {
        //
        //
        //    @Override
        //    public void run() {
        //        System.out.println(local.get());
        //        local.set("122");
        //        System.out.println(local.get());
        //
        //    }
        //}).start();


    }
}
