package com.demo.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 */
public class ReentrantLockTest {

    public static void main(String[] args) {

        MyService myService = new MyService();

        Thread thread1 = new Thread(() -> myService.testMethod());
        Thread thread2 = new Thread(() -> myService.testMethod());
        Thread thread3 = new Thread(() -> myService.testMethod());

        thread1.start();
        thread2.start();
        thread3.start();

        /**输出结果
         * ThreadName=Thread-0 1
         * ThreadName=Thread-0 2
         * ThreadName=Thread-0 3
         * ThreadName=Thread-1 1
         * ThreadName=Thread-1 2
         * ThreadName=Thread-1 3
         * ThreadName=Thread-2 1
         * ThreadName=Thread-2 2
         * ThreadName=Thread-2 3
         *
         * 从运行结果可以看出，当一个线程运行完毕后才把锁释放，其他线程才能执行，其他线程的执行顺序是不确定的。
         */

    }


    public static class MyService{

        //注意lock要声明为全局变量，如果lock变量是局部变量，每个线程执行该方法时都会保存一个副本，
        // 那么每个线程执行到lock.lock()处获取的是不同的锁，所以就不会发生冲突。
        private Lock lock = new ReentrantLock();

        public void testMethod(){
            lock.lock();

            try {
                for(int i= 0; i< 3 ;i++){
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
                }
            } catch (Exception e) {

            }finally {
                lock.unlock();
            }
        }
    }


}
