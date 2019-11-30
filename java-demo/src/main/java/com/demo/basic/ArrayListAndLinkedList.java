package com.demo.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Description: arrayList for循环效率高，linedlist Iterator效率高
 * ArrayList 对于随机位置的add/remove，时间复杂度为 O(n),但是对于列表末尾的添加/删除操作,时间复杂度是 O(1).
 * LinkedList对于随机位置的add/remove，时间复杂度为 O(n),但是对于列表 末尾/开头 的添加/删除操作,时间复杂度是 O(1).
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
//                8848700 <--ArrayList add
//        17676700 <--LinkedList add
//                -------------------------
//                7474700 <--ArrayList get
//        4582492100 <--LinkedList get
//                ---------------------循环对比
//        2788000 <--ArrayList foreach
//        47490700 <--ArrayList Iterator
//        1098600 <--ArrayList for
//        -------------------------
//                4365500 <--linkedList foreach
//        10721400 <--linkedList Iterator
//        3775830200 <--linkedList for
//        -------------------------
//                4442300 <--ArrayList remove
//        8909600 <--LinkedList remove


    }
}
