package com.demo.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class CompletableFutureDemo06 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> futrue1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int number = new Random().nextInt(3) + 1;
                try {
                    TimeUnit.SECONDS.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第一阶段：" + number);
                return number;
            }
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int number = new Random().nextInt(3) + 1;
                try {
                    TimeUnit.SECONDS.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第二阶段：" + number);
                return number;
            }
        });

        futrue1.thenAcceptBoth(future2, new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer x, Integer y) {
                System.out.println("最终结果：" + (x + y));
            }
        });

        future2.get();
    }
}
