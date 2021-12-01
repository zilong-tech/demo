package com.demo.designMode.ObserverPattern1;


/**
 * 具体观察者
 * @version 1.0.0
 * @date 2021/12/01 16:46
 */
public class ConcreteObserver implements Observer {

    /**
     * 实现更新方法
     */
    @Override
    public void update() {
        System.out.println("接收到信息，并进行处理！");

    }
}
