package thread.challenge;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        BankAccount1 account1 = new BankAccount1("12345-678", 500.00);
        BankAccount1 account2 = new BankAccount1("98765-432", 1000.00);
 
        new Thread(new Transfer(account1, account2, 10.00), "Transfer1").start();
        new Thread(new Transfer(account2, account1, 55.88), "Transfer2").start();
    }

}

class BankAccount1 {
    private double balance;
    private String accountNumber;
    private ReentrantLock lock = new ReentrantLock();
 
    BankAccount1(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
 
    public boolean withdraw(double amount) {
        if (lock.tryLock()) {
        	try {
        		try {
                    // Simulate database access
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                }
                balance -= amount;
                System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                return true;
			} finally {
				lock.unlock();
			}
        }
        return false;
    }
 
    public boolean deposit(double amount) {
        if (lock.tryLock()) {
        	try {
        		try {
                    // Simulate database access
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                }
                balance += amount;
                System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
                return true;
			} finally {
				lock.unlock();
			}
        }
        return false;
    }
 
    public boolean transfer(BankAccount1 destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            }
            else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account busy. Refunding money\n",
                        Thread.currentThread().getName());
                deposit(amount);
            }
        }
 
        return false;
    }
}
 
class Transfer implements Runnable {
    private BankAccount1 sourceAccount, destinationAccount;
    private double amount;
 
    Transfer(BankAccount1 account1, BankAccount1 account2, double amount) {
        this.sourceAccount = account1;
        this.destinationAccount = account2;
        this.amount = amount;
    }
 
    public void run() {
        while (!sourceAccount.transfer(destinationAccount, amount))
            continue;
        System.out.printf("%s completed\n", Thread.currentThread().getName());
    }
}