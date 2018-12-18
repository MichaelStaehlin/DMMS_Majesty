package majesty.view;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import majesty.model.ClientModel;
import majesty.model.Player;
import youtube.DeckOfCards;
import youtube.TableViewProductClass;

public class BoardView {
	
	public Stage windows;
	public GridPane grid;
	public BorderPane root;
	public TextField tf1;
	protected VBox vBoxTableView;
	protected HBox hBoxTableView, hBoxBtnsCharacters, hBoxLocations, hBoxBtnsGreenRed, hBoxGoldCounter ;
	public ArrayList<Button> btnListCharacters;
	public ArrayList<Button> btnListLocations;
<<<<<<< HEAD
	public ArrayList<Button> btnGoldCounter;
	public ArrayList<TableView> tblPlayers;
	public ArrayList<VBox> vBoxTableList;
	public Button btnFinishRound, btnQuit, button5;
	Reflection reflectionFx = new Reflection();
	DropShadow dropShadowFx = new DropShadow();
	private int index;

=======
	public Button btnFinishRound, btnQuit;
	public ClientModel model;
>>>>>>> branch 'master' of https://github.com/MichaelStaehlin/DMMS_Majesty.git
	
	
	public BoardView(Stage primaryStage, ClientModel model) {
			this.model = model;
//Windows	
		this.windows = primaryStage;
		windows.setTitle("GridPane");
		
		// GridPane
				grid = new GridPane();
				grid.setStyle("-fx-background-image: url(\"aac.JPG\")");
				grid.setPadding(new Insets(10, 10, 10, 10)); // Wie viel Kästchen	
			
				TextField s1 = new TextField();
			  	s1.setMinSize(430, 980);
			  	s1.setPromptText("Spiel beginn");
			  	
				s1.setPadding(new Insets(100,10,10,10));
				s1.setEffect(dropShadowFx);
				
				VBox vb = new VBox();
				vb.getChildren().addAll(s1);
				
//--------------------------------------------------------------------------
// TableColumn Spieler, Gold, Rang	
				//HBox Table
				hBoxTableView = new HBox(10);
				hBoxTableView.setPadding(new Insets(30,700,30,50));
			
				Player d = new Player(1, "Damir", 5);
				DeckOfCards deck = new DeckOfCards(2);
				
				tblPlayers = new ArrayList<>();
				
			for(int i = 0; i <=deck.getNumOfPlayer(); i++) {
					
				TableColumn<String, String> nameColumn = new TableColumn<>(d.getPlayerName());
				nameColumn.setMinWidth(100);
				nameColumn.setCellValueFactory(new PropertyValueFactory<>(""));
				
			
				
				//Quantity Column	
				TableColumn<Integer, Integer> quantityColumn = new TableColumn<>("Rang: ");
				quantityColumn.setMinWidth(100);
				quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));	
		//tableView
				
				tblPlayers.add(new TableView());
				tblPlayers.get(i).setItems(getTableList());
				tblPlayers.get(i).getColumns().addAll(nameColumn, quantityColumn);
			
		//VBox Table
				
