import java.util.*;
import java.net.*;
import java.io.*;

public class SS {
    public static void main(String[] args) throws Exception {
        System.out.println("Server has started");
        ServerSocket ss = new ServerSocket(8888);



        while(true){
            Socket cs = ss.accept();
            DataInputStream ssInput = new DataInputStream(cs.getInputStream());
            DataOutputStream ssOutput = new DataOutputStream(cs.getOutputStream());
            int a = ssInput.readInt();
            int b = ssInput.readInt();
            if(a==-1){
                System.out.println("Disconnecte");
            }
            int c = a+b;
            ssOutput.writeInt(c);

        }
    }
}
