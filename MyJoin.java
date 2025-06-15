package com.ex.multi_thread;

public class MyJoin extends Thread {
    public MyJoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyJoin t1 = new MyJoin("Thread-1");
        MyJoin t2 = new MyJoin("Thread-2");
        t1.start();
        try {
            t1.join(); // main thread waits for t1 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
