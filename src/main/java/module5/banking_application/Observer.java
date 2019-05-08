package module5.banking_application;

public interface Observer {
    void update(int accountNumber, String accountType, int standartPercent, int overdraftPercent, double balance, double withdrawAmount, double feeAmount);
}
