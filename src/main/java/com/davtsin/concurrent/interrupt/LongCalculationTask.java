package com.davtsin.concurrent.interrupt;

import java.util.Random;

public class LongCalculationTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Long task...");
        Random random = new Random();
        long num1 = 1496321237;
        long num2 = random.nextLong();
        long counter = 0;
        int sleepTime = 700;
        String threadName = Thread.currentThread().getName();

        try {

            while (((num2 % num1) != 0) && !Thread.currentThread().isInterrupted()) {
                num2 = random.nextInt();
                counter++;
                if (counter % 100_000_000 == 0) {
                    System.out.println(threadName + " is working. Counter=" + counter);
                    System.out.println("Thread going to sleep for " + sleepTime + "ms");

                    Thread.sleep(sleepTime);

                    System.out.println(num2 + " / " + num1 + " = " + num2 / num1);
                    System.out.println("Long task finished. Counter: " + counter);
                }
            }

        } catch (InterruptedException e) {
            System.out.println("ALARM!!!" + threadName + " was interrupted while sleeping");
            Thread.currentThread().interrupt();
        } finally {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Long task finally: " + threadName + " was interrupted");
            } else {
                System.out.println("Long task finally: " + threadName + " was properly ended");
            }
        }
    }
}
