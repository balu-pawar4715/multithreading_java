package com.ex.multi_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {
    public static void main(String[] args) {
        // 3 threads in the pool
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            service.execute(() -> {
                System.out.println("Task " + taskId + " is running by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Task " + taskId + " was interrupted");
                }
                System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
            });
        }
        service.shutdown();
    }
}
