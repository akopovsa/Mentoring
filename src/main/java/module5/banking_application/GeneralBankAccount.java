package module5.banking_application;

public abstract class GeneralBankAccount {

    public abstract void add(double amount);
    public abstract void withdraw(double amount);
    public abstract void calculateFee();

    public abstract void registerObserver(Observer o);
    public abstract void removeObserver(Observer o);
    public abstract void notifyObservers ();

}
