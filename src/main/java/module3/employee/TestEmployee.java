package module3.employee;

public class TestEmployee {

    public static void main (String[] args){
        Employee emp1 = new Employee("Tom","Johnson");
        Employee emp2 = new Employee();

        emp1.print();
        emp2.print();
    }
}
