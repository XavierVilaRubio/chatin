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
            Thread reader = new Thread(new Reader(s));
            Thread writer = new Thread(new Writer(s));
            reader.start();
            writer.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static class Writer implements Runnable {

        private Socket s;

        public Writer(Socket socket) {
            this.s = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				DataOutputStream dos = new DataOutputStream (s.getOutputStream());
				String str = "";

				while (!str.equals ("FI"))
				{
					str = br.readLine();
					dos.writeUTF (str);
					dos.flush();
				}
                System.err.println("Server writer ended");
				dos.close();
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }

    }

    public static class Reader implements Runnable {

        private Socket s;

        public Reader(Socket socket) {
            this.s = socket;
        }

        @Override
        public void run() {
			try {
				DataInputStream  dis = new DataInputStream  (s.getInputStream());
				String str = "";

				while (!str.equals ("FI"))
				{
					str = dis.readUTF();
					System.err.println ("Client: «" + str + "»");
				}
                System.err.println("Server reader ended");
				dis.close();
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

    }
}
