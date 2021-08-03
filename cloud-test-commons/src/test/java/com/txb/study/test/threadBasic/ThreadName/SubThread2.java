package com.txb.study.test.threadBasic.ThreadName;

/**
 * @ Author txb
 * @ Date 2021/8/3 15:41
 */
public class SubThread2 extends Thread {

    public SubThread2(){
        System.out.println("构造方法中线程名："+Thread.currentThread().getName());
        // this 代表的是当前对象
        System.out.println("构造方法中this线程名"+ this.getName());
    }

    @Override
    public void run() {
        System.out.println("run方法中线程名："+Thread.currentThread().getName());
        System.out.println("run方法中this线程名"+ this.getName());
    }
}
