package majesty.view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import majesty.model.Card;

public class CardLabel extends Label {
	public CardLabel() {
		super();
		//this.getStyleClass().add("card");
		this.getStylesheets().add(
                getClass().getResource("Example.css").toExternalForm());
	}

	public void setCard(Card card) {
		if (card != null) {
			String fileName = cardToFileName(card);
			Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("majesty/images/characters/" + fileName));
			ImageView imv = new ImageView(image);
			imv.fitWidthProperty().bind(this.widthProperty());
			imv.fitHeightProperty().bind(this.heightProperty());
			imv.setPreserveRatio(true);
			this.setGraphic(imv);
		} else {
			this.setGraphic(null);
		}
	}

	private String cardToFileName(Card card) {
		
		String suit = card.getSuit().toString();
		return  suit + ".jpg";
	}
	
	public void setLocationCard(Card card) {
		if (card != null) {
			String fileName = locationCardToFileName(card);
			Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("majesty/images/locations/" + fileName));
			ImageView imv = new ImageView(image);
			imv.fitWidthProperty().bind(this.widthProperty());
			imv.fitHeightProperty().bind(this.heightProperty());
			imv.setPreserveRatio(true);
			Button b = new Button("", imv);
			this.setGraphic(b);
		} else {
			this.setGraphic(null);
		}
		
		
	}
	
	private String locationCardToFileName(Card card) {
			
			String Location = card.getLocation().toString();
			return  Location + ".jpg";
		}
	public void setLoadScreen(Card card) {
		if (card != null) {
			String fileName = loadlingScreenToFileName(card);
			Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("majesty/image/" + fileName));
			ImageView imv = new ImageView(image);
			imv.fitWidthProperty().bind(this.widthProperty());
			imv.fitHeightProperty().bind(this.heightProperty());
			imv.setPreserveRatio(true);
			this.setGraphic(imv);
		} else {
			this.setGraphic(null);
		}
		
		
	}
	
	private String loadlingScreenToFileName(Card card) {
		String loadScreen = card.getLs().toString();
		return  loadScreen + ".jpg";
		
	}
	
	}


