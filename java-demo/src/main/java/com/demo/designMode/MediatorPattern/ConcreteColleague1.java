package com.demo.designMode.MediatorPattern;

/**
 * 具体同事1
 * @version 1.0.0
 * @date 2021/11/25 17:37
 */
public class ConcreteColleague1 extends Colleague{

    @Override
    public void receive() {
        System.out.println("具体同事类1收到请求。");
    }

    @Override
    public void send() {
        System.out.println("具体同事类1发出请求。");
        //请中介者转发
        mediator.relay(this);
    }

}
