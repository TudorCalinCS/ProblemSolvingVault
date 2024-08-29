package training.threads.bank;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Thread t1 = new TransactionThread(bankAccount, TransactionType.Deposit, 555);
        Thread t2 = new TransactionThread(bankAccount, TransactionType.Deposit, 45);
        Thread t3 = new TransactionThread(bankAccount, TransactionType.Withdraw, 100);
        Thread t4 = new TransactionThread(bankAccount, TransactionType.Deposit, 500);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert (bankAccount.getBalance() == 1000);
        System.out.println("Final balance: " + bankAccount.getBalance());

    }
}
