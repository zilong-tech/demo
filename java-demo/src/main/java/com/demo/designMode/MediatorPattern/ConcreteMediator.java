package com.demo.designMode.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体中介者
 * @version 1.0.0
 * @date 2021/11/25 17:46
 */
public class ConcreteMediator extends Mediator{

    private List<Colleague> colleagues = new ArrayList<Colleague>();

    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }

    @Override
    public void relay(Colleague cl) {
        for (Colleague ob : colleagues) {
            if (!ob.equals(cl)) {
                ((Colleague) ob).receive();
            }
        }
    }
}
