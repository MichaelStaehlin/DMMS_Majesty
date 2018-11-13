package majesty.model;

public class Card {

	    public enum Suit { Muellerin, Brauer, Hexe, Wachen, Soldat, Wirt, Adlige;
	        @Override
	        public String toString() {
	            String suit = "";
	            switch (this) {
	            case Muellerin: suit = "muellerin"; break;
	            case Brauer: suit = "brauer"; break;
	            case Hexe: suit = "hexe"; break;
	            case Wachen: suit = "wachen"; break;
	            case Soldat: suit = "soldat"; break;
	            case Wirt: suit = "wirt"; break;
	            case Adlige: suit = "adlige"; break;
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
