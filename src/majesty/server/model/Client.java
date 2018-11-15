package majesty.server.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class Client {
	
	 public static void main(String[] args) throws IOException {
	        Client client = new Client();
	        client.start();
	    }
	    
    private PrintWriter writer;
    private BufferedReader reader;

    public void start() throws IOException {
        System.out.println("Starting client");
        Socket socket = new Socket("localhost", 8888);

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

            writer.println("My turn = hello world");
        } else {
            System.out.println("Board has been updated by server");
            //TODO update board
        }
    }
}
