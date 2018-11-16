package majesty.view;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import majesty.model.Card;
import majesty.model.DeckOfCards;


public class PlayerBoard extends VBox{
	
	private HBox hboxCards, hboxGebäudeCards;
	private DeckOfCards deck;
	
	
	
	public PlayerBoard(DeckOfCards deck) {
		super();
		
		deck.createFinalDeck(2);
	    
		
		hboxCards = new HBox();
		for (int i = 1; i < 5; i++) {
			
            Label lblCard = new CardLabel();
            hboxCards.getChildren().add(lblCard);
        }
	}

	
	
	

}
