import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {

        int PORT = 3305;

        try(ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("[+] Server port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("[+] Client connected.");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                String text;

                do {

                    text = reader.readLine();
                    String printText = text;
                    writer.println("Server: " + text);

                } while(!text.equals("bye"));

                socket.close();

            } // end while

        } catch (IOException ex) {

            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();

        }

    } // end main()


} // end TCPServer{}
