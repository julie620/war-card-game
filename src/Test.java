public class Test {
    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        System.out.println("In order");
        myDeckOfCards.list();
        myDeckOfCards.shuffle();
        System.out.println("\nShuffled");
        myDeckOfCards.list();
        myDeckOfCards.deal();
        System.out.println("\nUSER HAND");
        myDeckOfCards.userHand();
        System.out.println("\nCOMPUTER HAND");
        myDeckOfCards.compHand();
    }
}
