package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

import Commons.Message;
import Commons.MessageType;
import Commons.Message_Error;
import Commons.Message_Goodbye;
import Commons.Message_Hello;
import Commons.Message_NewCustomer;
import Commons.Message_NewCustomerAccepted;
import Commons.Message_StartGame;
import majesty.model.Player;

public class ServerThreadForClient extends Thread {
    private final Logger logger = Logger.getLogger("");
    private Socket clientSocket;
    private static int roundCounter;
    private boolean playerTurn;

    public ServerThreadForClient(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    /**
     * Process messages until the client says "Goodbye"
     */
    @Override
    public void run() {
        logger.info("Request from client " + clientSocket.getInetAddress().toString()
                + " for server " + clientSocket.getLocalAddress().toString());
/*
        try {
			// Read a message from the client
        	
        	
			Message msgIn = Message.receive(clientSocket);
			Message msgOut = processMessage(msgIn);
			msgOut.send(clientSocket);
	    	logger.info("Answered with: " + msgOut.toString());
	    	
	    	
        } catch (Exception e) {
            logger.severe(e.toString());
        } finally {
            try { if (clientSocket != null) clientSocket.close(); } catch (IOException e) {}
        }
    }
    */
        	
        
    
    private String processMessage(String information) {
		logger.info("Message received from client: "+ information.toString());
		
		
		if (gameIsnoStarted()==true) {
			
		}
		
		if ()

		String plOut = null;
		
		
    	return msgOut;
    }

private boolean gameIsnoStarted() {
	
	
	return false;
}
}
