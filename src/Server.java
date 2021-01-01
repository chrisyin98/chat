import java.net.*;
import java.io.*;

public class Server {
    private Socket socket = null;

    public static void begin(int port) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(port);
        } catch(IOException e) {
            System.out.println(e);
        }

        while (true) {
            try {
                socket = server.accept();
                System.out.println("New computer" + socket);

            } catch(IOException e){
                System.out.println(e);
            }
            ForMultipleClients newThread = new ForMultipleClients(socket);
            newThread.start();
        }
    }



    public static void main(String args[]) {
        Server server = new Server();
        server.begin(5000);
    }
}


