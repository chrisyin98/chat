import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ForMultipleClients extends Thread {

    private Socket socket;
    public ForMultipleClients(Socket clientSocket) {
        this.socket = clientSocket;
    }
    public void run() {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String word = "";
            while (true) {
                try {
                    word = in.readUTF();
                    System.out.println(socket.getPort() + ": " + word);
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        } catch(IOException e) {
            System.out.println(e);
        }

    }


}
