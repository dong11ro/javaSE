package workshop.account.entity;

import org.w3c.dom.ls.LSOutput;
import workshop.account.exception.InsufficientBalanceException;

public class Account extends Object{
    private String custId;
    private String acctId;
    private int balance;

    public Account(){

    }
    public Account(String custId, String acctId, int balance){
        this.custId = custId;
        this.acctId = acctId;
        this.balance = balance;
    }
    public void setCustId(String custId){
        this.custId = custId;
    }
    public void setAcctId(String custId){
        this.custId = acctId;
    }
//    public void setBalance(int balance){
//        this.balance = balance;
//    }
    public String getCustId(){
        return this.custId;
    }
    public String getAcctId(){
        return this.acctId;
    }
    public int getBalance(){
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }
    public void withdraw(int amount) throws InsufficientBalanceException{
        if(amount > balance){
            throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액은 ", this.balance);
        }
        this.balance -= amount;
    }
    @Override
    public String toString(){
        return "Account [custId= " + custId + ", acctId= " + acctId + " balance= " + balance + "]";
    }
}
