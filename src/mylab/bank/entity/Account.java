package mylab.bank.entity;

import mylab.bank.exception.InSufficientBalanceException;

public class Account extends Object{
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }
    public void withdraw(double amount) throws InSufficientBalanceException {
        // exception 로직
        if (amount > this.balance){
            throw new InSufficientBalanceException("잔금 한도를 초과했습니다. 한도: " + this.balance + "원");
        }
        this.balance -= amount;
    }
    public String toString(){
        return ("계좌번호: " + this.accountNumber + ", 소유자: " + this.ownerName + ", 잔액: " + this.balance + "원");
    }
}
