package majesty.model;

public class Card {

	    public enum Suit { Muellerin, Brauer, Hexe, Wachen, Soldat, Wirt, Adlige;
	        @Override
	        public String toString() {
	            String suit = "";
	            switch (this) {
	            case Muellerin: suit = "Muellerin"; break;
	            case Brauer: suit = "Brauer"; break;
	            case Hexe: suit = "Hexe"; break;
	            case Wachen: suit = "Wachen"; break;
	            case Soldat: suit = "Soldat"; break;
	            case Wirt: suit = "Wirt"; break;
	            case Adlige: suit = "Adlige"; break;
	            }
	            return suit;
	        }
	    };
	    
	    private final Suit suit;
	    
	    public Card(Suit suit) {
	        this.suit = suit;
	    }

	    public Suit getSuit() {
	        return suit;
	    }

	    @Override
	    public String toString() {
	        return suit.toString();
	    }
	
}
