package com.demo.designMode.ObserverPattern2;

/**
 * @author zys
 * @version 1.0.0
 * @date 2021/12/01 18:47
 */
public class ConcreteObserver implements Observer{

    @Override
    public void update(String message) {
        // 模拟处理业务逻辑
        System.out.println("用户收到消息：" + message);
    }
}
