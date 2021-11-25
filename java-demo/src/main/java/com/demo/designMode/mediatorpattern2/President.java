package com.demo.designMode.mediatorpattern2;

import java.util.HashMap;
import java.util.Map;

/**
 * 具体中介者  总经理
 */
public class President implements Mediator{

    private Map<String,Department> map = new HashMap    <String , Department>();

    @Override
    public void command(String dname) {
        // 在不改变同事类的情况下，封装一些公共的逻辑
        System.out.println("执行前-----打印日志信息");
        map.get(dname).selfAction();
        System.out.println("执行后-----打印日志信息");
    }

    @Override
    public void register(String dname, Department d) {
        map.put(dname, d);
    }
}
