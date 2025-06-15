package com.ex.multi_thread;

public class MyThreadSchedular extends Thread {
    public MyThreadSchedular(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " is running, step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted");
            }
        }
    }

    public static void main(String[] args) {
        MyThreadSchedular t1 = new MyThreadSchedular("Thread-1");
        MyThreadSchedular t2 = new MyThreadSchedular("Thread-2");
        MyThreadSchedular t3 = new MyThreadSchedular("Thread-3");

        t1.setPriority(Thread.MIN_PRIORITY); // Priority 1
        t2.setPriority(Thread.NORM_PRIORITY); // Priority 5
        t3.setPriority(Thread.MAX_PRIORITY); // Priority 10

        t1.start();
        t2.start();
        t3.start();
    }
}
