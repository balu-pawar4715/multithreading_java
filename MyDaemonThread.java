package com.ex.multi_thread;

public class MyDaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Auto-saving user data in the background...");
            try {
                // Simulate auto-save operation
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Auto-save daemon interrupted");
                break;
            }
        }
    }
    public static void main(String[] args) {
        MyDaemonThread autoSaveDaemon = new MyDaemonThread();
        autoSaveDaemon.setDaemon(true);
        autoSaveDaemon.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("User is working... step " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("User has finished work. Main thread exiting.");
    }
}
