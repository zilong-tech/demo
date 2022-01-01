package com.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    class Person {
    }

    class Student extends Person {
    }

    //？代表可以接收任意类型
    public static void test1(List<?> list) {

    }

    public static void test2(List<Object> list) {
    }

    //? extends Person限定所有类型是Person以及Person的⼦类，
    public static void test3(List<? extends Person> list) {
    }

    //? super Student限定所有类型是Student以及Student的⽗类
    public static void test4(List<? super Student> list) {
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<Integer> list2 = new ArrayList<>();
        test1(list2);
        List<Object> list3 = new ArrayList<>();
        list3.add(1);
        list3.add("wowo");
        test2(list3);
        List<Person> list4 = new ArrayList<>();
        List<Student> list5 = new ArrayList<>();
        test3(list4);
        test4(list4);


    }
}
