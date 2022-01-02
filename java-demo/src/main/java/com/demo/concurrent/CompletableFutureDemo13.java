package com.demo.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureDemo13 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture
                .supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("第一阶段：1");
                        return 1;
                    }
                });

        CompletableFuture<Integer> future2 = CompletableFuture
                .supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("第二阶段：2");
                        return 2;
                    }
                });

        future1.runAfterBoth(future2, new Runnable() {
            @Override
            public void run() {
                System.out.println("上面两个任务都执行完成了。");
            }
        });

        future1.get();
        future2.get();
    }
}
