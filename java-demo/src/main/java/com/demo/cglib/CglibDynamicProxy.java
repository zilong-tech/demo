package com.demo.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理类
 */
public class CglibDynamicProxy implements MethodInterceptor {

    /**
     * 目标对象（也被称为被代理对象）
     */
    private Object target;

    public CglibDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 如何增强
     * @param obj 代理对象引用
     * @param method 被代理对象的方法的描述引用
     * @param args 方法参数
     * @param proxy 代理对象 对目标对象的方法的描述
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("CglibDynamicProxy intercept 方法执行前-------------------------------");

        System.out.println("obj = " + obj.getClass());
        System.out.println("method = " + method);
        System.out.println("proxy = " + proxy);

        Object object = proxy.invoke(target, args);
        System.out.println("CglibDynamicProxy intercept 方法执行后-------------------------------");
        return object;
    }

    /**
     * 获取被代理接口实例对象
     *
     * 通过 enhancer.create 可以获得一个代理对象，它继承了 target.getClass() 类
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        Enhancer enhancer = new Enhancer();
        //设置被代理类
        enhancer.setSuperclass(target.getClass());
        // 如何增强
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }


    public static void main(String[] args) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\");

        // 1. 构造目标对象
        Service target = new Service();

        // 2. 根据目标对象生成代理对象
        CglibDynamicProxy proxy = new CglibDynamicProxy(target);

        // 获取 CGLIB 代理类
        Service proxyObject = proxy.getProxy();

        // 调用代理对象的方法
        proxyObject.finalMethod();
        proxyObject.publicMethod();
    }
}
