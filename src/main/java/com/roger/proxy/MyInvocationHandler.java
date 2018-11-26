package com.roger.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用代理类方法之前执行");
        Object result = method.invoke(target,args);
        System.out.println("调用代理类方法之后执行");
        return result;
    }


    /**
     * 生成代理对象
     * @return
     */
    public Object getProxy(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] clazzInterface = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader,clazzInterface,this);
    }
}
