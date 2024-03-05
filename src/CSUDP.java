import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class CSUDP {
    public static void main(String args[]) throws IOException
    {
        System.out.println("Connected");
        Scanner sc = new Scanner(System.in);

        // Step 1:Create the socket object for
        // carrying the data.
        DatagramSocket ds = new DatagramSocket();

        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
        byte buf2[] = null;

        // loop while user not enters "bye"
        System.out.println("Enter the choice");
        System.out.println("1. Adding two numbers");
        System.out.println("2. Subtracting two numbers");
        System.out.println("3. Multiplying two Two numbers");
        System.out.println("4. Dividing Two numbers");
        System.out.println("5. Modulus of two numbers");

        while (true)
        {
            String inp = sc.nextLine();
            int x = sc.nextInt();
            System.out.println("Enter two numbers");
            int a = sc.nextInt();
            int b = sc.nextInt();

            // convert the String input into the byte array.
            buf = inp.getBytes();



            // Step 2 : Create the datagramPacket for sending
            // the data.
            DatagramPacket DpSend =
                    new DatagramPacket(buf, buf.length, ip, 1234);



            // Step 3 : invoke the send call to actually send
            // the data.
            ds.send(DpSend);

            // break the loop if user enters "bye"
            if (inp.equals("bye"))
                break;
        }
    }
}
