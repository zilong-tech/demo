package com.demo.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 */
public class ReentrantLockTest {

    public static void main(String[] args) {

    }


    public static class MyService{

        private Lock lock = new ReentrantLock();

        public void testMethod(){
            for(int i= 0; i< 5 ;i++){
                System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
            }
        }
    }
}
