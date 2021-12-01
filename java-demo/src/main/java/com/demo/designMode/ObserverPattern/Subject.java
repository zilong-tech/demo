package com.demo.designMode.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 * @version 1.0.0
 * @date 2021/12/01 16:39
 */
public class Subject {

    /**
     * 定义一个观察者数组
     */
    private List<Observer> observerList = new ArrayList<>();

    /**
     * 增加一个观察者
     * @param o
     */
    public void addObserver(Observer o){
        this.observerList.add(o);
    }

    /**
     * 删除一个观察者
     * @param o
     */
    public void delObserver(Observer o){
        this.observerList.remove(o);
    }

    /**
     * 通知所有观察者
     */
    public void notifyObservers(){
        for(Observer o :this.observerList){
            o.update();
        }
    }

}
