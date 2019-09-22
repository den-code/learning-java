package com.davtsin.concurrent.withdraw;

public class WithdrawTask implements Runnable {

    private BankAccount account = new BankAccount(100);
    private int amount;
    private int iteration;
    private int sleepTime;

    public WithdrawTask(int amount, int iteration, int sleepTime) {
        this.amount = amount;
        this.iteration = iteration;
        this.sleepTime = sleepTime;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        withdrawTask();
    }

    private void withdrawTask() {
        for (int i = 0; i < iteration; i++) {
            withdrawFromBalance(amount);
            if (account.getBalance() <= 0) {
                System.out.println("Credit limit! Balance is " + account.getBalance());
            }
        }
    }

    private synchronized void withdrawFromBalance(int amount) {
        String threadName = Thread.currentThread().getName();
        System.out.println("### START " + threadName + " TRANSACTION ###");

        System.out.println(threadName + " is trying to withdraw " + amount + ". Checking balance...");
        if (account.getBalance() >= amount) {
            int balance = account.getBalance();
            System.out.println(threadName + " sees, that balance is " + balance);
            System.out.println(threadName + " going to sleep");

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadName + " is get up and withdraw amount " + amount +
                    ". Balance before sleep was " + balance + ". Current balance is " + account.getBalance());
            account.withdraw(amount);
            System.out.println("### END " + threadName + " TRANSACTION ###");
        } else {
            System.out.println("Balance withdraw error. No money. Balance is " + account.getBalance() +
                    " but withdraw amount is " + amount);
            System.out.println("### END " + threadName + " TRANSACTION ###");
        }
    }
}
