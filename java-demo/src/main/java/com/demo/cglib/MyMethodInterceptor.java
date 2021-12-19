package com.demo.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zys
 * @version 1.0.0
 * @date 2021/12/16 14:54
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("这里是对目标类进行增强！！！");
        Object object = proxy.invokeSuper(obj, args);
        return object;
    }
}
