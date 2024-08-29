package training.threads.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 0;
    private final Lock lock = new ReentrantLock();

    public void deposit(int amount) {
        lock.lock();
        try {
            System.out.println("Depositing " + amount);
            balance += amount;
        } finally {
            lock.unlock();
            newBalance();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                System.out.println("Withdrawing " + amount);
                balance -= amount;
            } else {
                System.out.println("Insufficient funds");
            }
        } finally {
            lock.unlock();
            newBalance();
        }
    }

    public void newBalance() {
        System.out.println("\n New Balance: " + balance + "\n");
    }

    public int getBalance() {
        return this.balance;
    }
}