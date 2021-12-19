package com.demo.designMode.builderpattern1;

/**
 * 产品类：包含多个组成部件的复杂对象
 * @version 1.0.0
 * @date 2021/12/15 17:28
 */
public class Product {

    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }
    public void setPartB(String partB) {
        this.partB = partB;
    }
    public void setPartC(String partC) {
        this.partC = partC;
    }

    public String getPartA() {
        return partA;
    }

    public String getPartB() {
        return partB;
    }

    public String getPartC() {
        return partC;
    }

    public void show() {
        //显示产品的特性
        System.out.println(getPartA() + " " + getPartB() + " " + getPartC());
    }
}
