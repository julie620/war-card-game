public class Test {
    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();
        myDeckOfCards.deal();
        while(myDeckOfCards.gameOn()) {
            myDeckOfCards.play();
        }
    }
}
