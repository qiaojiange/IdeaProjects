package com.test1;

/**
 * Created by qiaojiange on 2017/5/29.
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0;i<100;i++){
//            Tools.t1.set("Thread A "+(i+1));
            System.out.println("TheadA get values "+ Tools.t1.get());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
