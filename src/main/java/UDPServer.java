import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args) throws Exception{

        byte[] buf = new byte[256];
        String strData;
        int PORT = 3301;

        // Server Datagram Socket on 3301
        DatagramSocket serverSocket = new DatagramSocket(PORT);

        // Datagram packet for receiving data
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        // Receive data from client
        serverSocket.receive(packet);

        // Create Datagram packet containing client data
        strData = new String(packet.getData()).toUpperCase();
        InetAddress IPAddress = packet.getAddress();

        PORT = packet.getPort();
        System.out.printf("%s%s%s%s%n", "Datagram received: ", IPAddress, ":", PORT);

        buf = strData.getBytes();

        // Send packet to client
        packet = new DatagramPacket(buf, buf.length, IPAddress, PORT);
        serverSocket.send(packet);

        // Close socket.
        serverSocket.close();

    } // main()


} // UDPServer{}
