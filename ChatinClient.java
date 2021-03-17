import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ChatinClient {

    private static String address = "localhost";
    private static int port = 1235;

    public static void main(String[] args){
        try {
            Socket s = new Socket(address, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}