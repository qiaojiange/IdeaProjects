package com.dynamicproxy;



/**
 * Created by qiaojiange on 2017/5/25.
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("from real subject!");
    }
}
