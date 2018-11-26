package com.roger;

import com.roger.pojo.User;
import com.roger.proxy.MyInvocationHandler;
import com.roger.service.UserService;
import com.roger.service.impl.UserServiceImpl;

public class JdkProxyMain {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        MyInvocationHandler handler = new MyInvocationHandler(userService);

        UserService proxy =(UserService) handler.getProxy();

        User user = proxy.findById(20L);
        System.out.println("result = " + user);
    }
}
