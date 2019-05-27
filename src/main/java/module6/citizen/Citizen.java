package module6.citizen;

public class Citizen {
    private String name;
    private String surname;

    Citizen(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }
}
