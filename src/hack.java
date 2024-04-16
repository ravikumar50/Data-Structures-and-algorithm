import java.net.*;
import java.util.Scanner;

public class hack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 99999 as first number to close the program");

        try {

            while (true) {
                DatagramSocket clientSocket = new DatagramSocket();
                InetAddress serverIP = InetAddress.getByName("localhost");
                byte[] sendData;
                byte[] receiveData = new byte[1024];


                System.out.println("Enter the First Number");
                double a = sc.nextDouble();
                if(a==99999){
                    System.out.println("Program Closed");
                    return;
                }

                System.out.println("Enter the Second Number");
                double b = sc.nextDouble();
                System.out.println("Enter the Operator");
                char operator = sc.next().charAt(0);

                // Convert data to bytes and send to the server
                String data = a + "," + b + "," + operator;
                sendData = data.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, 9876);
                clientSocket.send(sendPacket);


                // Receive result from the server
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String result = new String(receivePacket.getData()).trim();
                double ans = Double.valueOf(result);
                if (ans == Double.MAX_VALUE) {
                    System.out.println("Wrong operator Entered");
                } else {
                    if (operator == '+') {
                        System.out.println("Addition of " + a + " and " + b + " is " + ans);
                    } else if (operator == '-') {
                        System.out.println("Subtraction of " + a + " and " + b + " is " + ans);
                    } else if (operator == '*') {
                        System.out.println("Multiplication of " + a + " and " + b + " is " + ans);
                    } else {
                        System.out.println("Division of " + a + " and " + b + " is " + ans);
                    }
                }

                // Close the socket
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
