package com.txb.study.test.threadBasic.DaemonThread;

/**
 * @ Author txb
 * @ Date 2021/8/3 16:54
 */
public class DaemonThread extends  Thread{
    @Override
    public void run() {
        super.run();
        while(true){
            System.out.println("不停循环，如果是守护线程就终止...");
        }
    }
}
