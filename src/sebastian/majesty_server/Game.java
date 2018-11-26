package sebastian.majesty_server;

import java.io.IOException;
import java.util.List;

public class Game {

    private final List<Client> clients;

    public Game(List<Client> clients) {
        this.clients = clients;
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
            processInput(clients.get(0)); //TODO decide which client is next
            updateClients();
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
        return false; //TODO implement game ending condition
    }

}