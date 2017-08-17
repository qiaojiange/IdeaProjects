package com.proxy;

/**
 * Created by qiaojiange on 2017/5/25.
 */
public class ProxySubject implements Subject {
    private RealSubject realSubject;//代理角色内部引用了真实角色

    @Override
    public void request() {
        this.preRequest();//在真实角色操作之前所附加的操作

        if (realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.request();

        this.postRequest();//在真实角色操作之后所附加的操作
    }

    private void preRequest(){
        System.out.println("proxySubject preRequest!");
    }

    private void postRequest(){
        System.out.println("ProxySubject postRequest!");

    }
}
