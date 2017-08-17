package com.proxy;

/**
 * Created by qiaojiange on 2017/5/25.
 */
public class Client {
    public static void main(String[] args) {
       Subject subject = new ProxySubject();
       subject.request();
    }
}
