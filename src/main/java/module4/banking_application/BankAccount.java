package module4.banking_application;

import module4.banking_application.utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class BankAccount extends GeneralBankAccount {

    private String accountType;
    private double balance;
    private double withdrawAmount;
    private double feeAmount;
    private List<Logger> logs = new ArrayList<>();

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public double getFeeAmount() {
        return feeAmount;
    }

    @Override
    public void add(double amount) {
        this.balance+=amount;
        notifyLogger();
    }

    @Override
    public void withdraw(double amount) {
        this.withdrawAmount = amount;
        this.balance-=amount;
        notifyLogger();
    }

    @Override
    public void calculateFee(int percents) {
        this.feeAmount=(balance*percents)/100;
        balance-=this.feeAmount;
    }

    public void addLog(Logger log){
        logs.add(log);
    }

    private void notifyLogger(){
        for (Logger log : logs) {
            log.update();
        }
    }

    BankAccount(String accountType) {
        this.accountType = accountType;
    }


}
