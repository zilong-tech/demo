package com.demo.basic;

/**
 * Description:可变参数
 * <p>
 * Create on 2019/09/21
 *
 * @author zys
 */
public class VariableParameters {

    public static void main(String[] args) {
            add();
            add(1,2,3);// 可以传递任意个数的参数
            add(new int[]{4,5,6}); // 可以是数组
    }

    /**
     * 注意：可变参数定义在参数的最后，一个方法只能有一个可变参数
     * @param data
     * @return
     */
    public static int add(int ...data){
        int sum = 0 ;
        for(int i=0;i<data.length;i++){
            sum += data[i];
        }
        System.out.println(sum);
        return sum;
    }
}
