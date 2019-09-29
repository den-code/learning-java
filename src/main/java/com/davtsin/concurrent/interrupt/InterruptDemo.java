package com.davtsin.concurrent.interrupt;

public class InterruptDemo {
    public static void main(String[] args) {
        InterruptDemo interrutpDemo = new InterruptDemo();
        interrutpDemo.longCalculationTest(new LongCalculationTask());
    }

    private void longCalculationTest(Runnable runnable) {
        LongCalculationTask longCalculationTask = new LongCalculationTask();
        Thread t1 = new Thread(longCalculationTask);
        Thread t2 = new Thread(longCalculationTask);
        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t1.getName() + "state: " + t1.getState());
        System.out.println(t2.getName() + "state: " + t2.getState());

        t1.interrupt();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.interrupt();
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
