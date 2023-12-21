package Socket;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

public class Server2 {

    static int calculate(int nums[], char operator[]){
        int n1 = nums.length;
        int n2 = operator.length;

        int ans = nums[0];

        for(int i=0; i< operator.length; i++){
            int num2 = nums[i+1];
            char op = operator[i];

            if(op=='+') ans+=num2;
            else if(op=='-') ans-=num2;
            else if(op=='*') ans*=num2;
            else if(op=='/') ans/=num2;
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Server has started");
        java.net.ServerSocket ss = new java.net.ServerSocket(9990);
        while(true) {
            System.out.println("Server is waiting to connect with client");
            Socket cs = ss.accept();

            System.out.println("Client connected");

            DataInputStream serverInput = new DataInputStream(cs.getInputStream());
            DataOutput serverOutput = new DataOutputStream(cs.getOutputStream());

            String str = serverInput.readUTF();
            int n = str.length();

            int nums[] = new int[n / 2 + 1];
            char operater[] = new char[n / 2];

            int idx1 = 0;
            int idx2 = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    nums[idx1] = str.charAt(i) - 48;
                    idx1++;
                } else {
                    operater[idx2] = str.charAt(i);
                    idx2++;
                }
            }

            int ans = calculate(nums,operater);
            serverOutput.writeInt(ans);
            cs.close();
        }
    }
}
