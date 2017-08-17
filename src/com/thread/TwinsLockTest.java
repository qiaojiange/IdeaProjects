package com.thread;

import javafx.concurrent.Worker;
import org.junit.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import static org.junit.Assert.*;

/**
 * Created by qiaojiange on 2017/5/18.
 */
public class TwinsLockTest {

    @org.junit.Test
    public void test(){
       final  Lock lock = new TwinsLock();

       class Worker extends Thread{
           public void run(){
               while (true){
                   lock.lock();
                   try {
                       SleepUtils.second(1);
                       System.out.println(Thread.currentThread().getName());
                       SleepUtils.second(1);
                   }finally{
                       lock.unlock();
                   }

               }
           }
       }

        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }

    }
}