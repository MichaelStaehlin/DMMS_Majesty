package majesty.view;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import majesty.model.Card;
import majesty.model.DeckOfCards;



public class PlayerBoard extends VBox{
	
	private HBox hboxCards, hboxGebaeudeCards;
	private DeckOfCards deck = new DeckOfCards(2);
	
	private ArrayList<Card> screenCards;
	
	
	public PlayerBoard(DeckOfCards deck) {
		super();
		this.getStyleClass().add("Example");
	
		
		deck.createFinalDeck(2);
		
		hboxGebaeudeCards = new HBox();
		
            
            Label l= new Label("Test");
       
            
            
       
	}
	
	public void setPlayerBoard() {
		ArrayList<Card> screenCards = deck.dealFirstDeckCards();
		for (int i = 0; i < 5; i++) {
			Label l1 = new Label(""+i);
			
			hboxGebaeudeCards.getChildren().add(l1);
		}
		
		hboxCards = new HBox();
		
		for (int i = 0; i < screenCards.size(); i++) {
			Card card= screenCards.get(i);
            CardLabel lblCard = new CardLabel();
            hboxCards.getChildren().add(lblCard);
            lblCard.setCard(card);
		}
	}
		/*
		 public void updatePlayerDisplay() {
		    	
		    	
		    	for (int i = 0; i < 5; i++) {
		    		Card card = null;
		    		if (DeckOfCards.size() > i) card = player.getCards().get(i);
		    		CardLabel cl = (CardLabel) hboxCards.getChildren().get(i);
		    		cl.setCard(card);
		    		
		    	}
		    }
	}
*/



	public DeckOfCards getDeck() {
		return deck;
	}




	public void setDeck(DeckOfCards deck) {
		this.deck = deck;
	}

	
	
	

}


