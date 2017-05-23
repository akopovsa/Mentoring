package lesson2.mentoring;

/**
 * Created by Saak_Akopov on 5/19/2017.
 */
public class Student extends Human {

    private int level;
    private double price;

    private int getLevel() {
        return level;
    }

    public int setLevel(int level) {
        this.level = level;
        return level;
    }

    public void getinfo(){
        System.out.println("Student level is "+ getLevel());

    }
}
