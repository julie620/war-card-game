import java.security.SecureRandom;
import java.util.Stack;

public class DeckOfCards {
    private static final int NUMBER_OF_CARDS = 52;
    private static final int DECK_SPLIT = 26;
    private Stack<Card> userDeck = new Stack<>();
    private Stack<Card> compDeck = new Stack<>();

    private Card[] deck = new Card[NUMBER_OF_CARDS];

    public DeckOfCards() {
        int count = 0;
        for (int i = 0; i <13; i++) {
            Rank rank = Rank.values()[i];
            for (int j = 0; j < 4; j++) {
                deck[count] = new Card(rank, Suit.values()[j]);
                count++;
            }
        }
    }

    public void shuffle() {
        SecureRandom randNum = new SecureRandom();
        for (int i = 0; i < deck.length; i++) {
            int randCard = randNum.nextInt(NUMBER_OF_CARDS);

            Card temp = deck[i];
            deck[i] = deck[randCard];
            deck[randCard] = temp;
        }
    }

    public void list() {
        for (int i = 0; i < deck.length; i++) {
            System.out.println(deck[i].toString());
        }
    }

    public void deal() {
        for (int i = 0; i < deck.length; i++) {
            userDeck.push(deck[i]);
            i++;
            compDeck.push(deck[i]);
        }
    }

    public void userHand() {
        for (int i = 0;i < DECK_SPLIT; i++) {
            System.out.println(userDeck.pop());
        }
    }

    public void compHand() {
        for (int i = 0;i < DECK_SPLIT; i++) {
            System.out.println(compDeck.pop());
        }
    }
}
