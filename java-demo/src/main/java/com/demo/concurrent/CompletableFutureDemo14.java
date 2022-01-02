package com.demo.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureDemo14 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random();
        CompletableFuture<String> future1 = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(random.nextInt(5));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "hello";
                });

        CompletableFuture<String> future2 = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(random.nextInt(1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "world";
                });
        CompletableFuture<Object> result = CompletableFuture.anyOf(future1, future2);
        result.get();
    }
}
