package com.txb.study.test.threadBasic.ThreadName;

/**
 * @ Author txb
 * @ Date 2021/8/3 15:42
 * @ Description TODO
 */
public class TestCurrentThread {
    public static void main(String[] args) {
        SubThread2 t2 = new SubThread2();
        t2.setName("t2");
        t2.setPriority(1);//设置线程优先级，1-10
        t2.start();// start 会执行run方法

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Thread（Runnable） 构造方法形参是Runnable接口，调用时传入的实参是接口的实现类对象
        Thread t3 = new Thread(t2);
        t3.start();


    }
}
