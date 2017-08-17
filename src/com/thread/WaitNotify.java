package com.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by qiaojiange on 2017/5/15.
 */
public class WaitNotify {
    public static final String WAIT_THREAD = "WaitThread";
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args, String notifyThread1) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), WAIT_THREAD);
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);

        Thread notifyThread = new Thread(new Notify(), notifyThread1);
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
//        加锁，拥有lock的monitor
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread()+"flag is true.wait @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足，执行任务
                System.out.println(Thread.currentThread()+"flag is false.running @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
//            加锁，拥有lock的Monitor
            synchronized (lock) {
                System.out.println(Thread.currentThread()+" hold lock.notify @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notify();
                flag = false;
                SleepUtils.second(5);
            }

            synchronized(lock){
                System.out.println(String.format(Thread.currentThread() + " hold lock again.sleep @ " + new SimpleDateFormat("HH:mm:ss").format(new Date())));
                SleepUtils.second(5);
            }
        }
    }

}
