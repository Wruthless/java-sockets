import java.io.*;
import java.net.*;

public class UDPClient {

    public static void main(String[] args) throws Exception {
        int PORT = 3301;
        String HOST = "localhost";
        String strData;

        System.out.println("[!] Enter some text: ");

        // BufferReader associated with keyboard
        BufferedReader inputLine = new BufferedReader(new InputStreamReader(System.in));

        // Client Datagram socket
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName(HOST);
        byte[] buf = new byte[256];

        // Read in a line from keyboard
        strData = inputLine.readLine();
        buf = strData.getBytes();

        // Create a Datagram packet containing user entry
        DatagramPacket packet = new DatagramPacket(buf, buf.length, IPAddress, PORT);

        // Send packet to server
        clientSocket.send(packet);

        // Datagram packet for receiving from server
        packet = new DatagramPacket(buf, buf.length);

        // Receive data from server
        clientSocket.receive(packet);
        strData = new String(packet.getData());

        // Print server response
        System.out.printf("%s%s", "FROM SERVER: ", strData.toUpperCase());

        // Close socket
        clientSocket.close();
    }

}
