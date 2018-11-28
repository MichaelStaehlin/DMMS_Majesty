package majesty.Controller;

import Commons.Message_ReadyToStart;
import Server.ServerModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import majesty.model.ClientModel;
import majesty.model.Player;
import majesty.view.ClientView;
import majesty.view.Splash;

public class ClientController {
    
    
	final private ClientModel model;
    final private ClientView view;
    
    public ClientController(ClientModel model, ClientView view) {
        this.model = model;
        this.view = view;
        
       
        view.getBtnGo().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	int i = 0;
                String ip = view.getTxtIP().getText();
                Integer port = new Integer(8080);
                System.out.println("Client "+port+"\n"+ip);
                
                // erster Spieler wartet im Splashscreen
                if (model.getPlayerList().size()==0) {
                	String clientName =view.getTxtClientName().getText();
                	Player firstPlayer = new Player(0, clientName , true);
                	model.getPlayerList().add(firstPlayer);
                	Message_ReadyToStart ready = new Message_ReadyToStart();
                	//ready.send(model.getPlayerList().get(i));
                	
                	
                	if(model.getPlayerList().size()==1) {
                		// Hier Splashscreen initialisieren
                		view.getStage1().close();
                
                		Splash.displaySplash();
                
                		
                	view.initPlayerBoard();
                	
                		System.out.println("erster Spieler");
                	}
                	
                	
                }
                
                
             // Wenn 2 Spieler erreicht

                if (model.getPlayerList().size()==2) {
                	String clientName =view.getTxtClientName().getText();
                	Player secondPlayer = new Player(1, clientName , false);
                	// Splashscreen schliessen
                	System.out.println("zweiter Spieler");
                	
                	view.initPlayerBoard();
                	System.out.println("Board initialisiert");
                	
                	
                }
                
                //no
                
                
             
                
                
                
                if (model.getPlayerList().size()>2) {
                	Alert toMuchPlayer = new Alert(null, "Already enough Players", null);
                }
                
                
                
                model.init(ip, port);
               view.getTxtMessages().setText("Initialized");
                
            }
            
             
            
        });
        
       
       
        
       
       

        // register ourselves to listen for button clicks
        view.getBtnHello().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
				Platform.runLater(() -> {
					String result = model.sayHello(view.getTxtClientName().getText());
					view.getTxtMessages().appendText("\nSaid 'hello', received: " + result);
				});
            }
        });

        // register ourselves to listen for button clicks
        view.getBtnNewClient().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayNewClient(view.getTxtClientName().getText());
                view.getTxtMessages().appendText("\nSaid 'new client', received: " + result);
            }
        });

        // register ourselves to listen for button clicks
        view.getBtnGoodbye().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayGoodbye(view.getTxtClientName().getText());
                view.getTxtMessages().appendText("\nSaid 'goodbye', received: " + result);
            }
        });
        
        
        

        // register ourselves to handle window-closing event
        view.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                view.stop();
                Platform.exit();
            }
        });
    }
}
