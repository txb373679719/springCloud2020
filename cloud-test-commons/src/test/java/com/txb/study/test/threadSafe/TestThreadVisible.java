package com.txb.study.test.threadSafe;

import java.util.Random;

/**
 * @ Author txb
 * @ Date 2021/8/4 14:59
 * @ Description 测试线程可见性
 */
public class TestThreadVisible {
    public static void main(String[] args) throws InterruptedException {
        MyTask task  = new MyTask();
        new Thread(task).start();
        Thread.sleep(1000);
        //主线程一秒以后取消子线程
        task.cancel();
        /*
         可能出现如下情况：
            在main线程调用了task.cancel()方法，把toCancel = true
            可能在子线程看不到main线程对toCancel做的修改，子线程中toCancel变量一直为false。
         出现的原因可能为：
          1. JIT即时编译会对run方法中的while进行优化：
              if(!toCancel)
                while (true){
                    if(doSomeThing()){
                }
            }
          2.可能和计算机的存储系统有关，两个CPU内核分别执行 main线程和子线程，运行子线程的CPU无法立即读取main线程cpu的数据

         */

    }

    static  class MyTask implements  Runnable{
        private boolean toCancel = false;

        @Override
        public void run() {
            while (!toCancel){
                if(doSomeThing()){

                }
            }
            if(toCancel){
                System.out.println("任务被取消");
            }else{
                System.out.println("任务正常结束");
            }
        }


        private boolean doSomeThing() {
            System.out.println("执行某个任务。。。");
            try {
                Thread.sleep(new Random().nextInt(1000));//模拟做事发生的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  true;
        }

        public void cancel() {
            toCancel = true;
            System.out.println("收到线程取消的消息。");
        }
    }
}
