package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

import javafx.concurrent.Task;

public class ServerModel {
    private Integer port;
    private final Logger logger = Logger.getLogger("");
    public static int NUM_OF_CLIENTS= 0;
    public static int getNUM_OF_CLIENTS() {
		return NUM_OF_CLIENTS;
	}

	public static void setNUM_OF_CLIENTS(int nUM_OF_CLIENTS) {
		NUM_OF_CLIENTS = nUM_OF_CLIENTS;
	}

	private  int firstnum= 2;
    private ArrayList<ServerThreadForClient> clientName = new ArrayList<ServerThreadForClient>();
    
    final Task<Void> serverTask = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            ServerSocket listener = null;
            try {
                listener = new ServerSocket(port, 10, null);
                logger.info("Listening on port " + port);
                
               // while (NUM_OF_CLIENTS<firstnum) {
                    // The "accept" method waits for a request, then creates a socket
                    // connected to the requesting client
                    Socket clientSocket = listener.accept();
                    
                    ServerThreadForClient client = new ServerThreadForClient(clientSocket);
                    clientName.add(client);
                    System.out.println("Hallo"+clientSocket);
                    client.start();
                    NUM_OF_CLIENTS++;
               // }
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                if (listener != null) listener.close();
            }
            return null;
        }
    };
    
    /**
     * Called by the controller, to start the serverSocket task
     */
    public void startServerSocket(Integer port) {
        this.port = port;
        new Thread(serverTask).start();
    }

	public int getFirstnum() {
		return firstnum;
	}

	public void setFirstnum(int firstnum) {
		this.firstnum = firstnum;
	}
    
    
}
