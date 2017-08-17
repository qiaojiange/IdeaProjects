package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by qiaojiange on 2017/5/25.
 */
public class InvokeTester {
    public int add(int parameter1 ,int parameter2){
        return parameter1+parameter2;
    }

    public String echo(String message){
        return "Hello "+message;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> classType = InvokeTester.class;
        Method[] methods = classType.getDeclaredMethods();
        for(Method method:methods){
            System.out.println(method.getName());
        }

        Object invokeTester = classType.newInstance();


        Method addMethod = classType.getMethod("add",new Class[]{int.class,int.class});
        Object res = addMethod.invoke(invokeTester,new Object[]{1,2});
        System.out.println((Integer)res);

        System.out.println("------------------");
        Method echoMethod = classType.getMethod("echo",new Class[]{String.class});
        Object res2 = echoMethod.invoke(invokeTester,new Object[]{"message"});
        System.out.println((String)res2);
    }

}
