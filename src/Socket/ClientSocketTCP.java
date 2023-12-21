package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketTCP {
    public static void main(String[] args)  throws Exception
    {

        Scanner sc = new Scanner(System.in);

        Socket cs = new Socket("localhost",8888);

        DataInputStream csInput = new DataInputStream(cs.getInputStream());
        DataOutputStream csOutput = new DataOutputStream(cs.getOutputStream());

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

        csOutput.writeUTF(str);
        int size = csInput.readInt();

        if(size>9) {
            System.out.println("You have Enter extra expression than reqiured");
            System.out.println("Please enter upto 9 expression");
            return;
        }
        float ans = csInput.readFloat();

        System.out.println("The ans is : "+ans);



    }
}
