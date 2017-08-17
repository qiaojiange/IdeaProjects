package com.arigothem;


/**
 * Created by qiaojiange on 2017/4/17.
 */
public class Test {
    private static volatile  boolean isFlag = false;

    public static void main(String[] args) {

        System.out.println("main start!");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                int[] num = new int[]{1,2,2,3,3,3,4,4,4,5,54,54};
                int id = 300;

                MyThread myThread = new MyThread(num,id);
                myThread.start();

                while (!isFlag);

                num = null;
                id = 100;
            }
        });
        thread.start();

        System.out.println("thread end!");

//        try {
//            Thread.sleep(1000*10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("main end!");

    }


    static class MyThread extends Thread{
        private int[] num;
        private int id;

        public MyThread(int[] num, int id) {
            this.num = num;
            this.id = id;
        }

        @Override
        public void run() {
            for(int i:num){
                System.out.println(i);
            }
            System.out.println("id = "+id);
            isFlag = true;

        }
    }

}
