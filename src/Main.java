import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) throws Exception  {

        System.out.println("Server has started");
        ServerSocket ss = new ServerSocket(8888);
        Socket cs = ss.accept();
        System.out.println("Client Connected");

        while(true) {

        }
    }

}


