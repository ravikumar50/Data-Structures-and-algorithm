package Socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class clientUdp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        DatagramSocket ds = new DatagramSocket();

        /* Logic behind the implementation of code
	       I have taken the expression as a String and then I have converted that
	       String into ArrayList.

	       And then in that ArrayList firstly I have search for '*' and '/' and
	       evaluated that expression and put the evaluated result at the same place
	       and then I have search for '+' and '-' and do the same thing.

	       And I have done this thing till the size of ArrayList becomes 1;
	       And that remaining thing in the ArrayList is the evaluated answer.
	    */

        System.out.println("Enter the expression to be evaluated");
        String str = sc.nextLine();

        byte b[] = str.getBytes();

        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(b, b.length, ia, 9999);

        ds.send(dp);

        byte b1[] = new byte[10];
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length);

        ds.receive(dp1);

        String ans = new String(dp1.getData());
        System.out.println(ans);
    }
}
