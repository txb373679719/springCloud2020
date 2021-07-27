package com.txb.study.test.thread;

public class ThreadAndRunableDemo {

    public static void main(String[] args)  {
        // new 出来的是两个对象
//        new MyThread().start();
//        new MyThread().start();


        MyThread2 myThread = new MyThread2();
        new Thread(myThread).start();
        new Thread(myThread).start();

    }

    //负责的线程操作 继承thread
    static  class  MyThread extends  Thread{
        private  int ticket = 5;
        @Override
        public void run() {
            while (true){
                System.out.println("Thread ticket = "+ticket--);
                if(ticket<0){break;}
            }
        }
    }

    // 简单的执行任务：实现Runnable
    static  class   MyThread2 implements  Runnable{
        private  int ticket = 5;
        @Override
        public void run() {
            while (true){
                System.out.println("Thread ticket = "+ticket--);
                if(ticket<0){break;}
            }
        }
    }
}
