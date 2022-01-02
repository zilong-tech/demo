package com.demo.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo03 {

    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = 100;
            System.out.println("一阶段：" + result);
            return result;
        }).thenApply(number -> {
            int result = number * 3;
            System.out.println("二阶段：" + result);
            return result;
        });
    }


}
