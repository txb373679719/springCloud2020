package com.txb.study.test.thread;

/**
 * @ Author txb
 * @ Date 2021/7/27 11:07
 * @ Description
 *  join 执行后线程进入阻塞状态，在main线程中调用t1线程的join()方法，
 *  main线程会进入阻塞状态，直到t1线程结束或中断
 */
public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //join()方法后无论休眠多久，都会先执行t1
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadJoinDemo.run");
            }
        });
        t1.start();
        t1.join();
        //  这行代码必须等t1全部执行完才能执行
        System.out.println("这行代码必须等t1全部执行完才能执行");

    }
}
