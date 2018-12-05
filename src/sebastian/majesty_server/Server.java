package sebastian.majesty_server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import majesty.model.DeckOfCards;
import majesty.model.Player;

public class Server {

    private static final int PORT = 8888;
    private static final int NUM_CLIENTS = 2; //TODO adjust number of players
    
    private ServerSocket server;
    private final List<Client> clients = new ArrayList<>();
    private final ArrayList<Player> players = new ArrayList<>();
    private int indexCounter=0;

    public void start() throws IOException {
        System.out.println("Starting server on port " + PORT);
        server = new ServerSocket(PORT);

        while (clients.size() < NUM_CLIENTS) {
            System.out.println("Waiting for client to connect...");
            Socket clientSocket = server.accept();
            System.out.println("Client from " + clientSocket.getInetAddress().getHostName() + ":" + clientSocket.getPort() + " connected");
            clients.add(new Client(clientSocket));
            String name = clients.get(indexCounter).getReader().readLine();
            Player p = new Player(indexCounter,name);
            players.add(p);
            indexCounter++;
        }
        DeckOfCards deck = new DeckOfCards(players.size());
        for(Player p : players){
        	p.setDeckOfCards(deck);
        	p.setNumOfPlayers(players.size());
        	p.setPlayerList(players);
        }
        System.out.println(NUM_CLIENTS + " connected, starting game");
        Game g = new Game(clients,players);
        g.start();
    }

}