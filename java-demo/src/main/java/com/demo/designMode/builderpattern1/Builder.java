package com.demo.designMode.builderpattern1;

/**
 * 抽象建造者：包含创建产品各个子部件的抽象方法。
 * @version 1.0.0
 * @date 2021/12/15 17:30
 */
public abstract class Builder {

    //创建产品对象
    protected Product product = new Product();
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }
}
