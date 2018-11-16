package majesty.model;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import Commons.Message;
import Commons.Message_Goodbye;
import Commons.Message_Hello;
import Commons.Message_NewCustomer;


public class ClientModel {
    String ipAddress;
    Integer port;
    
    

	public void init(String ipAddress, Integer port) {
	    this.ipAddress = ipAddress;
	    this.port = port;
	}

	private Socket connect() {
	    Socket socket = null;
        try {
            socket = new Socket(ipAddress, port);
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
	DeckOfCards deck = new DeckOfCards(1);
	
	 public void addCard(Card card) {
	    	

	    	//if(cards.size() < HAND_SIZE) cards.add(new Card(Suit.Spades, Rank.King));
	    	//if(cards.size() < HAND_SIZE) cards.add(new Card(Suit.Spades, Rank.Ten));
	    	//if(cards.size() < HAND_SIZE) cards.add(new Card(Suit.Spades, Rank.King));
	    	//if(cards.size() < HAND_SIZE) cards.add(new Card(Suit.Spades, Rank.Ten));
	    	//if(cards.size() < HAND_SIZE) cards.add(new Card(Suit.Spades, Rank.King));
	        
	        if (cards.size() < 6) cards.add(card);
	    }

	public DeckOfCards getDeck() {
		return deck;
	}

	public void setDeck(DeckOfCards deck) {
		this.deck = deck;
	}
	
}
