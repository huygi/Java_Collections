import java.util.ArrayList;
import java.util.List;

public record Card( Suit suit, String face, int rank ) {                                    // Using record b/c gives me built in immutability
    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        public char getImage() {                                                            // returns the ascii character to print for each suit
            return( new char[]{ 9827, 9830, 9829, 9824 } )[this.ordinal()];
        }
    }

    @Override
    public String toString() {
        int index = face.equals( "10" ) ? 2 : 1;                                   // All cases will be 1, unless my card is 10
        String faceString = face.substring( 0, index );
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank );
    }

    // Public static helper methods to build a deck
    // These two methods will be called by the next method, that returns an array list of cards.
    public static Card getNumericCard( Suit suit, int cardNumber ) {
        if( cardNumber > 1 && cardNumber < 11 ) {
            return new Card( suit, String.valueOf(cardNumber), cardNumber - 2 );            // I want my lowest card to have a rank of zero, and my lowest card is a 2.
        }
        System.out.println( "Invalid Numeric card selected" );
        return null;
    }

    public static Card getFaceCard( Suit suit, char abbrev ) {
        int charIndex = "JQKA".indexOf(abbrev);
        if( charIndex > -1 ) {
            return new Card( suit, "" + abbrev, charIndex + 9 );                            // record Card class
        }
        System.out.println( "Invalid Face card selected" );
        return null;
    }

    // This method gives me a deck of 52 cards
    public static List<Card> getStandardDeck() {
        List<Card> deck = new ArrayList<>(52);
        for( Suit suit : Suit.values() ) {                                                  // For each suit, I'll create a set of numeric cards, then a set of face cards.
            for( int i = 2; i <= 10; i++ ) {
                deck.add(getNumericCard(suit, i));
            }
            for( char c : new char[] {'J', 'Q', 'K', 'A'} ) {                               // My nested loop will loop thru four characters
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }

    public static void printDeck( List<Card> deck ) {                                       // Overload method only have a list of Default Row of Card
        printDeck( deck, "Current Deck", 4);
    }

    public static void printDeck( List<Card> deck, String description, int rows ) {
        System.out.println("-".repeat(25));
        if( description != null ) {
            System.out.println(description);
        }
        int cardsInRow = deck.size() / rows;
        for( int i = 0; i < rows; i++ ) {
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList( startIndex, endIndex ).forEach( c -> System.out.print( c + " "));
            System.out.println();
        }
    }
}