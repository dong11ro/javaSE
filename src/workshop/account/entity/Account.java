package workshop.account.entity;

import org.w3c.dom.ls.LSOutput;

public class Account {
    private String custId;
    private String acctId;
    private int balance;

    public void setCustId(String custId){
        this.custId = custId;
    }
    public void setAcctId(String custId){
        this.custId = custId;
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

    public void deposit(int amount){
        this.balance += amount;
    }
    public void withdraw(int amount){
        this.balance -= amount;
    }
}
