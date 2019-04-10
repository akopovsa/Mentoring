package module3.playing_card;

public class Deck {

    private static Card[] deck;

    public static void set_deck(){
        String[] rank = {"ACE","KING","QUEEN","JACK", "10", "9", "8", "7", "6"};
        String[] suite = {"Spades","Hearts","Diamonds", "Clubs"};
        Card[] cards = new Card[36];
        int i=0;
            for(String r:rank){
                for(String s:suite){
                    Card card = new Card(r,s);
                    cards[i] = card;
                    i++;
                }
            }
        System.out.println("New deck created:");
        deck = cards;
    }


    public static void draw_a_card(){
        for(Card c:deck){
            System.out.println(c.getRank()+" of "+ c.getSuite());
        }
    }

}
