package majesty.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

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
    
//	
    
	final private ClientModel model;
    final private ClientView view;
    private Socket socket;
    private ArrayList<Player>playerList;
    private String name; 
    private PrintWriter  writer;
    
    public ClientController(ClientModel model, ClientView view) {
        this.model = model;
        this.view = view;
        
       
        view.getBtnGo().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
                String ip = view.getTxtIP().getText();
                Integer port = new Integer(8080);
                name = view.getTxtClientName().getText();
                System.out.println("Client "+port+"\n"+ip);
                model.connect(ip, port);

                
                
                try {
					writer = new PrintWriter(model.getSocket().getOutputStream(), true);
					writer.write(name);
					System.out.println();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
               
                
                
                		
                
                // Players alle bekannt
                ObjectInputStream objIn;
				try {
					objIn = new ObjectInputStream(model.getSocket().getInputStream());
					
						Splash.displaySplash();
						playerList = (ArrayList<Player>) objIn.readObject();
						model.setPlayerList(playerList);
						
						
					
						
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
                
               
                
				// Spiel stage startet
                
                
                // Spieler weiss welcher Index sein ist
                model.setIndexInGame(getIndexofPlayer());
                
                
             
                
                
               // model.getPlayerList() = new InputStream;
                
                // erster Spieler wartet im Splashscreen
               // if (model.getPlayerList().size()==0) {
              //  	String clientName =view.getTxtClientName().getText();
                //	Player firstPlayer = new Player(0, );
                	
                
                	
               // }
                
                	/*
                	 ObjectOutputStream out;
					try {
						out = new ObjectOutputStream(model.getSocket().getOutputStream());
						out.writeObject(firstPlayer); 
						out.flush();
						model.getSocket().shutdownOutput();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}           
                	            
                	 
                
                	
                	
                	if(model.getPlayerList().size()==1) {
                		// Hier Splashscreen initialisieren
                		view.getStage1().close();
                
                		Splash.displaySplash();
                
                		
                	view.initPlayerBoard();
                	
                		System.out.println("erster Spieler");
                	}
                	
                	
                
        */
                
                
             /* Wenn 2 Spieler erreicht

                if (model.getPlayerList().size()==2) {
                	String clientName2 =view.getTxtClientName().getText();
                	Player secondPlayer = new Player(1, clientName, false);
                	// Splashscreen schliessen
                	System.out.println("zweiter Spieler");
                	
                	view.initPlayerBoard();
                	System.out.println("Board initialisiert");
                	
                	
                }
               */ 
                //no
                
                
             
                
                
                
                if (model.getPlayerList().size()>2) {
                	Alert toMuchPlayer = new Alert(null, "Already enough Players", null);
                }
                
                
                
              
               view.getTxtMessages().setText("Initialized");
                
            }
            
            

			private Integer getIndexofPlayer() {
				// TODO Auto-generated method stub
				
				for (int i=0; i<model.getPlayerList().size(); i++) {
					
					if (model.getPlayerList().get(i).getPlayerName().equals(name)) {
						
						return i;
						
					}
					
				}
				
				
				return null;
			}
            
             
            
        });
        
       
       
        
       
       

        /* register ourselves to listen for button clicks
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
        
        */
        
       
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
