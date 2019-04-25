package module4.banking_application;

public class TestBankAccount {
    public static void main (String[] args){
        BankAccount debitAccount = new BankAccount("debit",1);
        Logger loggerDebit = new Logger(debitAccount);
        debitAccount.add(10000);
        debitAccount.add(2000);
        debitAccount.withdraw(200);
        debitAccount.calculateFee();
        debitAccount.withdraw(15000); //Reject, withdraw amount more than current balance amount

        BankAccount creditAccount = new BankAccount("credit",1,5);
        Logger loggerCredit = new Logger(creditAccount);
        creditAccount.add(220000);
        creditAccount.withdraw(250000);
        creditAccount.calculateFee();
    }
}
