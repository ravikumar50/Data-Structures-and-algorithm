import java.util.*;
import java.net.*;
import java.io.*;

public class SS {


    public static void main(String[] args) throws Exception {
        System.out.println("Server has started");
        ServerSocket ss = new ServerSocket(8788);


        while(true){
            System.out.println("Ready to Connect");
            Socket cs = ss.accept();
            System.out.println("Client Connected");

            DataInputStream ssInput = new DataInputStream(cs.getInputStream());
            DataOutputStream ssOutput = new DataOutputStream(cs.getOutputStream());

            int x = ssInput.readInt();
            if(x==1){
                String s = ssInput.readUTF();
                System.out.println(s);
            }else if(x==2){
                int a = ssInput.readInt();
                int b = ssInput.readInt();
                ssOutput.writeInt(a+b);
            }else if(x==3){
                int a = ssInput.readInt();
                int b = ssInput.readInt();
                ssOutput.writeInt(a+b);
                ssOutput.writeInt(a-b);
                ssOutput.writeInt(a*b);
                ssOutput.writeInt(a/b);
                ssOutput.writeInt(a%b);
            }else if(x==4) {
                char ch = ssInput.readChar();
                ssOutput.writeInt((int)ch);
            }else if(x==5){
                int n = ssInput.readInt();
                int ans = 1;
                for(int i=1; i<=n; i++){
                    ans = ans*i;
                }
                ssOutput.writeInt(ans);
            }else{
                System.out.println("Disconnected");
                break;
            }
        }
    }
}
