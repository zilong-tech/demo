package com.demo.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo07 {

    public static void main(String[] args) {

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            int number = new Random().nextInt(10);
            System.out.println("第一阶段：" + number);
            return number;
        }).thenRun(new Runnable() {
            @Override
            public void run() {
                System.out.println("thenRun 执行");
            }
        });

    }
}
