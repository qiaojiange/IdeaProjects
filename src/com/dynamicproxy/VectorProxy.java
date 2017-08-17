package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

/**
 * Created by qiaojiange on 2017/5/26.
 */
public class VectorProxy implements InvocationHandler{

    private Object proxyObject;

    public VectorProxy(Object obj) {
        this.proxyObject = obj;
    }

    public static Object factory(Object obj){
        Class<?> classType = obj.getClass();
        return Proxy.newProxyInstance(classType.getClassLoader(),classType.getInterfaces(),new VectorProxy(obj));
    }

    public static void main(String[] args) {
        List v  = (List) factory(new Vector());

        v.add("abc");
//        System.out.println(v);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------------------------------"+method);
       // System.out.println("before calling method:"+method);
        if (args!= null){
            for(Object o:args){
                System.out.println(o);
            }
        }
        Object object = method.invoke(proxyObject,args);

        System.out.println("after calling method:"+method);
        return object;
    }
}
