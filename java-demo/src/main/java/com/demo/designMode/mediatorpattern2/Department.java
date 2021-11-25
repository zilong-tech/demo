package com.demo.designMode.mediatorpattern2;

/**
 * 抽象同事类
 */
public interface Department {

    // 做本部门的事情
    void selfAction();
    // 向总经理发出申请
    void outAction();
}
