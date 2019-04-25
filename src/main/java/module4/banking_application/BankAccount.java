package module4.banking_application;

import java.util.ArrayList;

public class BankAccount extends GeneralBankAccount {

    private static int accountNumber=0;
    private String accountType;
    private double balance;
    private double withdrawAmount;
    private double feeAmount;
    private int standartPercent;
    private int overdraftPercent;
    private ArrayList observers;

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getStandartPercent() {
        return standartPercent;
    }

    public void setStandartPercent(int standartPercent) {
        this.standartPercent = standartPercent;
        accountDataChanged();
    }

    public int getOverdraftPercent() {
        return overdraftPercent;
    }

    public void setOverdraftPercent(int overdraftPercent) {
        this.overdraftPercent = overdraftPercent;
        accountDataChanged();
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
        accountDataChanged();
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
        accountDataChanged();
    }

    @Override
    public void withdraw(double amount) {
        this.withdrawAmount = amount;
        if(accountType.equals("debit") && withdrawAmount>balance){
            System.out.printf("Reject, withdraw amount %s$ more than current balance amount %s$",withdrawAmount,balance);
            System.out.println();
            this.withdrawAmount = 0;
        } else {
            this.balance-=amount;
        }
        accountDataChanged();
        this.withdrawAmount = 0;
    }

    @Override
    public void calculateFee() {
        if(accountType.equals("credit") && balance<0){
            this.feeAmount=Math.abs((balance*overdraftPercent)/100);
            balance-=this.feeAmount;
        }else {
            this.feeAmount=(balance*standartPercent)/100;
            balance-=this.feeAmount;
        }
        accountDataChanged();
        this.feeAmount= 0;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Object o : observers) {
            Observer observer = (Observer) o;
            observer.update(accountNumber, accountType, standartPercent, overdraftPercent, balance, withdrawAmount, feeAmount);
        }
    }

    private void accountDataChanged(){
        notifyObservers();
    }

    BankAccount(String accountType, int standartPercent, int overdraftPercent) {
        observers = new ArrayList();
        accountNumber++;
        this.accountType = accountType;
        this.standartPercent = standartPercent;
        this.overdraftPercent = overdraftPercent;
    }

    BankAccount(String accountType, int standartPercent) {
        observers = new ArrayList();
        accountNumber++;
        this.accountType = accountType;
        this.standartPercent = standartPercent;

    }


}
