package com.demo.cglib;

/**
 * @author zys
 * @version 1.0.0
 * @date 2021/12/16 14:47
 */
public class Dog {

    final public void run(String name) {
        System.out.println("狗"+name+"----run");
    }

    public void eat() {
        System.out.println("狗----eat");
    }
}
