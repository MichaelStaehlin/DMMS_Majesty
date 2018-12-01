package sebastian.majesty_server;

import java.io.IOException;
import java.util.List;

import majesty.model.DeckOfCards;

public class Game {

    private final List<Client> clients;
    private final int rounds;
    private int roundCounter;
    private DeckOfCards deck;
    private int currentActivePlayer;

    public Game(List<Client> clients) {
        this.clients = clients;
        this.rounds = clients.size()*12;
        this.roundCounter=0;
        this.deck = new DeckOfCards(clients.size());
        this.currentActivePlayer=0;
    }

    public void start() {
        try {
        	startImpl();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void startImpl() throws IOException {
        while (!gameFinished()) {
        	if(currentActivePlayer>=clients.size())
        		currentActivePlayer = 0;
        	processInput(clients.get(currentActivePlayer)); //TODO decide which client is next
            updateClients();
            currentActivePlayer++;
            
        }

        for (Client client : clients) {
            client.close();
        }
    }

    private void processInput(Client client) throws IOException {
        System.out.println("Waiting for input of client " + client);
        client.getWriter().println("Your turn!");

        String command = client.getReader().readLine();
        System.out.println("command = " + command);
        //TODO update board according to given command
    }

    public void updateClients() throws IOException {
        System.out.println("Sending updated board to all clients");

        for (Client client : clients) {
            client.getWriter().println("Hello world"); //TODO send new board state to all clients
        }
    }

    private boolean gameFinished() {
    	if(this.roundCounter<=this.rounds)
    		return false;
    	else return true;//TODO implement game ending condition
    }

}