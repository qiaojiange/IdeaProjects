package com.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by qiaojiange on 2017/5/12.
 */
public class MultiThread {
    public static void main(String[] args){
//        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
//        for (ThreadInfo t : threadInfos){
//            System.out.println("["+t.getThreadId()+"]"+t.getThreadName());
//        }

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo : threadInfos){
            System.out.println("["+threadInfo.getThreadId() +"]"+threadInfo.getThreadName());
        }
    }
}
