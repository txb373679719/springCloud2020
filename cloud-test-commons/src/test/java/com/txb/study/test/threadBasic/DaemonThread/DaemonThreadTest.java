package com.txb.study.test.threadBasic.DaemonThread;

/**
 * @ Author txb
 * @ Date 2021/8/3 16:54
 * @ Description 守护线程
 */
public class DaemonThreadTest {
    public static void main(String[] args) {
        DaemonThread daemonThread  = new DaemonThread();
        //设置为守护线程，应在线程启动前
        daemonThread.setDaemon(true);
        daemonThread.start();
        for (int i = 0; i <10 ; i++) {
            System.out.println("main 线程执行:"+i);
        }
    }
}
