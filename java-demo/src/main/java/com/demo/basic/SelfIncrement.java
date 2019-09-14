package com.demo.basic;

/**
 * Description: 自增或者自减
 *  i++和++i的区别
 * 自增到底在前在后，我们可以关注自增符号++的位置。
 * 我们可以看到i++，自增符号在后面，所以是做完别的事才自增。
 * 同样的可看到++i，自增符号在前面，所以是先自增变量自己。
 * i++：先将i赋给结果，然后变量i再自增
 * ++i：i变量先自增，然后再赋给结果
 * i++：先使用再自增。变量会增1，结果不会
 * ++i：先自增再使用。变量和结果都会增1
 *
 * @author zys
 */
public class SelfIncrement {


    public static void main(String[] args) {

        int i=1;
        int result1=i++;
        System.out.println(" i=1，i++结果：  i="+i+"  result1="+result1);
        int j=1;
        int result2=++j;
        System.out.println(" j=1，++j结果：  j="+j+"  result2="+result2);

        // i=1，i++结果：  i=2  result1=1
        // j=1，++j结果：  j=2  result2=2
    }
}
