package com.roger;

import com.roger.component.Programmer;
import com.roger.proxy.CglibProxy;
import net.sf.cglib.proxy.Enhancer;

public class CglibProxyMain {

    public static void main(String[] args) {
        //要代理的类
        Programmer programmer = new Programmer();
        //代理类
        CglibProxy cglibProxy = new CglibProxy();
        //Cglib的加强器 创建动态代理类的
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(programmer.getClass());
        //设置回调
        //这里相当于是对于代理类上所有方法的调用,都会调用CallBack
        //而Callback则需要实行intercept()方法进行拦截
        enhancer.setCallback(cglibProxy);

        Programmer proxy = (Programmer) enhancer.create();
        proxy.code();
    }
}
