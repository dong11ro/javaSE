package mylab.bank.entity;

import mylab.bank.exception.InSufficientBalanceException;
import mylab.bank.exception.WithdrawlLimitExceededException;

public class CheckingAccount extends Account{
    private double withdrawlLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawlLimit){
        super(accountNumber, ownerName, balance);
        this.withdrawlLimit = withdrawlLimit;
        System.out.println("체킹 계좌가 생성되었습니다: 계좌번호: " + accountNumber +
                ", 소유자: " + ownerName + ", 잔액: " + balance + "원, 출금 한도: " + withdrawlLimit + "원");
    }

    public double getWithdrawlLimit() {
        return withdrawlLimit;
    }

    @Override
    public void withdraw(double amount) throws WithdrawlLimitExceededException, InSufficientBalanceException {
        // exception 로직 예외 발생: 출금 한도를 초과했습니다. 한도: 5000.0원
        if (amount > this.balance){
            throw new InSufficientBalanceException("잔금 한도를 초과했습니다. 한도: " + this.balance + "원");
        }
        if (amount > this.withdrawlLimit){
            throw new WithdrawlLimitExceededException("출금 한도를 초과했습니다. 한도: " + this.withdrawlLimit + "원");
        }
        this.balance -= amount;
    }

    @Override
    public String toString(){
        return (super.toString() + ", 출금 한도: " + this.withdrawlLimit + "원");
    }
}
