package com.test1;

/**
 * Created by qiaojiange on 2017/5/29.
 */
public class Run2 {
    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {
        if ( t1.get() == null){
            System.out.println("从未放过值");
            t1.set("第一次放入值");
        }
        System.out.println("t1.get() == "+ t1.get());
        System.out.println("t1.get() == "+ t1.get());
    }
}
