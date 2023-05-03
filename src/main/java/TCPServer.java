import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Date;

public class TCPServer {

    public static void main(String[] args) throws IOException {

        int PORT = 3305;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("[+] Server port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("[+] Client connected.");

                String text;

                do {
                    InputStream input = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);

                    text = reader.readLine();


                    if (text.equals("date")) {
                        writer.println(new Date());
                    }

                    if (text.equals("time")) {
                        LocalTime localTime = LocalTime.now();
                        writer.println(localTime);
                    }

                    if (text.equals("bye")) {
                        writer.println("[!] Terminating connection, good-bye.");
                    }

                } while (!text.equals("bye"));

                socket.close();

            } // end while

        } catch (IOException ex) {

            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();

        }

    } // end main()


} // end TCPServer{}
