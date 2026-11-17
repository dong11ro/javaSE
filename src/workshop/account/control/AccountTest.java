package workshop.account.control;

import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class AccountTest {
    public static void main(String[] args) {
        try {
            Account account = new Account();
            account.setAcctId("A1100");
            account.setCustId("221-22-3477");
            account.deposit(10000);

            System.out.println("account Id: " + account.getAcctId());
            System.out.println("customer Id: " + account.getCustId());
            System.out.println("balance: " + account.getBalance());
            account.withdraw(20000);

            System.out.println("balance: " + account.getBalance());

            Account account2 = new Account("A1105", "221-22-3488", 100000);
            System.out.println("account Id: " + account2.getAcctId());
            System.out.println("customer Id: " + account2.getCustId());
            System.out.println("balance: " + account2.getBalance());

            //toString() 왜 이렇게 되는거지 ? println에 toString이 있으면은(?) 이게 가능하다.
            account.withdraw(5000000);
            System.out.println(account2);
        }
        catch (InsufficientBalanceException e){
            System.out.println("Error Message" + e.getMessage() + e.getCurrentBalance());
        }
    }
}
