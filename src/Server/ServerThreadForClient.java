package Server;

import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerThreadForClient extends Thread implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger("");
    private Socket clientSocket;
    private static int roundCounter;
    private boolean playerTurn;
    

    public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public ServerThreadForClient(Socket clientSocket)  {
        this.clientSocket = clientSocket;
    }

   
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
        	
    };     
    
    private String processMessage(String information) {
		logger.info("Message received from client: "+ information.toString());
		
		
		if (gameIsnoStarted()==true) {
			
		}

		String i = information;
		
    	return i;
    }

private boolean gameIsnoStarted() {
	
	
	return false;
}
}

