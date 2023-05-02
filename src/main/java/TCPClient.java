import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

    public static void main(String[] args) throws Exception{

        int PORT = 3305;
        String HOST = "localhost";
        String text;

        try (Socket clientSocket = new Socket(HOST, PORT)) {

            BufferedReader inputLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Connected to: " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

            do {

                text = inputLine.toString();
                DataOutputStream outputLine = new DataOutputStream(clientSocket.getOutputStream());

                BufferedReader replyLine = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                outputLine.writeBytes(inputLine.readLine() + '\n');
                System.out.println("FROM SERVER: " + replyLine.readLine());

            } while (!text.equals("bye"));

        } catch (UnknownHostException ex) {
            System.out.println("[-] Server not found: " + ex.getMessage());
        }

    } // end main()


} // end TCPClient{}
