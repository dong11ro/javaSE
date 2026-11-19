package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InSufficientBalanceException;

import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) throws InSufficientBalanceException, AccountNotFoundException {


        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 계좌 생성 ===");
        System.out.println(bank.createSavingsAccount("AC" + Integer.toString(bank.getNextAccountNumber()),
                "홍길동", 10000.0, 3.0));
        System.out.println(bank.createCheckingAccounts("AC" + Integer.toString(bank.getNextAccountNumber()),
                "김철수", 20000.0, 5000.0));
        System.out.println(bank.createSavingsAccount("AC" + Integer.toString(bank.getNextAccountNumber()),
                "이영희", 30000.0, 2.0));

        bank.printAllAccounts();
        System.out.println("\n" +
                "=== 입금/출금 테스트 ===\n");
        bank.deposit("AC1000", 5000);
        bank.withdraw("AC1001", 3000);

        System.out.println("\n=== 이자 적용 테스트 ===");
        ((SavingsAccount)bank.findAccount("AC1000")).applyInterest();

        System.out.println("\n=== 계좌 이체 테스트 ===");
        bank.transfer("AC1000", "AC1001", 5000.0);

        System.out.println("");
        bank.printAllAccounts();

        bank.withdraw("AC1001", 10000);
        bank.withdraw("AC1000", 100000);
        bank.withdraw("AC9999", 100);
    }
}
