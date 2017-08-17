package com.thread;

import com.sun.org.glassfish.external.statistics.Statistic;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qiaojiange on 2017/5/16.
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);

//    保证所有ConnectionRunner能够同时开始
    static CountDownLatch start = new CountDownLatch(1);

//    main 线程将会等待所有ConnectionRunner结束后才能继续执行
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        //线程数据，可以修改线程数量进行观察
        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectionRunnerThread");
            thread.start();
        }

        start.countDown();
        end.await();
        System.out.println("total invoke: "+(threadCount * count));
        System.out.println("got connection: "+got.get());
        System.out.println("notGot connection: "+notGot.get());
    }

    static class ConnectionRunner implements Runnable{

        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0){
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection !=null){
//                        System.out.println("connection !=null");
                            try {
                                connection.createStatement();
                                connection.commit();
                            }
                            finally {
//                                System.out.println("got should increment");
                                //为啥打印不出来？？？
//                                System.out.println("got = "+ got);
                                got.incrementAndGet();
                                pool.releaseConnection(connection);
                            }
                    }else{
//                        System.out.println("notGot.incrementAndGet();");
                        notGot.incrementAndGet();
                    }
                }catch (Exception ex){
                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
