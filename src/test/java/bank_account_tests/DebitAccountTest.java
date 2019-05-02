package bank_account_tests;

import static org.junit.Assert.assertEquals;

import module5.banking_application.BankAccount;
import org.junit.Before;
import org.junit.Test;

public class DebitAccountTest {
    private BankAccount debitAccount;

    @Before
    public void createAccount(){
        debitAccount = new BankAccount("debit", 1);
    }

    @Test
    public void checkAccountType(){
        assertEquals("debit",  debitAccount.getAccountType());
    }

    @Test
    public void checkAccountPercentage(){

        assertEquals(1,  debitAccount.getStandartPercent());
    }

    @Test
    public void addAmountToAccountPositive(){
        debitAccount.add(10000);
        assertEquals(10000.0,  debitAccount.getBalance(),0.0);
    }

    @Test(expected = RuntimeException.class)
    public void addAmountToAccountNegative(){
        debitAccount.add(-10000);
        assertEquals(0.0,  debitAccount.getBalance(),0.0);
    }

    @Test
    public void withdrawAmountPositive(){
        debitAccount.add(10000);
        debitAccount.withdraw(2000.0);
        assertEquals(8000.0,  debitAccount.getBalance(),0.0);
    }

    @Test
    public void withdrawAmountNegative(){
        debitAccount.add(10000);
        debitAccount.withdraw(11000.0);
        assertEquals(10000.0,  debitAccount.getBalance(),0.0);
    }

    @Test
    public void calculateAndWithdrawalFee(){
        debitAccount.add(10000);
        debitAccount.calculateFee();
        assertEquals(9900.0,  debitAccount.getBalance(),0.0);
    }

}
