import java.net.*;
import java.nio.ByteBuffer;

import com.sun.nio.sctp.*;

public class ClientSide {

    public static void main(String[] args) throws Exception {
        // Server address and port
        String serverAddress = "localhost";
        int serverPort = 9090;

        // Connect to the server
        SctpChannel clientChannel = SctpChannel.open();
        InetSocketAddress serverAddr = new InetSocketAddress(serverAddress, serverPort);
        clientChannel.connect(serverAddr);

        // Send two numbers to the server
        int num1 = 10;
        int num2 = 20;
        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.putInt(num1);
        buffer.putInt(num2);
        buffer.flip();

        // Send data on the primary stream (stream number 0)
        MessageInfo messageInfo = MessageInfo.createOutgoing(null, 0);
        clientChannel.send(buffer, messageInfo);

        System.out.println("Numbers sent to server: " + num1 + " and " + num2);

        // Receive the sum from the server
        buffer.clear();
        messageInfo = clientChannel.receive(buffer, null, null);
        buffer.flip();
        int sum = buffer.getInt();
        System.out.println("Sum received from server: " + sum);

        // Close the channel
        clientChannel.close();
    }
}
