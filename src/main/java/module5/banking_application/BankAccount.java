package module5.banking_application;

import java.util.ArrayList;

public class BankAccount extends GeneralBankAccount{

    private static int accountNumberCounter=0;
    private int accountNumber;
    private String accountType;
    private double balance;
    private double withdrawAmount;
    private double feeAmount;
    private int standartPercent;
    private int overdraftPercent;
    private ArrayList<Observer> observers = new ArrayList<>();


    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public int getStandartPercent() {
        return standartPercent;
    }

    public int getOverdraftPercent() {
        return overdraftPercent;
    }

    @Override
    public void add(double amount){
        if (amount <0){
            throw new IncorrectAmountAdditionException("You can't add negative amount: "+ amount);
        }else {
            this.balance+=amount;
            accountDataChanged();
        }
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

    public BankAccount(String accountType, int standartPercent, int overdraftPercent) {
        this.accountNumber = ++accountNumberCounter;
        this.accountType = accountType;
        this.standartPercent = standartPercent;
        this.overdraftPercent = overdraftPercent;
    }

    public BankAccount(String accountType, int standartPercent) {
        this.accountNumber = ++accountNumberCounter;
        this.accountType = accountType;
        this.standartPercent = standartPercent;

    }


    private class IncorrectAmountAdditionException extends RuntimeException { //not sure why we should use RuntimeException, but we get this in task description
        private IncorrectAmountAdditionException(String errorMessage) {
            super(errorMessage);
        }
    }
}
