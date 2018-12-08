package Server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Logger;

import javafx.concurrent.Task;
import majesty.model.DeckOfCards;
import majesty.model.Player;

public class ServerModel {
	ServerSocket server;
    private Integer port;private Socket clientSocket;private static int indexCounter = 0;
    private DeckOfCards deck;
    private final Logger logger = Logger.getLogger("");
    public static int NUM_OF_CLIENTS= 0;
    private ArrayList<Player> players;
    
    
    public static int getNUM_OF_CLIENTS() {
		return NUM_OF_CLIENTS;
		
	
		
	}
    String ip;
	public static void setNUM_OF_CLIENTS(int nUM_OF_CLIENTS) {
		NUM_OF_CLIENTS = nUM_OF_CLIENTS;
	}

	
    public ArrayList<ServerThreadForClient> clientName = new ArrayList<ServerThreadForClient>();
    

	final Task<Void> serverTask = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
           
        	
            try {
            	
                server = new ServerSocket(port, 10);
                logger.info("Listening on port " + port);
                InetAddress iAddress = InetAddress.getLocalHost();
                
                
              while (clientName.size()<2) {
            	  System.out.println("Waiting for client to connect...");
                    // The "accept" method waits for a request, then creates a socket
                    // connected to the requesting client
                     clientSocket = server.accept();
                    
                     
                     
                    //testing
                   System.out.println("verbunden"); 
                    
                    ServerThreadForClient client = new ServerThreadForClient(clientSocket);
                   clientName.add(client);
                    indexCounter++;
                    String name = clientName.get(indexCounter-1).getReader().readLine();
                    System.out.println("Hallo"+clientSocket);
                    Player xy = new Player((indexCounter-1), name);
                    players.add(xy); 
                  
                    client.start();
                    
                    
                                      
                    
                    
                    
                    NUM_OF_CLIENTS++;
                    
                    if (NUM_OF_CLIENTS==2) {
                    	System.out.println("2 Spieler drin");
                    	for(Player p : players){
                        	p.setDeckOfCards(deck);
                        	p.setNumOfPlayers(players.size());
                        	p.setPlayerList(players);
                        }
                    	sendClientStartMsg();
                    }
                }
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                if (server != null) server.close();
            }
            return null;
        }

		private void setPlayerInformations() {
			// TODO Auto-generated method stub
			
			
		}

		private void getPlayertName() {
			// TODO Auto-generated method stub
			
			
			
			
		}



		private void sendClientStartMsg() throws IOException {
			
			deck.createFinalDeck(NUM_OF_CLIENTS);
						
			
			for (int i = 0; i < NUM_OF_CLIENTS; i++) {
				
				
				ObjectOutputStream out = new ObjectOutputStream(clientName.get(i).getClientSocket().getOutputStream());
				out.writeObject(players);
				out.writeObject(deck);
				
			}
			
			
			
		}
    };
    
    /**
     * Called by the controller, to start the serverSocket task
     */
    public void startServerSocket(Integer port) {
        this.port = port;
        new Thread(serverTask).start();
    }

    
    public ArrayList<ServerThreadForClient> getClientName() {
		return clientName;
	}

	public void setClientName(ArrayList<ServerThreadForClient> clientName) {
		this.clientName = clientName;
	}
	/*brauchen wir nicht
	/**
	 * 
	 * @return ip
	 * @Source https://stackoverflow.com/questions/2939218/getting-the-external-ip-adress-in-java
	 *
	public String getExternalID() {
		//Integer ip=0;
		try {
			
			URL myURL = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));
		ip = in.readLine();
//		System.out.println("ihne mit der Ip"+ip);
//		return ip;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("type this into your client to play online: " + ip);
		return ip;
		
		
	}
	*/
	
    
    
}
