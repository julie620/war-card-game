import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DeckOfCards {
    private static final int NUMBER_OF_CARDS = 52;
    private Queue<Card> userDeck = new LinkedList<>();
    private Queue<Card> compDeck = new LinkedList<>();

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

    public void deal() {
        for (int i = 0; i < deck.length; i++) {
            userDeck.offer(deck[i]);
            i++;
            compDeck.offer(deck[i]);
        }
    }

    public Boolean gameOn() {
        if (userDeck.isEmpty() || compDeck.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void play() {
        Card userCard = userDeck.peek();
        Card compCard = compDeck.peek();
        System.out.println("Your Card: " + userCard);
        System.out.println("Computer Card: " + compCard);
        if (userCard.value() > compCard.value()) {
            System.out.println("You takes the cards");
            playWin(userDeck, compDeck);
        } else if (userCard.value() < compCard.value()) {
            System.out.println("Computer takes the cards");
            playWin(compDeck, userDeck);
        } else {
            war(userCard, compCard);
        }
    }

    public void playWin(Queue<Card> winner, Queue<Card> loser) {
        winner.offer(loser.poll());
        winner.offer(winner.poll());
    }

    public void war(Card userCardOne, Card compCardOne) {
        Queue<Card> pot = new LinkedList<>();
        pot.offer(userCardOne);
        pot.offer(compCardOne);
        Boolean warOn = true;
        do {
           warOn =  warPlay(pot);
        } while(warOn);
    }

    public Boolean warPlay(Queue<Card> pot) {
        pot.offer(userDeck.poll());
        pot.offer(compDeck.poll());
        System.out.println("You both place one card face down");
        Card userCard = userDeck.poll();
        System.out.println("Your Card: " + userCard);
        Card compCard = compDeck.poll();
        System.out.println("Computer Car: " + compCard);
        pot.offer(userCard);
        pot.offer(compCard);
        if (userCard.value() > compCard.value()) {
            System.out.println("You take the cards");
            warWin(pot, userDeck);
            return false;
        } else if (userCard.value() < compCard.value()) {
            System.out.println("Computer takes the cards");
            warWin(pot, compDeck);
            return false;
        } else {
            System.out.println("The cards tied.");
            return true;
        }
    }

    public void warWin (Queue<Card> pot, Queue<Card> winner) {
        Iterator<Card> cards = pot.iterator();
        while(cards.hasNext()) {
            Card current = cards.next();
            winner.offer(current);
        }
    }

    /*
    public void list() {
        for (int i = 0; i < deck.length; i++) {
            System.out.println(deck[i].toString());
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
    */
}
