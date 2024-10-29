package training.threads.bank;

public class TransactionThread extends Thread {
    private final BankAccount bankAccount;
    private TransactionType type;
    private final int amount;

    public TransactionThread(BankAccount account, TransactionType type, int amount) {
        this.bankAccount = account;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public void run(){
        if(type.equals(TransactionType.Deposit)){
            bankAccount.deposit(amount);
        }
        else{
            bankAccount.withdraw(amount);
        }
    }
}