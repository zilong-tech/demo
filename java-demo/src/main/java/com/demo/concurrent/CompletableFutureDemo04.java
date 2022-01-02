package com.demo.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureDemo04 {

    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        int number = new Random().nextInt(30);
                        System.out.println("第一阶段：" + number);
                        return number;
                    }
                })
                .thenCompose(new Function<Integer, CompletionStage<Integer>>() {
                    @Override
                    public CompletionStage<Integer> apply(Integer param) {
                        return CompletableFuture.supplyAsync(new Supplier<Integer>() {
                            @Override
                            public Integer get() {
                                int number = param * 2;
                                System.out.println("第二阶段：" + number);
                                return number;
                            }
                        });
                    }
                });
    }
}
