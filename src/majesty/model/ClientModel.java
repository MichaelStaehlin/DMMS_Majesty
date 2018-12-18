package majesty.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

import Commons.Message;
import Commons.Message_Goodbye;
import Commons.Message_Hello;
import Commons.Message_NewCustomer;
import Server.ServerThreadForClient;
import majesty.view.Splash;


public class ClientModel {
    String ipAddress;
    Integer port, indexInGame;
    Socket socket;
    ArrayList<Player> playerList = new ArrayList<Player>();
	private PrintWriter writer;
    private BufferedReader reader;
    private ObjectInputStream input;
    
    public Player generateThisPlayer(int id, String name) {
    	Player thisPlayer = new Player (id, name);
    	return thisPlayer;
    }
    

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public void init(String ipAddress, Integer port) {
	    this.ipAddress = ipAddress;
	    this.port = port;
	}

	public Socket connect(String ip, Integer port) {
	    
        try {
            socket = new Socket(ip, port);
            
            System.out.println("Connect");
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
	    return socket;
	}
	
	
	
	/*public String sayHello(String clientName) {
        String result = null;
	    Socket socket = connect();
	    if (socket != null) {
    		Message msgOut = new Message_Hello();
    		msgOut.setClient(clientName);
    		try {
    			msgOut.send(socket);
    			Message msgIn = Message.receive(socket);
    			result = msgIn.toString();
    		} catch (Exception e) {
    			result = e.toString();
    		}
            try { if (socket != null) socket.close(); } catch (IOException e) {}
	    }
		return result;
	}
	
	
	public String sayNewClient(String clientName) {
		
        String result = null;
        Socket socket = connect();
        if (socket != null) {
    		Message_NewCustomer msgOut = new Message_NewCustomer();
    		msgOut.setClient(clientName);
    		msgOut.setName("Jennifer Jumpingjacks");
    		msgOut.setAge(23);
    		try {
    			msgOut.send(socket);
    			Message msgIn = Message.receive(socket);
    			result = msgIn.toString();
    		} catch (Exception e) {
    			result = e.toString();
    		}
            try { if (socket != null) socket.close(); } catch (IOException e) {}
        }
		return result;
	}

	public String sayGoodbye(String clientName) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
    		Message msgOut = new Message_Goodbye();
    		msgOut.setClient(clientName);
    		try {
    			msgOut.send(socket);
    			Message msgIn = Message.receive(socket);
    			result = msgIn.toString();
    		} catch (Exception e) {
    			result = e.toString();
    		}
    		try { if (socket != null) socket.close(); } catch (IOException e) {}
        }
		return result;
	}
	*/
	
	
	public DeckOfCards getGeneratedDeckFromServer (DeckOfCards sDeck) {
		deck = sDeck;
		return deck;
	}
	//Kartenlogik
	DeckOfCards deck = new DeckOfCards(2);
	
	

	public DeckOfCards getDeck() {
		return deck;
	}

	public void setDeck(DeckOfCards deck) {
		this.deck = deck;
	}


	public PrintWriter getWriter() {
		return writer;
	}


	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}


	public BufferedReader getReader() {
		return reader;
	}


	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}


	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}


	public Integer getIndexInGame() {
		return indexInGame;
	}


	public void setIndexInGame(Integer indexInGame) {
		this.indexInGame = indexInGame;
	}


	public ObjectInputStream getInput() {
		return input;
	}


	public void setInput(ObjectInputStream input) {
		this.input = input;
	}
	
	public void getPlayerListInput (Socket socket) {
		try {
			//while ( model.getInput().readObject()!=null) {              
				 ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream());
				
				Splash.displaySplash();
				playerList = (ArrayList<Player>) objIn.readObject();
				this.setPlayerList(playerList);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
}
