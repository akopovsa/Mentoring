package lesson2.mentoring;

/**
 * Created by Saak_Akopov on 5/19/2017.
 */
public class Tutor extends Human {

    private double price_per_hour;

    public double setPrice_per_hour(double price_per_hour) {
        this.price_per_hour = price_per_hour;
        return price_per_hour;
    }

    public void getinfo(double lesson_duration, double tutor_price ){
        System.out.println("Tutor salary is: "+ lesson_duration * tutor_price);
    }



}
