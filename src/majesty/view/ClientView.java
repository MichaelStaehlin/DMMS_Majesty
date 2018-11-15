package majesty.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import majesty.model.ClientModel;

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
    private Stage stage;

    protected Label lblIP = new Label("IP");
    

	protected TextField txtIP = new TextField("127.0.0.1");
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
    
    protected TextArea txtMessages = new TextArea();
    
    public ClientView(Stage stage, ClientModel model) {
        this.stage = stage;
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
        
        topBox.getChildren().addAll( lblClientName, txtClientName, male, female, btnGo);
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
    
    public void start() {
        stage.show();
    }
    
    /**
     * Stopping the view - just make it invisible
     */
    public void stop() {
        stage.hide();
    }
    
    /**
     * Getter for the stage, so that the controller can access window events
     */
    public Stage getStage() {
        return stage;
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
		this.stage = stage;
	}
}
