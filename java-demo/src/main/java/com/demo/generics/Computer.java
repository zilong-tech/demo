package com.demo.generics;

import lombok.Data;

/*
 * 泛型类
 * Java库中 E表示集合的元素类型，K 和 V分别表示表的关键字与值的类型
 * T（需要时还可以用临近的字母 U 和 S）表示“任意类型”
 */
@Data
public class Computer<T> {
    
    private T name;
    private T price;

    public Computer() {
    }

    public Computer(T name, T price) {
        this.name = name;
        this.price = price;
    }

    // 省略setter、getter方法


    public static void main(String[] args) {
        Computer<String> computer = new Computer<>();
        computer.setName("xiaomi");
        computer.setPrice("2999");
    }
}