package module5.banking_application;

import java.time.LocalTime;

public class Logger implements Observer {
    private int accountNumber;
    private String accountType;
    private double balance;
    private double withdrawAmount;
    private double feeAmount;
    private int standartPercent;
    private int overdraftPercent;
    private LocalTime now;

    Logger(BankAccount account) {
        account.registerObserver(this);
    }


    @Override
    public void update(int accountNumber, String accountType, int standartPercent, int overdraftPercent, double balance, double withdrawAmount, double feeAmount) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.standartPercent=standartPercent;
        this.overdraftPercent=overdraftPercent;
        this.withdrawAmount = withdrawAmount;
        this.feeAmount = feeAmount;
        this.now = LocalTime.now();
        addToLog();
    }

    private void addToLog(){
        System.out.println("Time: ["+ now + "]");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: "+ accountType);
        System.out.println("Standart Percent: "+ standartPercent+"%");
        System.out.println("Overdraft Percent: "+ overdraftPercent+"%");
        System.out.println("Current Balance: "+ balance + "$");
        System.out.println("Withdraw Amount: "+ withdrawAmount + "$");
        System.out.println("Fee Amount: "+ feeAmount+ "$");
        System.out.println("======================================");
    }
}
