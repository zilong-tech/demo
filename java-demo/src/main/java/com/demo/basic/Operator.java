package com.demo.basic;

/**
 * Description:运算符
 * <p>
 * Create on 2019/09/14
 *
 * @author zys
 */
public class Operator {

    public static void main(String[] args) {
        int i = 3&5;
        int y = 5&7;
        System.out.println("i="+i +"\ty=" +y); // i=1 y=5


        String str = null;
        if(str != null && 1/0 == 0){
            System.out.println(" && 第一个表达式false，后续不在执行");
        }else {
            System.out.println("执行这里");
        }

        int x = 6|2;
        System.out.println(x); // 6


        System.out.println(5^9);  // 12

        System.out.println(5 <<2); // 20

        System.out.println( 5 >>2); // 1

        System.out.println(~5); // -6

        System.out.println(15 >>>2); // 3

        System.out.println(-6>>>3); // 536870911
    }
}
