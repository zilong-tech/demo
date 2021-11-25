package com.demo.designMode.mediatorpattern1;

/**
 * 抽象中介者
 * @version 1.0.0
 * @date 2021/11/25 17:30
 */
public abstract class Mediator {


    public abstract void register(Colleague colleague);


    public abstract void relay(Colleague colleague);
}
