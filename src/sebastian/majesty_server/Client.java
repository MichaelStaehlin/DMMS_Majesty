package sebastian.majesty_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Michael Coban
 */
public class Client {
    
    private final Socket socket;
    
    private final BufferedReader reader;
    private final PrintWriter writer;
    
    public Client(Socket socket) throws IOException {
        this.socket = socket;
        
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer =  new PrintWriter(socket.getOutputStream(), true);
    }

    public BufferedReader getReader() {
        return reader;
    }

    public PrintWriter getWriter() {
        return writer;
    }
    
    public void close() throws IOException {
        socket.close();
    }

    @Override
    public String toString() {
        return socket.getInetAddress() + ":" + socket.getPort();
    }
    
}