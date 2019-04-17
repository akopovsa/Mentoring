package module4.banking_application.utils;

import module4.banking_application.BankAccount;

public class BalanceLog extends Logger{

    public BalanceLog(BankAccount bankAccount) {
        this.bankAccount=bankAccount;
        this.bankAccount.addLog(this);
    }

    @Override
    public void update() {
        System.out.println("Money added. Current balance: " + this.bankAccount.getBalance());
    }
}
