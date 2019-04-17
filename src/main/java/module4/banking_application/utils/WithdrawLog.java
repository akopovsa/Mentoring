package module4.banking_application.utils;

import module4.banking_application.BankAccount;

public class WithdrawLog extends Logger {

    public WithdrawLog(BankAccount bankAccount) {
        this.bankAccount=bankAccount;
        this.bankAccount.addLog(this);
    }

    @Override
    public void update() {
        System.out.printf("Withdraw amount: %s , current balance: %s ",this.bankAccount.getWithdrawAmount(), this.bankAccount.getBalance());
        System.out.println(" ");
    }
}
