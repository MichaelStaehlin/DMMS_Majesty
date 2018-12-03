package sebastian.majesty_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import majesty.model.DeckOfCards;

public class Client {

    private PrintWriter writer;
    private BufferedReader reader;

    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Starting client");
        Socket socket = new Socket("localhost", 8888);
        System.out.println("schritt2");
        
        ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream());
        DeckOfCards deck = (DeckOfCards) objIn.readObject();
        ArrayList<Client> clients = (ArrayList<Client>) objIn.readObject();
        objIn.close();

        writer = new PrintWriter(socket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        
        while (!socket.isClosed()) {
            play();
        }

        System.out.println("Server socket closed");
    }

    private void play() throws IOException {
        System.out.println("Waiting for server input");
        String command = reader.readLine();

        //TODO make this more resilient
        if (command.equals("Your turn!")) {
            System.out.println("It is my turn!");

            //next line: send index of picked card
            writer.println("My turn = hello world");
        } if(command.equals("Game Finished!")){
        //TODO End-Methoden aufrufen
        }
        
        else {
        	String[] commands = command.split(",");
        	int currentActivePlayer = Integer.parseInt(commands[0]);
        	int pickedCard = Integer.parseInt(commands[1]);
            System.out.println("Board has been updated by server");
            //TODO update board
        }
    }
}