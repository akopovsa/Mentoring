package bank_account_tests;

import static org.junit.Assert.assertEquals;

import module5.banking_application.BankAccount;
import org.junit.Before;
import org.junit.Test;

public class CreditAccountTest {
    private BankAccount creditAccount;

    @Before
    public void createAccount(){
        creditAccount = new BankAccount("credit", 1,5);
    }

    @Test
    public void checkAccountType(){
        assertEquals("credit",  creditAccount.getAccountType());
    }

    @Test
    public void checkAccountPercentage(){

        assertEquals(1,  creditAccount.getStandartPercent());
    }

    @Test
    public void addAmountToAccountPositive(){
        creditAccount.add(10000);
        assertEquals(10000.0,  creditAccount.getBalance(),0.0);
    }

    @Test(expected = RuntimeException.class)
    public void addAmountToAccountNegative(){
        creditAccount.add(-10000);
        assertEquals(0.0,  creditAccount.getBalance(),0.0);
    }

    @Test
    public void withdrawAmountPositive(){
        creditAccount.add(10000);
        creditAccount.withdraw(2000.0);
        assertEquals(8000.0,  creditAccount.getBalance(),0.0);
    }

    @Test
    public void withdrawInOverdraftAmount(){
        creditAccount.add(10000);
        creditAccount.withdraw(11000.0);
        assertEquals(-1000.0,  creditAccount.getBalance(),0.0);
    }

    @Test
    public void calculateAndWithdrawalFee(){
        creditAccount.add(10000);
        creditAccount.calculateFee();
        assertEquals(9900.0,  creditAccount.getBalance(),0.0);
    }

    @Test
    public void calculateAndWithdrawalFeeInOverdraft(){
        creditAccount.add(10000);
        creditAccount.withdraw(11000.0);
        creditAccount.calculateFee();
        assertEquals(-1050.0,  creditAccount.getBalance(),0.0);
    }

}