				vBoxTableList = new ArrayList<>();
				for(int e = 0; e < i; e++) {
					vBoxTableList.add(new VBox(10));
					vBoxTableList.get(e).setMinSize(100, 100);
					vBoxTableList.get(e).getChildren().addAll(tblPlayers.get(i));
				hBoxTableView.getChildren().addAll(vBoxTableList.get(e));
					}	
				}
				GridPane.setConstraints(hBoxTableView, 0, 0);
				
				Button deckBackGreen = new Button();
				deckBackGreen.setMinSize(120, 220);

				Button deckBackRed = new Button();
				deckBackRed.setMinSize(120, 220);
				
				HBox hBoxDeck = new HBox(10);
				hBoxDeck.getChildren().addAll(deckBackGreen, deckBackRed);
				

				//HBox Table
				hBoxTableView = new HBox(10);
				hBoxTableView.setPadding(new Insets(30,700,30,50));
				hBoxTableView.getChildren().addAll(vBoxTableView, hBoxDeck);
				GridPane.setConstraints(hBoxTableView, 0, 0);		
		//------------------------------------------------------------------------------
		//Add Characters			
				hBoxBtnsCharacters = new HBox(30);
				hBoxBtnsCharacters.setStyle("-fx-background-image: url(\"aac.JPG\")");
				hBoxBtnsCharacters.setPadding(new Insets(10,80,50,50)); // Wie viel Kästchen
			
				btnListCharacters = new ArrayList<>();
				for(int i = 0; i<7; i++) {
					DropShadow dropShadow = new DropShadow();
			       	btnListCharacters.add(new Button());
					Image ib1 = new Image(this.getClass().getClassLoader().getResourceAsStream("youtube/Adlige.jpg"));
					ImageView iv =new ImageView(ib1);
					btnListCharacters.get(i).setMinSize(120, 220);
					btnListCharacters.get(i).setGraphic(iv);
					btnListCharacters.get(i).setEffect(dropShadow);
					btnListCharacters.get(i).setStyle("-fx-border-width: 3.0px");
				hBoxBtnsCharacters.getChildren().addAll(btnListCharacters.get(i));
				
				}
				GridPane.setConstraints(hBoxBtnsCharacters, 0, 1); 
				
		//Add Locations
				hBoxLocations = new HBox(30);
				hBoxLocations.setStyle("-fx-background-image: url(\"aac.JPG\")");
				hBoxLocations.setPadding(new Insets(10,80,0,50)); // Wie viel Kästchen
				
				btnListLocations = new ArrayList<>();
				for(int i = 0; i<8; i++) {
					DropShadow dropShadow2 = new DropShadow();
					btnListLocations.add(new Button());
					Image ib2 = new Image(this.getClass().getClassLoader().getResourceAsStream("youtube/Brauerei.jpg"));
					ImageView iv2 =new ImageView(ib2);
					btnListLocations.get(i).setMinSize(145, 220);
					btnListLocations.get(i).setGraphic(iv2);
					btnListLocations.get(i).setEffect(dropShadow2);
					btnListLocations.get(i).setStyle("-fx-background-color: black");
					hBoxLocations.getChildren().addAll(btnListLocations.get(i));
				}
				GridPane.setConstraints(hBoxLocations, 0, 2);
				
		//Add CardCounter
				hBoxGoldCounter = new HBox(30);
				hBoxGoldCounter.setStyle("-fx-background-image: url(\"aac.JPG\")");
				hBoxGoldCounter.setPadding(new Insets(10,80,50,50)); // Wie viel Kästchen
				
				btnGoldCounter = new ArrayList<>();
				for(int i = 0; i<8; i++) {
					Reflection rrr = new Reflection();
					DropShadow dropShadowBtn = new DropShadow();
					rrr.setInput(dropShadowBtn);
					btnGoldCounter.add(new Button("0"));
					btnGoldCounter.get(i).setMinSize(145, 50);
					btnGoldCounter.get(i).setStyle("-fx-background-color: black");
					btnGoldCounter.get(i).setEffect(rrr);
					hBoxGoldCounter.getChildren().addAll(btnGoldCounter.get(i));
				}
				GridPane.setConstraints(hBoxGoldCounter, 0, 3);
				
		//Buttons Green Red
				btnFinishRound = new Button("Zug beenden");
				btnFinishRound.setMinSize(500, 50);
				btnFinishRound.setStyle("-fx-background-color: green");
				btnFinishRound.setEffect(reflectionFx);
				reflectionFx.setInput(dropShadowFx);
				
				btnQuit = new Button("Aufgeben");
				btnQuit.setStyle("-fx-background-color: red");
				btnQuit.setMinSize(500, 50);
				btnQuit.setEffect(reflectionFx);
				reflectionFx.setInput(dropShadowFx);		
				
		//Add Green Red Button
				hBoxBtnsGreenRed = new HBox(30);
				hBoxBtnsGreenRed.setStyle("-fx-background-color: white");
				hBoxBtnsGreenRed.setPadding(new Insets(10,80,50,50)); // Wie viel Kästchen
				hBoxBtnsGreenRed.getChildren().addAll(btnFinishRound, btnQuit);
				GridPane.setConstraints(hBoxBtnsGreenRed, 0, 4);
				
				
		// BorderPane Get Children
				grid.getChildren().addAll(hBoxTableView, hBoxBtnsCharacters,hBoxLocations, hBoxGoldCounter, hBoxBtnsGreenRed);// vBoxText, vBoxText2
				root = new BorderPane();
				root.setCenter(grid);
				root.setPickOnBounds(true);
				root.setRight(vb);
				root.setMinSize(430, 100);
				root.setPadding(new Insets(10,10,10,10));
						
		// Scene
				Scene scene = new Scene(root, 1920, 1000);
