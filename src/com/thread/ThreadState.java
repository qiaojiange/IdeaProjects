package com.thread;


/**
 * Created by qiaojiange on 2017/5/12.
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waitting(),"WaitingThread").start();
        new Thread(new Blocked(),"BlockedThread-1").start();
        new Thread(new Blocked(),"BlockedThread-2").start();

    }


     static class TimeWaiting  implements Runnable {

        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }

    private static class Waitting implements Runnable {
        @Override
        public void run() {
            while (true){
                synchronized (Waitting.class){
                    try {
                        Waitting.class.wait();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    SleepUtils.second(100);
                }
            }
        }
    }


}
