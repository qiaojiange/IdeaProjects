package com.thread;

import com.sun.jmx.remote.internal.ClientNotifForwarder;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.Connection;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qiaojiange on 2017/5/16.
 */
public class ThreadTest2 {
//    公平锁和非公平锁的区别
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition aCon,bCon,cCon;

    private static HashMap<Condition,Condition> map = new HashMap<>();
    static {
         aCon = lock.newCondition();
         bCon = lock.newCondition();
         cCon = lock.newCondition();

         map.put(aCon,bCon);
         map.put(bCon,cCon);
         map.put(cCon,aCon);

    }
    public static void main(String[] args) {

        Thread aPrint = new Thread(new PrintThread('A',aCon),"a printThread");
        Thread bPrint = new Thread(new PrintThread('B',bCon),"b printThread");
        Thread cPrint = new Thread(new PrintThread('C',cCon),"c printThread");

        aPrint.start();
        bPrint.start();
        cPrint.start();

    }
    static Condition currCondition = aCon;

    static class PrintThread implements Runnable{
        private  char info;

        private boolean isFirst = true;

        private Condition condition;//这样和第一种思路一样。
        public PrintThread(char info,Condition condition) {
            this.info = info;
            this.condition = condition;
        }

        @Override
        public void run() {
            while (true){
                try {
                    synchronized (lock){
                        if (info != 'A'){
                            try {
                                condition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //isFirst = false;
                        }else{
                            System.out.println(info);
                            Condition nextCondition = getNextCondition(condition);
                            condition.await();
                            nextCondition.signal();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        private static Condition getNextCondition(Condition condition) {
            return map.get(condition);
        }
    }
}
