package com.txb.study.test.intricnsicLock;

/**
 * @ Author txb
 * @ Date 2021/8/4 14:59
 * @ Description : synchronized
 * 同步代码块和同步方法，怎么选择
 * 同步方法，锁的粒度粗，执行效率低
 */
public class Test07 {
    public static void main(String[] args)  {
        Test07 t7  = new Test07();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t7.doLongTimeTask();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t7.doLongTimeTask();
            }
        }).start();
    }

    // 对代码块进行同步，锁的粒度细，执行效率高。减少Thread.sleep(3000)模拟任务执行准备时间
    public void  doLongTimeTask(){
        System.out.println("task begin");
        try {
            Thread.sleep(3000);//模拟任务执行准备时间
            synchronized (this){
                for (int i = 0; i <100 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"-->"+i);
                }
            }
            System.out.println("task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 对方法进行同步，锁的粒度粗，执行效率低。只能等当前thread 执行完以后，释放锁。下一个线程重新获取锁 在休眠3秒继续for循环。依次类推
    public synchronized  void  doLongTimeTask2(){
        System.out.println("task begin");
        try {
            Thread.sleep(3000);//模拟任务执行准备时间
            synchronized (this){
                for (int i = 0; i <100 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"-->"+i);
                }
            }
            System.out.println("task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
