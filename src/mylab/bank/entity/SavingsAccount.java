package mylab.bank.entity;

public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate){
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
        System.out.println("저축 계좌가 생성되었습니다: 계좌번호: " + accountNumber +
                " , 소유자: " + ownerName + ", 잔액: " + balance + "원, 이자율: " + interestRate + "%");
    }

    public double getInterestRate() {
        return interestRate;
    }
    public void applyInterest(){
        //450.0원이 입금되었습니다. 현재 잔액: 15450.0원
        //이자 450.0원이 적용되었습니다. 현재 잔액: 15450.0원
        this.balance += this.balance * interestRate / 100;
        System.out.println(interestRate + "원이 입금되었습니다. 현재 잔액: " + this.balance + "원");
        System.out.println("이자 " + this.interestRate + "원이 적용되었습니다. 현재 잔액: " + this.balance + "원");
    }

    @Override
    public String toString(){
        return (super.toString() + ", 이자율: " + this.interestRate + "%");
    }
}
