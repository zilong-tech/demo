package com.demo.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureDemo12 {

    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture
                .supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        int number = new Random().nextInt(5);
                        try {
                            TimeUnit.SECONDS.sleep(number);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("第一阶段：" + number);
                        return number;
                    }
                });

        CompletableFuture<Integer> future2 = CompletableFuture
                .supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        int number = new Random().nextInt(5);
                        try {
                            TimeUnit.SECONDS.sleep(number);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("第二阶段：" + number);
                        return number;
                    }
                });

        future1.runAfterEither(future2, new Runnable() {
            @Override
            public void run() {
                System.out.println("已经有一个任务完成了");
            }
        }).join();
    }
}
