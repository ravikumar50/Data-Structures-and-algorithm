import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CS {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Echo Program");
        System.out.println("2. Adding the two numbers");
        System.out.println("3. Designing a calculator");
        System.out.println("4. Finding ASCII value of a character");
        System.out.println("5. Factorial of number");
        System.out.println("6. Close the connection");
        while(true){
            Socket cs = new Socket("localhost",8788);
            DataInputStream csInput = new DataInputStream(cs.getInputStream());
            DataOutputStream csOutput = new DataOutputStream(cs.getOutputStream());
            System.out.println("Enter the choice");
            int x = sc.nextInt();
            csOutput.writeInt(x);

            if(x==1){
                System.out.println("Enter the String");
                String s = sc.next();
                csOutput.writeUTF(s);
            }else if(x==2){
                System.out.println("Enter two numbers");
                int a = sc.nextInt();
                int b = sc.nextInt();
                csOutput.writeInt(a);
                csOutput.writeInt(b);
                int sum = csInput.readInt();
                System.out.println("Sum of these numbers is "+sum);
            }else if(x==3){
                System.out.println("Enter two numbers");
                int a = sc.nextInt();
                int b = sc.nextInt();
                csOutput.writeInt(a);
                csOutput.writeInt(b);
                int arr[] = new int[5];
                for(int i=0; i<5; i++){
                    arr[i] = csInput.readInt();
                }
                System.out.println("Addition of these two number is "+arr[0]);
                System.out.println("Subtraction of these two number is "+arr[1]);
                System.out.println("Multiplication of two these number is "+arr[2]);
                System.out.println("Division of these two number is "+arr[3]);
                System.out.println("Modulus of these two number is "+arr[4]);
            }else if(x==4){
                System.out.println("Enter the Character");
                char ch = sc.next().charAt(0);
                csOutput.writeChar(ch);
                int ans = csInput.readInt();
                System.out.println("ASCII value of this character is "+ans);
            }else if(x==5){
                System.out.println("Enter the number");
                int a = sc.nextInt();
                csOutput.writeInt(a);
                int ans = csInput.readInt();
                System.out.println("Factorial of the given number is "+ans);
            }else{
                System.out.println("Disconnected");
                break;
            }
            System.out.println();
        }
    }
}
