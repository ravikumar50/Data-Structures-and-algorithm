package Socket;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class serverUdp {
    public static void main(String[] args) throws  Exception {

        DatagramSocket ds = new DatagramSocket(9999);
        byte b[] = new byte[10];
        DatagramPacket dp = new DatagramPacket(b,b.length);
        ds.receive(dp);

        String str = new String(dp.getData(),0,dp.getLength());

        ArrayList<String> arr = new ArrayList<>();

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

        Float ans = calculator(arr);

        InetAddress ia = InetAddress.getLocalHost();
        byte b1[] = String.valueOf(ans).getBytes();

        DatagramPacket dp1 = new DatagramPacket(b1, b1.length,ia,dp.getPort());
        ds.send(dp1);
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

