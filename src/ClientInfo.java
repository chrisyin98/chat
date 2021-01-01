import java.net.InetAddress;

public class ClientInfo {
    private InetAddress address = null;
    private String name = "";
    private int port;
    private int id;

    public ClientInfo(String name, int id, InetAddress address, int port){
        this.name = name;
        this.id = id;
        this.port = port;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public InetAddress getAddress() {
        return address;
    }
}

