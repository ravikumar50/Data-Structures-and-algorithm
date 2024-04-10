package ChatSystemUsingTCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        Socket cs = new Socket("localhost",8788);
        DataInputStream csInput = new DataInputStream(cs.getInputStream());
        DataOutputStream csOutput = new DataOutputStream(cs.getOutputStream());
        while(true){

            String recieve = csInput.readUTF();
            System.out.println(recieve);
            if(recieve.equals("Bye")){
                System.out.println("Disconnected");
                break;
            }
            String send = sc.nextLine();
            csOutput.writeUTF(send);
            if(send.equals("Bye")){
                System.out.println("Disconnected");
                break;
            }

        }
    }
}
