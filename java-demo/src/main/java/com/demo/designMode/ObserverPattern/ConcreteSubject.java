package com.demo.designMode.ObserverPattern;

/**
 * 具体被观察者
 * @version 1.0.0
 * @date 2021/12/01 17:04
 */
public class ConcreteSubject extends Subject{

    //具体的业务
    public void doSomething(){
        /*
         * do something
         */
        super.notifyObservers();
    }

}
