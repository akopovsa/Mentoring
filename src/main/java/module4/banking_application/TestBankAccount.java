package module4.banking_application;

import module4.banking_application.utils.BalanceLog;
import module4.banking_application.utils.WithdrawLog;

public class TestBankAccount {
    public static void main (String[] args){
        BankAccount accountDebit = new BankAccount("debit");
        BankAccount accountCredit = new BankAccount("credit");

        new BalanceLog(accountDebit);
        new BalanceLog(accountCredit);
        new WithdrawLog(accountDebit);
        new WithdrawLog(accountCredit);

        accountDebit.add(10000);
        accountDebit.add(1000);
        accountCredit.add(15000);
        accountDebit.withdraw(300);
        accountCredit.withdraw(200);
    }
}
