import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);
        var sortingAlgorithm = Comparator.comparing( Card::rank).thenComparing(Card::suit);

        /* Like the Array class that gave us a binarySearch() method for arrays.
        - The Collections method supports a binary search method for lists.
        - Both methods require the elements to be sorted first, and neither guarantees what index is returned if you've got duplicated.
        - The binarySearch method on Collections is overloaded, like the sort() method.
        - I can pass a List of Comparable elements, or I can pass a list with a separate Comparator.
        - The element that will be searched for, which should be the same type as the element in the List passed.
         */
        deck.sort(sortingAlgorithm);
        Card tenOfHearts = Card.getNumericCard( Card.Suit.HEART, 10 );
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("foundIndex_BinarySearch = " + foundIndex);
        System.out.println(deck.get(foundIndex));

        /* You can use List's index of method to do the same, without the list being required to be sorted order.
        - The contains() method on List, uses the index-Of() method to return the result.
        */
        System.out.println("foundIndex_indexOf = " + deck.indexOf(tenOfHearts));

        /* Which method of searching should I use ? (Binary) ? (indexOf)
        - If your lists contain a small number of elements, or if your list is unsorted / contain duplicates:
            => Then use indexOf() method.
        - If your list already sorted, and contains large amount of elements:
            => Use binarySearch() method.
        */

        /* replaceAll() method, like List interface.
        - replaceAll() method on List, allowed us to write a function like a lambda expressions, to do a global replacement of elements.
        - replaceAll() method on Collections class is limited, b/c requires to replace one or more instances with another.
        - This method will replace more than one element, if it finds multiple matches.
        - Replace the ten of clubs, with a ten of hearts.*/
        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll( deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32,36), "Tens row", 1);

        Collections.replaceAll( deck, tenOfHearts, tenOfClubs );
        Card.printDeck(deck.subList(32, 36), "Ten rows", 1);

        /* This method returns a boolean value, true if the list was really changed, meaning one or more elements was replaced / false if not*/
        if( Collections.replaceAll(deck, tenOfHearts, tenOfClubs)) {
            System.out.println("Tens of hearts replaced with tens of clubs");
        } else {
            System.out.println("No tens of hearts found in the list");
        }

        /* The frequency() method allows you to check for duplicates in your collection.*/
        System.out.println( "Duplicate Ten of Clubs Cards = " + Collections.frequency(deck, tenOfClubs));

        /* Collections also give us both min and max methods.
        - Which take a collection, and will return the last or first element.
         */


    }
}