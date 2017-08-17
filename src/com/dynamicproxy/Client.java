package com.dynamicproxy;

import com.proxy.*;
import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by qiaojiange on 2017/5/25.
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        InvocationHandler invocationHandler = new DynamicSubject(realSubject);
        Object object = Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),invocationHandler);
        Subject subject = (Subject)object;
        subject.request();

        System.out.println(subject.getClass());
    }
}
