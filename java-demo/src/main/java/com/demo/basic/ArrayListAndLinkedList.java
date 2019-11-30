package com.demo.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Description: arrayList for循环效率高，linedlist steam效率高
 * ArrayList 对于随机位置的add/remove，时间复杂度为 O(n),但是对于列表末尾的添加/删除操作,时间复杂度是 O(1).
 * LinkedList对于随机位置的add/remove，时间复杂度为 O(n),但是对于列表 末尾/开头 的添加/删除操作,时间复杂度是 O(1).
 *
 * 对于简单操作，比如最简单的遍历，Stream串行API性能明显差于显示迭代，但并行的Stream API能够发挥多核特性。
 * 对于复杂操作，Stream串行API性能可以和手动实现的效果匹敌，在并行执行时Stream API效果远超手动实现。
 * 所以，如果出于性能考虑，1. 对于简单操作推荐使用外部迭代手动实现，2. 对于复杂操作，推荐使用Stream API，
 * 3. 在多核情况下，推荐使用并行Stream API来发挥多核优势，4.单核情况下不建议使用并行Stream API。
 * <p>
 * Create on 2019/11/30
 *
 * @author zouyongsheng
 */
public class ArrayListAndLinkedList {

    public static void main(String[] args) {


        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        int
//			 times = 10 * 1000;
                times = 100 * 1000;
        // times = 1000 * 1000;
        System.out.println("Test times = " + times);
        System.out.println("-------------------------");
        // ArrayList add
        long startTime = System.nanoTime();

        for (int i = 0; i < times; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration + " <--ArrayList add");

        // LinkedList add
        startTime = System.nanoTime();

        for (int i = 0; i < times; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println(duration + " <--LinkedList add");
        System.out.println("-------------------------");
        // ArrayList get
        startTime = System.nanoTime();

        for (int i = 0; i < times; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println(duration + " <--ArrayList get");

        // LinkedList get
        startTime = System.nanoTime();

        for (int i = 0; i < times; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println(duration + " <--LinkedList get");


        System.out.println("---------------------循环对比");

        Integer test;

        long start = System.nanoTime();
        for (Integer s : arrayList){
            test = s;
        }
        System.out.println(System.nanoTime() - start + " <--ArrayList foreach");

        start = System.nanoTime();

        for (Iterator it = arrayList.iterator(); it.hasNext();){
            test = Integer.valueOf(it.next().toString());

        }
        System.out.println(System.nanoTime() - start+ " <--ArrayList Iterator");

        start = System.nanoTime();
        int size = arrayList.size();
        for (int i = 0; i < size; i++){
            test = arrayList.get(i);

        }
        System.out.println(System.nanoTime() - start +" <--ArrayList for");

        start = System.nanoTime();
        arrayList.stream().forEach(list ->{
            int i = list;
        });
        System.out.println(System.nanoTime() - start +" <--ArrayList 串行steam");

        start = System.nanoTime();
        arrayList.stream().parallel().forEach(list ->{
            int i = list;
        });
        System.out.println(System.nanoTime() - start +" <--ArrayList 并行steam");


        System.out.println("-------------------------");
        start = System.nanoTime();
        for (Integer s : linkedList){
            test = s;
        }
        System.out.println(System.nanoTime() - start + " <--linkedList foreach");

        start = System.nanoTime();

        for (Iterator it = linkedList.iterator(); it.hasNext();){
            test = Integer.valueOf(it.next().toString());

        }
        System.out.println(System.nanoTime() - start+ " <--linkedList Iterator");

        start = System.nanoTime();
        size = linkedList.size();
        for (int i = 0; i < size; i++){
            test = linkedList.get(i);

        }
        System.out.println(System.nanoTime() - start +" <--linkedList for");

        start = System.nanoTime();
        linkedList.stream().forEach(list ->{
            int i = list;
        });
        System.out.println(System.nanoTime() - start +" <--linkedList steam");
        System.out.println("-------------------------");

        // ArrayList remove
        startTime = System.nanoTime();

        for (int i = times - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println(duration + " <--ArrayList remove");

        // LinkedList remove
        startTime = System.nanoTime();

        for (int i = times - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println(duration + " <--LinkedList remove");

//          输出结果
//        Test times = 100000
//                -------------------------
//                11986600 <--ArrayList add
//        25752100 <--LinkedList add
//                -------------------------
//                856300 <--ArrayList get
//        3751935200 <--LinkedList get
//                ---------------------循环对比
//        3291400 <--ArrayList foreach
//        40334500 <--ArrayList Iterator
//        4499900 <--ArrayList for
//        48762100 <--ArrayList steam
//                -------------------------
//                4900200 <--linkedList foreach
//        14752000 <--linkedList Iterator
//        3598482700 <--linkedList for
//        4143200 <--linkedList steam
//                -------------------------
//                4266100 <--ArrayList remove
//        9590800 <--LinkedList remove


    }
}
