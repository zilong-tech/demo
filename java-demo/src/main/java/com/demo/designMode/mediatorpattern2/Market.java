package com.demo.designMode.mediatorpattern2;

/**
 * 具体同事类 市场部
 */
public class Market  implements Department {

    // 持有中介者(总经理)的引用
    private Mediator m;

    public Market(Mediator m) {
        super();
        this.m = m;
        m.register("market", this);
    }

    @Override
    public void outAction() {
        System.out.println("汇报项目承接的进度，需要资金支持");
        // 通过中介者调用同事类，并没有和同事类耦合。
        m.command("finacial");
    }

    @Override
    public void selfAction() {
        System.out.println("谈项目");
    }
}
