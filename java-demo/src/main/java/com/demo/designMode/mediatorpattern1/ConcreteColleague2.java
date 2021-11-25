package com.demo.designMode.mediatorpattern1;

/**
 * 具体同事2
 * @version 1.0.0
 * @date 2021/11/25 18:00
 */
public class ConcreteColleague2 extends Colleague{

    @Override
    public void receive() {
        System.out.println("具体同事类2收到请求。");

    }

    @Override
    public void send() {
        System.out.println("具体同事类2发出请求。");
        //请中介者转发
        mediator.relay(this);
    }
}
