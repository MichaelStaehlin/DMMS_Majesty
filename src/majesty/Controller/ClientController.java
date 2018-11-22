package majesty.Controller;

import Server.ServerModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import majesty.model.ClientModel;
import majesty.view.ClientView;

public class ClientController {
    
    protected static final int NUM_OF_CLIENTS = 2;
	final private ClientModel model;
    final private ClientView view;
    
    public ClientController(ClientModel model, ClientView view) {
        this.model = model;
        this.view = view;
        
       
        view.getBtnGo().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String ip = view.getTxtIP().getText();
                Integer port = new Integer(2303);
                System.out.println("Client "+port+"\n"+ip);
        	
                
              //  model.init(ip, port);
              //  view.getTxtMessages().setText("Initialized");
                
                //Hier soll ein Splash Screen rein
               
                if(model.getPlayerList().size()<2) {
                	
                	 view.initPlayerBoard();
                }
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
