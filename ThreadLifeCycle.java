package com.ex.multi_thread;

public class ThreadLifeCycle extends Thread {
    public ThreadLifeCycle(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running (RUNNABLE state)");
        try {
            Thread.sleep(1000); // TIMED_WAITING state
            System.out.println(getName() + " woke up from sleep (RUNNABLE state)");
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted");
        }
        System.out.println(getName() + " is finishing (TERMINATED state)");
    }

    public static void main(String[] args) {
        ThreadLifeCycle t1 = new ThreadLifeCycle("Thread-1");
        System.out.println(t1.getName() + " created (NEW state)");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getName() + " has finished (TERMINATED state)");
    }
}
