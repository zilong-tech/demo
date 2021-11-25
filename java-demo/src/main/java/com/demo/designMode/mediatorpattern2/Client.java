package com.demo.designMode.mediatorpattern2;

public class Client {

    public static void main(String[] args) {
        Mediator m = new President();

        Market market = new Market(m);
        Finacial f = new Finacial(m);

        market.selfAction();
        market.outAction();
    }
}
