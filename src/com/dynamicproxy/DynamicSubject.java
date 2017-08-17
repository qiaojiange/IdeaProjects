package com.dynamicproxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by qiaojiange on 2017/5/25.
 */
//该代理类的内部属性是Object类型，实际使用的时候通过该类的构造方法传递进来一个对象
//此外，该类还实现了invoke方法，该方法的method.invoke其实是调用被代理对象将要执行的方法，
//方法参数是sub,表示该方法从属于sub,通过动态代理类，我们可以在执行真实对象的方法前后加入自己的
//一些额外方法。
public class DynamicSubject implements InvocationHandler {
    private Subject subject;

    public DynamicSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");

        method.invoke(subject,args);

        System.out.println("after invoke");

        return null;
    }
}
