package com.demo.designMode.MediatorPattern;

/**
 *
 * @version 1.0.0
 * @date 2021/11/25 17:49
 */
public class Client {

    public static void main(String[] args) {

        // 模拟同事之间发送、接收消息
        Mediator md = new ConcreteMediator();

        Colleague c1 = new ConcreteColleague1();
        Colleague c2 = new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("-------------");
        c2.send();
    }
}
