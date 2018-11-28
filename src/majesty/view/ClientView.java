package majesty.view;

import java.util.Timer;
import java.util.TimerTask;

import javax.tools.DocumentationTool.Location;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import majesty.model.Card;
import majesty.model.Card.LoadScreen;
import majesty.model.Card.Locations;
import majesty.model.Card.Suit;
import majesty.model.ClientModel;
import majesty.model.DeckOfCards;

public class ClientView {
    public RadioButton getMale() {
		return male;
	}

	public void setMale(RadioButton male) {
		this.male = male;
	}

	public RadioButton getFemale() {
		return female;
	}

	public void setFemale(RadioButton female) {
		this.female = female;
	}

	private ClientModel model;
    private Stage stage1, stage2, stage3;

    protected Label lblIP = new Label("IP");
    

	protected TextField txtIP = new TextField();
    protected Label lblPort = new Label("Port");
    protected TextField txtPort = new TextField("8080");
    protected Label lblClientName = new Label("Client name");
    protected TextField txtClientName = new TextField("");
    protected Button btnGo = new Button("Go");
    protected Button btnHello = new Button("Hello");
    protected Button btnNewClient = new Button("New customer");
    protected Button btnGoodbye = new Button("Goodbye");
    private RadioButton male = new RadioButton("Male");
    private RadioButton female = new RadioButton("Female");
    private Timer tm= new Timer();
    
    
    protected TextArea txtMessages = new TextArea();
    
    public ClientView(Stage stage, ClientModel model) {
        this.stage1 = stage;
        this.model = model;
        
        stage.setTitle("Login");
        
        BorderPane root = new BorderPane();

        VBox topBox = new VBox();
        topBox.setId("TopBox");
        
      
        Region spacer = new Region();
        Region spacer2 = new Region();
        Region spacer3 = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        HBox.setHgrow(spacer3, Priority.ALWAYS);
        root.setTop(topBox);
        
        
        root.setTop(topBox);
        
        topBox.getChildren().addAll(txtPort, txtIP, lblClientName, txtClientName, male, female, btnGo,btnHello);
        txtIP.setId("IP");
        txtPort.setId("Port");
        
        /*
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        root.setCenter(scrollPane);
        scrollPane.setContent(txtMessages);
        txtMessages.setWrapText(true);
        */

       
        
        
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(
                getClass().getResource("Example.css").toExternalForm());
        stage.setScene(scene);
    }
    
    public void initLoadingScreen() {
    	
    	this.stage1.close();
    	Stage lobbyStage = new Stage();
    	this.stage2 = lobbyStage;
    	/*Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
            	
               Card majesty = new Card(LoadScreen.majesty);
    	CardLabel lblMajesty = new CardLabel();
    	lblMajesty.setLoadScreen(majesty);
    	
    	 BorderPane root = new BorderPane();
    	 root.setCenter(lblMajesty);
    	 Scene scene = new Scene(root, 250, 250);
        
    	
        lobbyStage.setScene(scene);
        lobbyStage.show();
            }
        }, 5000, 5000);
      */
        Label splash = new Label();
   	 BorderPane root = new BorderPane();
	 root.setCenter(splash);
	 Scene scene = new Scene(root, 250, 250);
    
	
    lobbyStage.setScene(scene);
    lobbyStage.show();
    	
    	
    	
     
        
    	
    }
    
