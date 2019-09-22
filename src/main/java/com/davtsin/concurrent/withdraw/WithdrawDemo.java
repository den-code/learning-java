package com.davtsin.concurrent.withdraw;

public class WithdrawDemo {
    public static void main(String[] args) {
        WithdrawTask withdrawTask = new WithdrawTask(1, 1000, 5);
        withdrawTask.setAccount(new BankAccount(1000));
        Thread aliceThread = new Thread(withdrawTask);
        Thread bobThread = new Thread(withdrawTask);
        aliceThread.setName("Alice");
        bobThread.setName("Bob");
        aliceThread.start();
        bobThread.start();
    }
}