//				scene.getStylesheets().add(getClass().getResource("GridPan.css").toExternalForm());
				windows.setScene(scene);
				windows.show();
		        windows.setWidth(1930);
		        windows.setHeight(1030);
		        windows.setResizable(true);
		        windows.setFullScreen(false);
		        windows.setMaximized(true);
		       
		        GregorianCalendar now = new GregorianCalendar();
		        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		        df = DateFormat.getTimeInstance(DateFormat.MEDIUM);
		        String datum = df.format(now.getTime());
		        
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
			for (int i = 0; i < btnListCharacters.size(); i++) {
				int newGoldInt = 5;
				int index = Integer.valueOf(i);
				String newGoldString = String.valueOf(newGoldInt);
				btnListCharacters.get(i).setOnAction(e -> {
					switch(index) {
					case 0:
						setBtnGoldCounter(newGoldString, index);
						table.setItems(setTableList(newGoldInt));
						s1.setText(datum+ ": Damir: Gold + " +newGoldString +"-> Zug beendet.");
//						s1.setText("Damir: Gold + " +newGoldString +"-> Zug beendet.");
						break;
					case 1:
						setEmptyCharacters();
						break;
					case 6:
						System.exit(0);
					}
					
				});
			}
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
			}

			public void start() {
				windows.show();
			}

			public Stage getStage() {
				return this.windows;
			}

			public void stop() {
				this.windows.hide();
			
			}
			
			public void setBtnGoldCounter(String count, int o) {
			   	 for(int i = 0; i < btnGoldCounter.size(); i++) {
			   		btnGoldCounter.get(o).setText(count);
			   	 }
			}
			public void setCharactersOnEnable() {
			   	 for(Button b : btnListCharacters) {
			        	b.setDisable(true);
			   	 } 	
			}
			
			public void setBtnCharactersOnDisable() {
				 for(Button b : btnListCharacters) {
			    	b.setDisable(false);
				 }
			}
			
			public void setEmptyCharacters() {
				hBoxBtnsCharacters.getChildren().clear();
			}
			
			public HBox gethBoxBtnsCharacters() {
				return hBoxBtnsCharacters;
			}

			public void sethBoxBtnsCharacters(HBox hBoxBtnsCharacters) {
				this.hBoxBtnsCharacters = hBoxBtnsCharacters;
			}

			public ArrayList<Button> getBtnListCharacters() {
				return btnListCharacters;
			}

			public void setBtnListCharacters(ArrayList<Button> btnListCharacters) {
				this.btnListCharacters = btnListCharacters;
			}
// Rangliste Methode
	private ObservableList<Player> getTableList() {
			ObservableList<Player> currentPlayerList = FXCollections.observableArrayList();
<<<<<<< HEAD
			currentPlayerList.add(new Player(0, "Damir", true));
			currentPlayerList.add(new Player(0, "Damir", false));
			currentPlayerList.add(new Player(0, "Damir", false));
			currentPlayerList.add(new Player(0, "Damir", false));
=======
			currentPlayerList.add(model.getPlayerList().get(0));
			currentPlayerList.add(model.getPlayerList().get(1));
			
>>>>>>> branch 'master' of https://github.com/MichaelStaehlin/DMMS_Majesty.git
		
			return currentPlayerList;
		}
	private ObservableList<Player> setTableList(int s) {
			ObservableList<Player> currentPlayerList = FXCollections.observableArrayList();
			currentPlayerList.add(new Player(s, "Damir", true));
			currentPlayerList.add(new Player(0, "Damir", false));
			currentPlayerList.add(new Player(0, "Damir", false));
			currentPlayerList.add(new Player(0, "Damir", false));
		
			return currentPlayerList;
	}

}

