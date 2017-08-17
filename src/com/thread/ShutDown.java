package com.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by qiaojiange on 2017/5/13.
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
//        Thread countThread = new Thread(new Runner(),"CountThread");
//        countThread.start();
//
//        TimeUnit.SECONDS.sleep(3);
//        countThread.interrupt();
//        System.out.println("countThread interrupt()");
//        TimeUnit.SECONDS.sleep(3);
//        Thread.interrupted();
//        System.out.println("countThread interrupted()");


        MyThread myThread = new MyThread();
        myThread.start();
        TimeUnit.SECONDS.sleep(3);
        myThread.interrupt();
        System.out.println("TimeUnit interrupt()");

        TimeUnit.SECONDS.sleep(3);
        myThread.resumeEx();
        System.out.println("TimeUnit resumeEx()");


        TimeUnit.SECONDS.sleep(3);
        myThread.interrupt();
        System.out.println("TimeUnit interrupt()");



    }

    private static class Runner implements Runnable {
        private long i;
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("count i = " + i);
        }
    }


    private static class MyThread extends Thread{
        private long i;
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("count i = " + i);
        }

        public void resumeEx(){
            Thread.interrupted();
        }
    }
}
