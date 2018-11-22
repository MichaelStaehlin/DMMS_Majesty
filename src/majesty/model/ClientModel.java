package majesty.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

import Commons.Message;
import Commons.Message_Goodbye;
import Commons.Message_Hello;
import Commons.Message_NewCustomer;


public class ClientModel {
    String ipAddress;
    Integer port;
    ArrayList<String> playerList = new ArrayList<String>();
    

	public ArrayList<String> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<String> playerList) {
		this.playerList = playerList;
	}

	public void init(String ipAddress, Integer port) {
	    this.ipAddress = ipAddress;
	    this.port = port;
	}

	private Socket connect() {
	    Socket socket = null;
        try {
            socket = new Socket(ipAddress, port);
            System.out.println("Connect");
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
	    return socket;
	}
	
	public String sayHello(String clientName) {
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
	//Kartenlogik
	DeckOfCards deck = new DeckOfCards(2);
	
	

	public DeckOfCards getDeck() {
		return deck;
	}

	public void setDeck(DeckOfCards deck) {
		this.deck = deck;
	}

	/**
	 * 
	 * @return ip
	 * @Source https://stackoverflow.com/questions/2939218/getting-the-external-ip-adress-in-java
	 */
	public void getExternalID() {
		Integer ip=0;
		try {
			
			URL myURL = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));
		ip = Integer.parseInt(in.readLine());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	
	}
	
}
