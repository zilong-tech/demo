package com.demo.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CompletableFutureDemo11 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture
                .supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        int number = new Random().nextInt(10) + 1;
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
                        int number = new Random().nextInt(10) + 1;
                        try {
                            TimeUnit.SECONDS.sleep(number);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("第二阶段：" + number);
                        return number;
                    }
                });

        future1.acceptEither(future2, new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.println("最快结果：" + number);
            }
        });
        future1.get();
        future2.get();
    }
}
