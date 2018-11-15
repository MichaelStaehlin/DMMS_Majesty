import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



public class Server {

    private static final int PORT = 8888;
    private static final int NUM_CLIENTS = 1; //TODO adjust number of players
    
    private ServerSocket server;
    private final List<Client> clients = new ArrayList<>();

    public void start() throws IOException {
        System.out.println("Starting server on port " + PORT);
        server = new ServerSocket(PORT);

        while (clients.size() < NUM_CLIENTS) {
            System.out.println("Waiting for client to connect...");
            Socket clientSocket = server.accept();
            
            System.out.println("Client from " + clientSocket.getInetAddress().getHostName() + ":" + clientSocket.getPort() + " connected");
            clients.add(new Client(clientSocket));
        }
        
        System.out.println(NUM_CLIENTS + " connected, starting game");
        Game g = new Game(clients);
        g.start();
    }
    
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }

}