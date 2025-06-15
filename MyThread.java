package com.ex.multi_thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread is running in a thread!");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
