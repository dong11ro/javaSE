package workshop.account.exception;

/*
    Account 잔액(balance)가 부족할 때 사용되는 사용자 정의 예외 Exception class
*/
public class InsufficientBalanceException extends Exception{
    //현재 잔액
    private int currentBalance;

}
