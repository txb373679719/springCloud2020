package com.txb.study.test.intricnsicLock;

/**
 * @ Author txb
 * @ Date 2021/8/4 14:59
 * @ Description : synchronized同步静态方法
 *                  把整个方法体作为同步代码块
 *                  默认的锁对象就是当前 类运行时的对象： TestSynchronizedClass.class ，有人称它为类锁
 */
public class TestSynchronizedClass {
    public static void main(String[] args)  {
        TestSynchronizedClass t1 = new TestSynchronizedClass();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.sm();
            }
        }).start();



    }


    public void  mm(){
        synchronized (TestSynchronizedClass.class){ // 运行时类对象作为锁对象（保证同步）
            for (int i = 0; i <100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }

    // synchronized 修饰静态方法，同步静态方法，默认运行时类TestSynchronizedClass.class作为锁对象
    public synchronized  static  void  sm(){
            for (int i = 0; i <100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
    }

}
