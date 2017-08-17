package com.thread;

/**
 * Created by qiaojiange on 2017/5/12.
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                SleepUtils.second(100);
            }finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
