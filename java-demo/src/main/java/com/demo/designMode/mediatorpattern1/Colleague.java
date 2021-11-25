package com.demo.designMode.mediatorpattern1;

/**
 * 抽象同事类
 * @version 1.0.0
 * @date 2021/11/25 17:31
 */
public abstract class Colleague {

    protected Mediator mediator;

    public void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();

}
