package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server2{
    public static void main(String[] args) throws Exception{

        ArrayRemote stub = new ArrayRemote();
        LocateRegistry.createRegistry(2425);
        Naming.rebind("rmi://localhost:2425/ravi",stub);
        System.out.println("Server has Started");
    }
}