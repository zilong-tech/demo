package com.demo.designMode.abstractFactoryPattern;

public abstract class AbstractCreator {

    //创建A产品家族
    public abstract AbstractProductA createProductA();
    //创建B产品家族
    public abstract AbstractProductB createProductB();

}
