package com.demo.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo05 {

    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> {
                    int number = new Random().nextInt(10);
                    System.out.println("第一阶段：" + number);
                    return number;
                }).thenAccept(number ->
                        System.out.println("第二阶段：" + number * 5));
    }
}
