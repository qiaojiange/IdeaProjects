package com.test1;

/**
 * Created by qiaojiange on 2017/5/29.
 */

public class Run4 {

    public static void main(String[] args) {
        try {

            for (int i = 0; i < 100; i++) {
                System.out.println("Thread main -------get value = " + Tools.t1.get());
                Thread.sleep(500);
                ThreadA a = new ThreadA();
                a.start();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
