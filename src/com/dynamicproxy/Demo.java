package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by qiaojiange on 2017/5/26.
 */
public class Demo {
    public static void main(String[] args) {
        FooImp1 fooImp1 = new FooImp1();

        CommonInvocationHandler handler = new CommonInvocationHandler(fooImp1);
        Foo foo = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),new Class[]{Foo.class},handler);


//       错误原因是Foo本身是一个接口，通过Foo.class.getInterfaces(),是获取不到他的接口的
//       Foo foo = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),Foo.class.getInterfaces(),handler);
        foo.doAction();


        Foo foo2 = new FooImp2();
        handler.setTarget(foo2);
        foo = (Foo)Proxy.newProxyInstance(Foo.class.getClassLoader(),new Class[]{Foo.class},handler);
        foo.doAction();

    }
}
