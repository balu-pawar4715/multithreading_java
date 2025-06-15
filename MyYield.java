package com.ex.multi_thread;

public class MyYield extends Thread {
    public MyYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - step " + i);
            // Yield control to other threads
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        MyYield t1 = new MyYield("Thread-1");
        MyYield t2 = new MyYield("Thread-2");
        t1.start();
        t2.start();
    }
}
