package module6.citizen;

public class Passport {

    Passport(String series, int number) {
        this.series = series;
        this.number = number;
    }

    private String series;
    private int number;

    String getSeries() {
        return series;
    }

    int getNumber() {
        return number;
    }
}
