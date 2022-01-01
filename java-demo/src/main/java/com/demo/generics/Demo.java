package com.demo.generics;

public interface Demo<T1,T2> {

    void test1(T1 t1);
    void test2(T2 t2);
}

class DemoImpl implements Demo<String,Integer> {

    @Override
    public void test1(String s) {

    }

    @Override
    public void test2(Integer integer) {

    }


}
class  Demo2<T1,T2> implements Demo<T1,T2>{

    @Override
    public void test1(T1 t1) {

    }

    @Override
    public void test2(T2 t2) {

    }
}