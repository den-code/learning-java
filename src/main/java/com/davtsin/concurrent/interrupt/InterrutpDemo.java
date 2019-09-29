package com.davtsin.concurrent.interrupt;

public class InterrutpDemo {
    public static void main(String[] args) {
        InterrutpDemo interrutpDemo = new InterrutpDemo();
//        interrutpDemo.longTaskTest(new LongTask());
        interrutpDemo.longTaskTest(new LongTaskWithSleep());
    }

    private void longTaskTest(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}
