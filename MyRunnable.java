package com.ex.multi_thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable is running in a thread!");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
