package com.demo.designMode.mediatorpattern2;

/**
 * 抽象中介者
 */
public interface Mediator {

    void register(String dname,Department d);

    void command(String dname);
}
