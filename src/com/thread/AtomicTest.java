package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qiaojiange on 2017/5/16.
 */
public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        i.incrementAndGet();
        i.incrementAndGet();
        System.out.println("i="+i);
    }
}
