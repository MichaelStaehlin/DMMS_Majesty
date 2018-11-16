package majesty.view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import majesty.model.Card;

public class CardLabel extends Label {
	public CardLabel() {
		super();
		this.getStyleClass().add("card");
	}

	public void setCard(Card card) {
		if (card != null) {
			String fileName = cardToFileName(card);
			Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("majesty/images/characters" + fileName));
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

}
