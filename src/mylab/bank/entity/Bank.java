package mylab.bank.entity;
import com.sun.jdi.connect.Connector;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InSufficientBalanceException;
import mylab.bank.exception.WithdrawlLimitExceededException;

import java.util.List;
import java.util.ArrayList;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank(){
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    public int getNextAccountNumber() {
        return nextAccountNumber;
    }

    public String createSavingsAccount(String accountNumber, String ownerName, double balance, double interestRate){
        this.accounts.add(new SavingsAccount(accountNumber, ownerName, balance, interestRate));
        this.nextAccountNumber += 1;
        return this.accounts.get(accounts.size() - 1).toString();
    }
    public String createCheckingAccounts(String accountNumber, String ownerName, double balance, double withdrawlLimit){
        this.accounts.add(new CheckingAccount(accountNumber, ownerName, balance, withdrawlLimit));
        this.nextAccountNumber += 1;
        return this.accounts.get(accounts.size() - 1).toString();
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }
    public void deposit(String accountNumber, double amount){
        //5000.0원이 입금되었습니다. 현재 잔액: 22000.0원
        Account target;
        try {
            target = this.findAccount(accountNumber);
        }
        catch (AccountNotFoundException e){
            System.out.println("예외 발생: " + e.getMessage());
            return;
        }

        target.deposit(amount);
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + target.getBalance() + "원");
    }
    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InSufficientBalanceException {
        //5000.0원이 출금되었습니다. 현재 잔액: 25000.0원
        Account target;
        try{
            target = this.findAccount(accountNumber);
        }
        catch (AccountNotFoundException e){
            System.out.println("예외 발생: " + e.getMessage());
            return;
        }

        try{
            target.withdraw(amount);
        }
        catch (InSufficientBalanceException e){
            System.out.println("예외 발생: " + e.getMessage());
            return;
        }

        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + target.getBalance() + "원");
    }

    public void transfer(String accountName1, String accountName2, double amount) throws InSufficientBalanceException, AccountNotFoundException {
        //5000.0원이 출금되었습니다. 현재 잔액: 25000.0원
        //5000.0원이 입금되었습니다. 현재 잔액: 22000.0원
        //5000.0원이 AC1002에서 AC1001로 송금되었습니다.
        this.deposit(accountName1, amount);
        this.withdraw(accountName2, amount);
        System.out.println(amount + "원이 " + accountName2 + "에서 " + accountName1 + "로 송금되었습니다.");
    }


    public void printAllAccounts(){
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account account : accounts) {
            account.toString();
        }
        System.out.println("===================");
    }
}
