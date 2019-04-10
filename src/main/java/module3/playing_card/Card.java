package module3.playing_card;

public class Card {

    private String rank;
    private String suite;

    public String getRank() {
        return rank;
    }

    public String getSuite() {
        return suite;
    }

    public Card(String rank, String suite) {
        this.rank = rank;
        this.suite = suite;
    }
}
