package com.demo.designMode.ObserverPattern2;

/**
 * @author zys
 * @version 1.0.0
 * @date 2021/12/01 18:34
 */
public interface Subject {

    // 添加订阅关系
    void attach(Observer observer);
    // 移除订阅关系
    void detach(Observer observer);
    // 通知订阅者
    void notifyObservers(String message);

}
