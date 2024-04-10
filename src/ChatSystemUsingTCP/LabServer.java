package ChatSystemUsingTCP;

import java.util.*;
import java.net.*;
import java.io.*;

public class LabServer {


    public static void main(String[] args) throws Exception {
        System.out.println("Server has started");
        ServerSocket ss = new ServerSocket(8788);

        Socket cs1 = ss.accept();
        System.out.println("Client 1 Connected");

        Socket cs2 = ss.accept();
        System.out.println("Client 2 Connected");


        DataInputStream ssInput1 = new DataInputStream(cs1.getInputStream());
        DataOutputStream ssOutput1 = new DataOutputStream(cs1.getOutputStream());


        DataInputStream ssInput2 = new DataInputStream(cs2.getInputStream());
        DataOutputStream ssOutput2 = new DataOutputStream(cs2.getOutputStream());


        while(true){


            String s1 = ssInput1.readUTF();
            ssOutput2.writeUTF(s1);
            if(s1.equals("Bye")) break;

            String s2 = ssInput2.readUTF();
            ssOutput1.writeUTF(s2);
            if(s2.equals("Bye")) break;

        }
    }
}