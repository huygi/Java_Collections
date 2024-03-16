import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        // Shuffle my deck
        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        /* Reverse() method will reverse the order of the elements.
        - The first element in the shuffled deck becomes the last element in the reversed deck.*/
        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck of Cards:",4);

        /* There are two ways, like the sort method on the List interface.
        - This is when you run into Legacy code, and still using Collections.sort
        - One requires your elements in the list to implement Comparable, and one doesn't (We use the one doesn't)
        - The Collections.sort() method takes your list as the first argument.
        - My Card record doesn't implement Comparable.
        - Considering using List.sort() method in the future. */
        var sortingAlgorithm = Comparator.comparing( Card::rank).thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);

        // Reverse method -> Lowest to highest
        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed:",13);

        /* The next couple of methods let you compare sub lists to full lists.
        - I'll take out a couple of smaller lists from my standard deck, using list's sublist method.
        - And passing them into a new array list constructor.
        - My first sublist will be all kings.  */
        List<Card> kings = new ArrayList<>( deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck",1);

        List<Card> tensCard = new ArrayList<>( deck.subList(16,20));
        Card.printDeck( tensCard,"Tens in deck",1);

        /* This is index of Sub List, that returns an integer if it finds a sublist in the collections passed to it
        - This method will return an integer if tensCard is found, or -1 if it wasn't.
        - This method told me where I could find the subList in the fullList, starting at index = 16.
        - This method could be use full if you ever needed to identify if portion of list already exists in bigger list.*/
        int subListIndex = Collections.indexOfSubList(deck, tensCard);
        System.out.println("SubList index for tens Card is start at = " + subListIndex);

        /* Unlike Contains() method, the elements in the SubList must be contiguously found in the full list.
        - True = the list contains all the elements in the subList.
        */
        System.out.println("Contains = " + deck.containsAll(tensCard));

        /* The disjoint() method
        - This method return true if the two lists have no elements in common
        - This method takes two collections, and returns true if the two collections don't share elements.
        - Return false if they do have elements in common.
        - I'm comparing the fullList with just the tens Card list. */
        boolean disjoint = Collections.disjoint( deck, tensCard );
        System.out.println( "Disjoint = " + disjoint );

        boolean disjoint2 = Collections.disjoint( kings, tensCard );
        System.out.println( "Disjoint between Kings and Tens = " + disjoint2 );     // Kings and Tens dont have any elements in common.

        /** Noted_2
         * In this part, we covered shuffle(), reverse(), sort(), indexOfSubList(), disjoint().
         * Pretty similar methods on the List Interface, such as List's sort(), containsALL() method.
         */
    }
}
