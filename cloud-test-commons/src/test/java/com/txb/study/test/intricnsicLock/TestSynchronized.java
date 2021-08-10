package com.txb.study.test.intricnsicLock;

/**
 * @ Author txb
 * @ Date 2021/8/4 14:59
 * @ Description : synchronized
 * 不管是实例方法还是静态方法，只要是同一个锁对象，就可以同步
 * this对象
 * 常量对象：final  obj
 */
public class TestSynchronized {
    public static void main(String[] args)  {
        TestSynchronized t1 = new TestSynchronized();
        TestSynchronized t2 = new TestSynchronized();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.mm();// this 就是t1锁对象
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                t1.mm(); // this 就是t1锁对象
                t2.mm(); // this 就是t2锁对象  (与t1线程不是同一把锁，不是同一个锁对象，不能实现同步)
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sm(); // Thread3
            }
        }).start();


    }

    public static  final Object obj = new Object();

    public void  mm(){
//        synchronized (this){  // 保证线程Thread0 释放锁以后，Thread1 在执行
        synchronized (obj){ // 使用常量对象作为锁对象（保证同步）
            for (int i = 0; i <100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }

    public static  void  sm(){
        synchronized (obj){// 使用常量对象作为锁对象（保证同步）
            for (int i = 0; i <100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }

}
