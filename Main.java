import java.util.*;

public class Main {
    public static void main( String[] args ) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        /* - Method on Arrays for populating a list ( This method on Arrays helper class)
           - Method called 'Fill' */
        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');  // Suit is a nested enum inside of Card.
        Arrays.fill(cardArray,aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Ace of Hearts",1);

        /*- Collection class "fill method"
          -> If my list is empty, then it stays empty. Size() = 0;*/
        List<Card> cards = new ArrayList<>(52); // This List is empty with capacity of 52 cards.
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        /* - The Collections class offers us some alternatives.
           'nCopies' take two argument.
           - Method called nCopies, which create new list, with the number of elements you specify as the first argument,
           filling with the element you pass as the second argument */
        List<Card> aceOfHearts1 = Collections.nCopies(13, aceOfHearts );
        Card.printDeck(aceOfHearts1, "Ace of Heart 1", 1);

        Card kingOfClub = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingOfClubList = Collections.nCopies(13, kingOfClub );
        Card.printDeck(kingOfClubList, "Kings of Clubs", 1);

        /* I want to populate my full deck.
        - Like List, Collections includes an addAll method (take 2 arguments)
        - It's first argument is the list I want to add elements to, the second argument is for the elements to be added
        - The second argument is a variable argument of elements to be added.
        - The difference is that List's addAll method takes a collection of elements to be added.
        - cards.addAll(cardArray) -> This won't combine. */
        Collections.addAll( cards, cardArray);
        Collections.addAll( cards, cardArray);

        Card.printDeck( cards, "Card Collection with Aces added", 2);

        /* Copy method on Collections
        - Copy methods takes 2 arguments.
        - The first argument is the destination of the copied elements, the second argument is the elements to be copied
        - Important: You can't use this copy method if the number of elements in your current list is less than number of elements in the source list.
        - cards list (13) = kingOfClubList (13)
        - What happens if my destination has more elements than the source list?
            + Understand: This copy method that copies elements from one list to another, it doesn't return a copy of your list.
            + Elements are being assigned to the existing destination list, vs a copy of the list being made.  */
        Collections.copy( cards, kingOfClubList );
        Card.printDeck( cards, "Card Collection with Kings copied", 2);

        /* If you want a full list copy, you'd use the List.copyOf method
        - This method is a true copy, though it's important to remember that this method returns an unmodifiable list.
        - If you needed a modifiable copy of the list, you'd make a call to the copyOf method, pass it to a List constructor, or use addALl method.*/
        cards = List.copyOf(kingOfClubList);
        Card.printDeck(cards, "List Copy of Kings", 1);

        /** Noted
         * We covered the 'fill' method, compared it to the fill method on the Arrays helper class.
         * How to use nCopies, and the difference between the addAll methods on Collections.
         * Compare the Collections.copy method with List's copyOf method.
         * The first copies elements, replacing existing elements, with the elements passed.
         * List's copyOf method returns an immutable copy of the list passed.
         * In general, if there's some overlap, like addAll on List, you'll want to use the methods on the interface types,
         * and not the helper methods on the Collections class.
         */

    }
}
