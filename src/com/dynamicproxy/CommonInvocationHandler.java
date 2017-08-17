package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by qiaojiange on 2017/5/26.
 */
public class CommonInvocationHandler implements InvocationHandler {
    private Object target;

    public CommonInvocationHandler(Object target) {
        this.target = target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------------insert code----------");
        return method.invoke(target,args);
    }

}
