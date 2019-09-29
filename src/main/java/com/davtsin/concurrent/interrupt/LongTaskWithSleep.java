package com.davtsin.concurrent.interrupt;

public class LongTaskWithSleep implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Long task...");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Long task interrupted when sleeping");
        } finally {
            System.out.println("long task finally");
        }
    }
}
