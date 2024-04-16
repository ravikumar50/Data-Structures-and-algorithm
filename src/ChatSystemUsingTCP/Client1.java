package ChatSystemUsingTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Socket cs = new Socket("localhost",7654);
        DataInputStream csInput = new DataInputStream(cs.getInputStream());
        DataOutputStream csOutput = new DataOutputStream(cs.getOutputStream());
        while(true){

            String send = sc.nextLine();
            csOutput.writeUTF(send);
            if(send.equals("Bye")) break;
            String recieve = csInput.readUTF();
            System.out.println(recieve);
            if(recieve.equals("Bye")) break;
        }
    }
}