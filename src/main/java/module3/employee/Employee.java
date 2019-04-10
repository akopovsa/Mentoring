package module3.employee;

import java.util.Random;

public class Employee {

    private  String name;
    private  String surname;
    private  int id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int random_id(){
        Random random = new Random();
        int rand_id = random.nextInt(100000);
        return rand_id;
    }

    public void print(){
        System.out.println("=======================");
        System.out.println("Name: "+ name);
        System.out.println("Surname: "+ surname);
        System.out.println("ID: "+ id);
    }

    public Employee() {
        this.id = random_id();
    }

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = random_id();
    }


}
