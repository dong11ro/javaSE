package mylab.bank.exception;

public class WithdrawlLimitExceededException extends InSufficientBalanceException{
    public WithdrawlLimitExceededException(String message){
        super(message);
    }
}
