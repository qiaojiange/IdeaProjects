package com.arigothem;

/**
 * Created by qiaojiange on 2017/4/17.
 */
public class A {
    public int m = 5;
    public Object object = new Object();

    public int fun(int m,Object object){
        m = 6;//今天就栽在这了。
        object = null;
        return m;
    }
    public int fun1(int m1,Object object){
        m1 = 6;
        object = null;
        return m1;
    }
}
