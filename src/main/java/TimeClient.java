import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {

    public static void main(String[] args) {

        int PORT = 3005;
        String HOST = "localhost";

        try(Socket socket = new Socket(HOST, PORT)) {

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String time = reader.readLine();

            System.out.println(time);

        } catch (IOException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        }
    }
}
