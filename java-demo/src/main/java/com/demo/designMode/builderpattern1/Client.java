package com.demo.designMode.builderpattern1;

/**
 * @author zys
 * @version 1.0.0
 * @date 2021/12/15 17:58
 */
public class Client {

    public static void main(String[] args) {
        Builder builder = new ConcreteProductBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}
