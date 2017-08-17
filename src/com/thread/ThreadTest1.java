package com.thread;


import com.sun.org.apache.xpath.internal.SourceTree;
import jdk.nashorn.internal.ir.IfNode;
import sun.swing.plaf.synth.DefaultSynthStyle;

import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qiaojiange on 2017/5/16.
 */
public class ThreadTest1 {
    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";
    private static final String _N = "\n";



    private static final Map<String, String> TRANS = new java.util.HashMap<>();

    static {
        TRANS.put(A, B);
        TRANS.put(B, C);
        TRANS.put(C, _N);
        TRANS.put(_N, A);
    }

    private static volatile String currInfo = A;


    public static void main(String[] args) {

        Thread printA = new Thread(new PrintTask(A), "printA");
        Thread printB = new Thread(new PrintTask(B), "printB");
        Thread printC = new Thread(new PrintTask(C), "printC");
//        添加打印回车线程，只是为了好看些，不影响整体思路
        Thread printEnter = new Thread(new PrintTask(_N), "printC");

        printA.start();
        printB.start();
        printC.start();

        printEnter.start();
    }

    public static String getNext(String info) {
        return TRANS.get(info);
    }

    public static class PrintTask implements Runnable {
        private String info;

        public PrintTask(String info) {
            this.info = info;
        }

        @Override
        public void run() {
            while (true) {
                //根据当前的值和加锁的值进行判断，相等进入同步代码块。这样实现互斥。
                if (currInfo == info) {
                    synchronized (currInfo) {
//                        if(info == currInfo){
//                            我认为，不可能有多个线程同时加进入同步代码块，所以不用加if判断，故注去。
//                        }
                        System.out.println(info);
                        currInfo = getNext(info);
                    }
                }
            }
        }
    }
}
