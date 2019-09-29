package com.davtsin.concurrent.interrupt;

public class LongTask implements Runnable {

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Long task...");
            }
        } finally {
            System.out.println("long task finally");
        }
    }
}
