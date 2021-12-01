package com.demo.designMode.ObserverPattern2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zys
 * @version 1.0.0
 * @date 2021/12/01 18:43
 */
public class ConcreteSubject implements Subject{

    // 订阅者容器
    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        // 添加订阅关系
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        // 移除订阅关系
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        // 通知订阅者
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
