package module3.accounting;

public class Accounting {
    public static double pay(double working_hour, double per_hour_payment){
        double payment = working_hour*per_hour_payment;
        return payment;
    }
}