    public void initPlayerBoard() {
    	
    	stage1.close();
    	Stage PlayerStage = new Stage();
    	this.stage3 = PlayerStage;
    	
    	BorderPane root = new BorderPane();
    	HBox hboxCards = new HBox();
    	DeckOfCards wholeDeck = new DeckOfCards(2);
    	 for (int i = 0; i < 2; i++) {
 			Card card= wholeDeck.dealCard();
             CardLabel lblCard = new CardLabel();
             lblCard.setCard(card);
             hboxCards.getChildren().add(lblCard);
             
 		}
    	 
    	 
    	 root.setCenter(hboxCards);
    	 
    	 GridPane score = new GridPane();
    	 score.add(new Label("Rang"),0,0);
    	 score.add(new Label("Spielername"),1,0);
    	 score.add(new Label("Gold"),2,0);
    	 
    	 //Zahl wird später durch Spieleranzahl ersetzt solange nur 2 Spieler = egal
    	 for (int i = 0; i < 1; i++) {
    		 score.add(new Label(""+i+1),0,i+1);
    		 score.add(new Label(""),1, i+1);
    		 score.add(new Label(""+0),2,i+1);
    	 }
    	 
    	 for (int i = 0; i < 6; i++) {
  			Card card= wholeDeck.dealCard();
              CardLabel lblCard = new CardLabel();
              hboxCards.getChildren().add(lblCard);
              lblCard.setCard(card);
  		}
    	 
    	Card muehle = new Card(Locations.Muehle);
    	CardLabel lblMuehle = new CardLabel();
    	lblMuehle.setLocationCard(muehle);
    	
    	Card taverne = new Card(Locations.Taverne);
    	CardLabel lblTaverne = new CardLabel();
    	lblTaverne.setLocationCard(taverne);
    	
    	Card hexenhaus = new Card(Locations.Hexenhaus);
    	CardLabel lblHexenhaus = new CardLabel();
    	lblHexenhaus.setLocationCard(hexenhaus);
    	
    	Card kaserne = new Card(Locations.Kaserne);
    	CardLabel lblKaserne = new CardLabel();
    	lblKaserne.setLocationCard(kaserne);
    	
    	Card schloss = new Card(Locations.Schloss);
    	CardLabel lblSchloss = new CardLabel();
    	lblSchloss.setLocationCard(schloss);
    	
    	Card wachturm = new Card(Locations.Wachturm);
    	CardLabel lblWachturm = new CardLabel();
    	lblWachturm.setLocationCard(wachturm);
    	
    	Card lazarett = new Card(Locations.Lazarett);
    	CardLabel lblLazarett = new CardLabel();
    	lblLazarett.setLocationCard(lazarett);
    	
    	HBox locations = new HBox();
    	locations.getChildren().addAll(lblMuehle,lblTaverne,lblHexenhaus,lblKaserne,lblSchloss,lblWachturm,lblLazarett);
   
    	root.setBottom(locations);
    	
    	root.setLeft(btnHello);
    	
    	 
    	 root.setTop(score);
    	 
    	
    	 
    	 
    	 
    	 
    	 Scene scene = new Scene(root, 500, 500);
        
    	
    	 PlayerStage.setScene(scene);
    	 PlayerStage.show();
    }
    
    public Stage getStage1() {
		return stage1;
	}

	public void setStage1(Stage stage1) {
		this.stage1 = stage1;
	}

	public void start() {
        stage1.show();
    }
    
    /**
     * Stopping the view - just make it invisible
     */
    public void stop() {
        stage1.hide();
    }
    
    /**
     * Getter for the stage, so that the controller can access window events
     */
    public Stage getStage() {
        return stage1;
    }
    
    public ClientModel getModel() {
		return model;
	}

	public void setModel(ClientModel model) {
		this.model = model;
	}

	public Label getLblIP() {
		return lblIP;
	}

	public void setLblIP(Label lblIP) {
		this.lblIP = lblIP;
	}

	public TextField getTxtIP() {
		return txtIP;
	}

	public void setTxtIP(TextField txtIP) {
		this.txtIP = txtIP;
	}

	public Label getLblPort() {
		return lblPort;
	}

	public void setLblPort(Label lblPort) {
		this.lblPort = lblPort;
	}

	public TextField getTxtPort() {
		return txtPort;
	}

	public void setTxtPort(TextField txtPort) {
		this.txtPort = txtPort;
	}

	public Label getLblClientName() {
		return lblClientName;
	}

	public void setLblClientName(Label lblClientName) {
		this.lblClientName = lblClientName;
	}

	public TextField getTxtClientName() {
		return txtClientName;
	}

	public void setTxtClientName(TextField txtClientName) {
		this.txtClientName = txtClientName;
	}

	public Button getBtnGo() {
		return btnGo;
	}

	public void setBtnGo(Button btnGo) {
		this.btnGo = btnGo;
	}

	public Button getBtnHello() {
		return btnHello;
	}

	public void setBtnHello(Button btnHello) {
		this.btnHello = btnHello;
	}

	public Button getBtnNewClient() {
		return btnNewClient;
	}

	public void setBtnNewClient(Button btnNewClient) {
		this.btnNewClient = btnNewClient;
	}

	public Button getBtnGoodbye() {
		return btnGoodbye;
	}

	public void setBtnGoodbye(Button btnGoodbye) {
		this.btnGoodbye = btnGoodbye;
	}

	public TextArea getTxtMessages() {
		return txtMessages;
	}

	public void setTxtMessages(TextArea txtMessages) {
		this.txtMessages = txtMessages;
	}

	public void setStage(Stage stage) {
		this.stage1 = stage;
	}
}
