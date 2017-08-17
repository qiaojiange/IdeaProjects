package com.test1;

/**
 * Created by qiaojiange on 2017/5/29.
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Tools.t1.set("Thread B----"+(i+1));
            System.out.println("ThreadB get value "+ Tools.t1.get());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
