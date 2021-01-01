import java.net.*;
import java.io.*;

//socket reference credit https://www.geeksforgeeks.org/socket-programming-in-java/

public class Client {
    private Socket socket = null;
    private BufferedReader input = null;
    private DataOutputStream out = null;
    public Client(String address, int port) {

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input  = new BufferedReader(new InputStreamReader(System.in));

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u) {
            System.out.println(u);
        }
        catch(IOException i) {
            System.out.println(i);
        }
        String line = "";

        // keep reading until "Over" is input
            while (!line.equals("Stop")) {
                try {
                    line = input.readLine();
                    out.writeUTF(line);
                }
                catch(IOException i) {
                    System.out.println(i);
                }
            }
            try {
                input.close();
                out.close();
                socket.close();
            }
            catch(IOException i) {
                System.out.println(i);
            }
}

    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 5000);
    }

}

