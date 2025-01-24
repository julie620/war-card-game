public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit  = suit;
    }
    public String toString() {
        return rank + " of " + suit;
    }
    
    public Rank getRank() {
        return rank;
    }

    public int value() {
        return rank.getValue();
    }

    /* 
    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
    */
}
