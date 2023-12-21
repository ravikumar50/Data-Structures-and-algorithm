package RMI;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) throws Exception{

        AddInterface stub = (AddInterface)Naming.lookup("rmi://localhost:6789/ravi");

        int ans = stub.Add(4,6);

        System.out.println(ans);

    }
}
