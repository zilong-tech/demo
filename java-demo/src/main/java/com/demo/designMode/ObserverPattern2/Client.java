package com.demo.designMode.ObserverPattern2;

/**
 * @author zys
 * @version 1.0.0
 * @date 2021/12/01 18:48
 */
public class Client {

    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();
        // 这里假设是添加好友
        subject.attach(new ConcreteObserver());
        ConcreteObserver twoObserver = new ConcreteObserver();
        subject.attach(twoObserver);

        // 发送朋友圈动态
        subject.notifyObservers("第一个朋友圈消息");

        subject.detach(twoObserver);
        subject.notifyObservers("第二个朋友圈消息");
    }
}
