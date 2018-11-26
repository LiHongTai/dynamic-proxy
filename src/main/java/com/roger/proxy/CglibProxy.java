package com.roger.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用代理类方法之前执行");
        Object result = methodProxy.invokeSuper(obj,args);
        System.out.println("调用代理类方法之后执行");
        return result;
    }
}
