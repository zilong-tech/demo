package com.demo.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Runnable runnable = () -> System.out.println("执行无返回结果的异步任务");
        CompletableFuture.runAsync(runnable);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行有返回值的异步任务");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "你好 2022";
        });
        String result = future.join();
        System.out.println(result);

    }
}