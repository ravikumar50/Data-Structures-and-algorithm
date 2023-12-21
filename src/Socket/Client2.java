package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws Exception{
        String ip = "localhost";
        int port = 9990;
        Socket cs = new Socket(ip,port);

        DataInputStream clientInput = new DataInputStream(cs.getInputStream());
        DataOutputStream clientOutput = new DataOutputStream(cs.getOutputStream());

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the expression to be evaluated");
        String str = sc.nextLine();

        clientOutput.writeUTF(str);

        int ans = clientInput.readInt();

        System.out.println("Evaluated ans is : "+ans);


    }
}
