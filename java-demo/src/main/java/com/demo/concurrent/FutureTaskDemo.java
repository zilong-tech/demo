package com.demo.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * @author Fox
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task task = new Task();
        //构建futureTask
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        //作为Runnable入参
        new Thread(futureTask).start();

        System.out.println("主程序继续执行。。");

        System.out.println("task运行结果："+futureTask.get());
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程正在计算");
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += i;
            }
            // 模拟业务执行时间
            Thread.sleep(1000);
            return sum;
        }
    }
}
