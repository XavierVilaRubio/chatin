import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ChatinServer {

    private static int port = 1235;

    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public class Writer implements Runnable {

        private Socket s;

        @Override
        public void run() {
            // TODO Auto-generated method stub
            
        }

    }

    public class Reader implements Runnable {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            
        }

    }
}
