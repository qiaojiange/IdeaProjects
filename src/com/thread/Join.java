package com.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by qiaojiange on 2017/5/16.
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous),String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+" terminate");

    }

    static class Domino implements Runnable{
        private Thread prev;

        public Domino(Thread prev) {
            this.prev = prev;
        }


        @Override
        public void run() {
            try {
                prev.join();
                System.out.println(Thread.currentThread().getName()+" terminate.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
