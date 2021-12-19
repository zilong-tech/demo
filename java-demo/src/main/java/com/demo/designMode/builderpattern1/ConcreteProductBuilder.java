package com.demo.designMode.builderpattern1;

/**
 * 具体建造者：实现了抽象建造者接口。
 * @version 1.0.0
 * @date 2021/12/15 17:34
 */
public class ConcreteProductBuilder extends Builder{

    @Override
    public void buildPartA() {
        product.setPartA("建造 PartA");
    }
    @Override
    public void buildPartB() {
        product.setPartB("建造 PartB");
    }
    @Override
    public void buildPartC() {
        product.setPartC("建造 PartC");
    }
}
