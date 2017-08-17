package com.thread;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import javax.swing.plaf.multi.MultiMenuBarUI;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by qiaojiange on 2017/5/13.
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {

        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(),"BusyRunner");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepThread.isInterrupted :"+ sleepThread.isInterrupted());
        System.out.println("busyThread.isInterrupted :"+ busyThread.isInterrupted());

        SleepUtils.second(10);

    }

    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){

            }
        }
    }
}
