import java.util.Comparator;

public class Card implements Comparable<Card>{
    //Create object Card with 2 attributes: rank and suit.
    private int rank; // 0-12 from 2 to Ace
    private int suit; // 0-3 from Clubs, Diamonds, Hearts, Spades

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }
    // get methods
    public int getRank() {
        return rank;
    }
    public int getSuit() {
        return suit;
    }
    
    //toString method
    public String toString() {
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
        return ranks[rank] + "_" + suits[suit];
    }
    
    //compareCard 
    public static Comparator<Card> compareCard = new Comparator<Card>() {
        @Override
        public int compare(Card card1, Card card2) {
            if (card1.getRank() > card2.getRank()) {
                return 1;
            } else if (card1.getRank() < card2.getRank()) {
                return -1;
            } else {
                if (card1.getSuit() > card2.getSuit()) {
                    return 1;
                } else if (card1.getSuit() < card2.getSuit()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    };

    @Override
    public int compareTo(Card other) {
        if (this.getRank() > other.getRank()) {
            return 1;
        } else if (this.getRank() < other.getRank()) {
            return -1;
        } else {
            if (this.getSuit() > other.getSuit()) {
                return 1;
            } else if (this.getSuit() < other.getSuit()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
