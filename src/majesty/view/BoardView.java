package majesty.view;

import java.util.ArrayList;

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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import majesty.model.Player;

public class BoardView {
	
	public Stage windows;
	public GridPane grid;
	public TextField tf1;
	protected VBox vBoxTableView;
	protected HBox hBoxTableView, hBoxBtnsCharacters, hBoxLocations, hBoxBtnsGreenRed ;
	public ArrayList<Button> btnListCharacters;
	public ArrayList<Button> btnListLocations;
	public Button btnFinishRound, btnQuit;

	
	
	public BoardView(Stage primaryStage) {
			
//Windows	
		this.windows = primaryStage;
		windows.setTitle("GridPane");
// GridPane
		grid = new GridPane();
		grid.setStyle("-fx-background-image: url(\"aac.JPG\")");
		grid.setPadding(new Insets(10, 10, 10, 10)); // Wie viel Kästchen
		grid.setMaxSize(1200, 1000);
		
//---	
		tf1 = new TextField();
		VBox vBoxText = new VBox(20);
		vBoxText.setMinSize(550, 300);
		vBoxText.getChildren().add(tf1);
		vBoxText.setStyle("-fx-border-color: blue");
		
		GridPane.setConstraints(vBoxText, 3,2,1,4);
		
		TextField tf2 = new TextField();
		VBox vBoxText2 = new VBox(20);
		vBoxText2.setMinSize(550, 300);
		vBoxText2.getChildren().add(tf2);
		vBoxText2.setStyle("-fx-border-color: blue");
		
		GridPane.setConstraints(vBoxText2, 1,0,2,2);
//---
//		Image ib1 = new Image(this.getClass().getClassLoader().getResourceAsStream("youtube/Adlige.jpg"));

		Button btnFinishRound = new Button("Zug beenden");
		btnFinishRound.setMinSize(500, 50);
		btnFinishRound.setStyle("-fx-background-color: green");
		
		Button btnQuit = new Button("Aufgeben");
		btnQuit.setStyle("-fx-background-color: red");
		btnQuit.setMinSize(500, 50);
		
//---
// TableColumn Spieler, Gold, Rang	
		TableColumn<Player, Integer> nameColumn = new TableColumn<>("PlayerIndex: ");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("playerIndex"));
		
		//Price column
		TableColumn<Player, String> priceColumn = new TableColumn<>("PlayerName: ");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("playerName"));
		
		//Quantity Column	
		TableColumn<Player, Boolean> quantityColumn = new TableColumn<>("Turn: ");
		quantityColumn.setMinWidth(100);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("turn"));	
//table
		TableView table = new TableView();
		table.setItems(getTableList());
		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
//VBox
		vBoxTableView = new VBox(20);
		vBoxTableView.setMinSize(100, 100);
		vBoxTableView.getChildren().addAll(table);
		vBoxTableView.setStyle("-fx-background-color: red");
	
		hBoxTableView = new HBox(10);
		hBoxTableView.setPadding(new Insets(10,750,10,50));
		hBoxTableView.getChildren().addAll(vBoxTableView);
		GridPane.setConstraints(hBoxTableView, 0, 0);		
//---
			
		hBoxBtnsCharacters = new HBox(30);
		hBoxBtnsCharacters.setStyle("-fx-background-image: url(\"aac.JPG\")");
//		VBox.setVgrow(listView, Priority.ALWAYS);
		hBoxBtnsCharacters.setPadding(new Insets(10,80,50,50)); // Wie viel Kästchen

//		Image ib1 = new Image(this.getClass().getClassLoader().getResourceAsStream("youtube/Adlige.jpg"));
		//Add Personenkarten
		btnListCharacters = new ArrayList<>();
		for(int i = 0; i<7; i++) {
			btnListCharacters.add(new Button(String.valueOf(i)));
			btnListCharacters.get(i).setMinSize(125, 200);
		hBoxBtnsCharacters.getChildren().addAll(btnListCharacters.get(i));
		
		}
		GridPane.setConstraints(hBoxBtnsCharacters, 0, 1); 
		
		hBoxLocations = new HBox(30);
		hBoxLocations.setStyle("-fx-background-image: url(\"aac.JPG\")");
//		VBox.setVgrow(listView, Priority.ALWAYS);
		hBoxLocations.setPadding(new Insets(10,80,50,50)); // Wie viel Kästchen
		
		btnListLocations = new ArrayList<>();
		for(int i = 0; i<9; i++) {
			btnListLocations.add(new Button(String.valueOf(i)));
			btnListLocations.get(i).setMinSize(125, 200);
			hBoxLocations.getChildren().addAll(btnListLocations.get(i));
		}
		GridPane.setConstraints(hBoxLocations, 0, 2);
//		
		Label l = new Label();
		GridPane.setConstraints(l, 0, 3);
//		
		hBoxBtnsGreenRed = new HBox(30);
		hBoxBtnsGreenRed.setStyle("-fx-background-image: url(\"aac.JPG\")");
//		VBox.setVgrow(listView, Priority.ALWAYS);
		hBoxBtnsGreenRed.setPadding(new Insets(10,80,50,50)); // Wie viel Kästchen
		hBoxBtnsGreenRed.getChildren().addAll(btnFinishRound, btnQuit);
		GridPane.setConstraints(hBoxBtnsGreenRed, 0, 4);
//	
// Get Children
		grid.getChildren().addAll(hBoxTableView, hBoxBtnsCharacters,hBoxLocations, l, hBoxBtnsGreenRed, vBoxText, vBoxText2);
		
// Scene
		Scene scene = new Scene(grid, 1920, 1000);
//		scene.getStylesheets().add(getClass().getResource("GridPan.css").toExternalForm());
		windows.setScene(scene);
		windows.show();
        windows.setWidth(1930);
        windows.setHeight(1030);
        windows.setResizable(false);
	}
// Rangliste Methode
	private ObservableList<Player> getTableList() {
			ObservableList<Player> currentPlayerList = FXCollections.observableArrayList();
			currentPlayerList.add(new Player(0, "Damir", true));
			currentPlayerList.add(new Player(0, "Damir", true));
			currentPlayerList.add(new Player(0, "Damir", true));
			currentPlayerList.add(new Player(0, "Damir", true));
		
			return currentPlayerList;
		}

}

