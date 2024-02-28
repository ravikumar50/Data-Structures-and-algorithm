package Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
public class ServersocketTCP {

    public static void main(String[] args) throws Exception  {

        System.out.println("Server has started");
        ServerSocket ss = new ServerSocket(8888);
        String str = "";

        while(true) {

            System.out.println("Server is waiting to connect with client");
            Socket cs = ss.accept();
            System.out.println("Client Connected");

            DataInputStream ssInput = new DataInputStream(cs.getInputStream());
            DataOutputStream ssOutput = new DataOutputStream(cs.getOutputStream());

            ArrayList<String> arr = new ArrayList<>();
            str = ssInput.readUTF();
            if(str.equals("Stop")){
                System.out.println("Disconnected");
                return;
            }

            for(int i=0; i<str.length(); i++){
                if((str.charAt(i)<48 || str.charAt(i)>57) && (str.charAt(i+1)<48 || str.charAt(i+1)>57)){
                    System.out.println("You have Entered wrong Operator");
                    return;
                }

                if(str.charAt(i)<48 || str.charAt(i)>57){
                    arr.add(String.valueOf(str.charAt(i)));
                }else {
                    String s = "";
                    while ((str.charAt(i) >= 48 && str.charAt(i) <= 57) || str.charAt(i)=='.') {
                        if(str.charAt(i)=='.' && str.charAt(i+1)=='.'){
                            System.out.println("You have Entered Wrong expression");
                            return;
                        }
                        s = s + str.charAt(i);
                        if(i== str.length()-1) break;
                        i++;
                    }
                    arr.add(s);
                    if(i==str.length()-1) break;
                    i--;
                }
            }

            ssOutput.writeInt(arr.size());

            float ans = calculator(arr);

            ssOutput.writeFloat(ans);
            cs.close();
        }
    }

    public static float calculator(ArrayList<String> arr) {
        float ans = 0;
        for(int i=0; i<arr.size(); i++){
            String s = arr.get(i);

            if(s.equals("*") || s.equals("/") || s.equals("%")){
                float a = Float.valueOf(arr.remove(i-1));
                String op = arr.remove(i-1);
                float b = Float.valueOf(arr.remove(i-1));

                if(op.equals("*")) ans = a*b;
                else if(op.equals("/")){
                    if(b==0){
                        System.out.println("Can't divide by 0");
                        return -1;
                    }
                    ans = a/b;
                }else ans=a%b;

                arr.add(i-1,String.valueOf(ans));
                i--;
            }

            if(i==arr.size()-2) break;
        }
        while(arr.size()!=1){

            float a = Float.valueOf(arr.remove(0));
            String s = arr.remove(0);
            float b = Float.valueOf(arr.remove(0));


            if(s.equals("+")) ans = a+b;
            else if(s.equals("-")) ans = a-b;
            else if(s.equals("*")) ans = a*b;
            else if(s.equals("/")) ans = a/b;
            else {
                System.out.println("You have entered wrong operator");
                return -1;
            }

            arr.add(0,String.valueOf(ans));
        }

        return Float.valueOf(arr.get(0));
    }

}


