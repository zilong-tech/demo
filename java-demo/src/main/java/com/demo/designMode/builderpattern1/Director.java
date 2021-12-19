package com.demo.designMode.builderpattern1;

/**
 * @author 导演类:调用建造者中的方法完成复杂对象的创建。
 * @version 1.0.0
 * @date 2021/12/15 17:54
 */
public class Director {

    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
